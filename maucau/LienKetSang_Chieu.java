package maucau;

import java.util.Random;

import stockmarket.BigStock;

public class LienKetSang_Chieu {
	private BigStock stock;
	private NghiGiuaPhien nghigiuaphien = new NghiGiuaPhien();
	private DauPhienChieu dauphienchieu = new DauPhienChieu();
	private TiepTucTang tieptuctang = new TiepTucTang();
	private TiepTucGiam tieptucgiam = new TiepTucGiam();
	private GiamSangTangChieu giam_tang = new GiamSangTangChieu();
	private TangSangGiamChieu tang_giam = new TangSangGiamChieu();
	
	public String chonCau() {
		double delta = stock.getGiaDauPhienChieu() - stock.getGiaChotPhienSang();
		double delta0 = stock.getGiaGiuaPhienSang() - stock.getGiaChotPhienSang();
		String cau = null;
		
		int cachviet = new Random().nextInt(2);
		if (cachviet == 0) {
			int rd = new Random().nextInt(2);
			if (rd == 0) cau = nghigiuaphien.sinhCau(stock);
			else cau = dauphienchieu.sinhCau(stock);
		}
		else {
			if ((delta == 0) || (delta0 == 0)) {
				int rd = new Random().nextInt(2);
				if (rd == 0) cau = nghigiuaphien.sinhCau(stock);
				else cau = dauphienchieu.sinhCau(stock);
			}
			if (delta > 0) {
				if (delta0 > 0) cau = tieptuctang.sinhCau(stock);
				if (delta0 < 0) cau = giam_tang.sinhCau(stock);
			}
			if (delta < 0) {
				if (delta0 < 0) cau = tieptucgiam.sinhCau(stock);
				if (delta0 > 0) cau = tang_giam.sinhCau(stock);
			}
		}
		
		return cau;
	}
}
