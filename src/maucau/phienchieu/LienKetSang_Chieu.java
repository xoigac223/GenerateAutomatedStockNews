package maucau.phienchieu;

import java.util.Random;

import maucau.MauCauDuaTrenBigStock;
import maucau.iMauCau;
import stockmarket.BigStock;

public class LienKetSang_Chieu extends MauCauDuaTrenBigStock implements iMauCau{
	
	private NghiGiuaPhien nghigiuaphien;
	private DauPhienChieu dauphienchieu;
	private TiepTucTang tieptuctang;
	private TiepTucGiam tieptucgiam;
	private GiamSangTangChieu giam_tang ;
	private TangSangGiamChieu tang_giam;
	
	public LienKetSang_Chieu (BigStock stock) {
		super(stock);
		nghigiuaphien = new NghiGiuaPhien(stock);
		dauphienchieu = new DauPhienChieu(stock);
		tieptuctang = new TiepTucTang(stock);
		tieptucgiam = new TiepTucGiam(stock);
		giam_tang = new GiamSangTangChieu(stock);
		tang_giam = new TangSangGiamChieu(stock);
	}
	
	public String sinhCau() {
		double delta = stock.getGiaDauPhienChieu() - stock.getGiaChotPhienSang();
		double delta0 = stock.getGiaGiuaPhienSang() - stock.getGiaChotPhienSang();
		String cau = null;
		
		int cachviet = new Random().nextInt(2);
		if (cachviet == 0) {
			int rd = new Random().nextInt(2);
			if (rd == 0) cau = nghigiuaphien.sinhCau();
			else cau = dauphienchieu.sinhCau();
		}
		else {
			if ((delta == 0) || (delta0 == 0)) {
				int rd = new Random().nextInt(2);
				if (rd == 0) cau = nghigiuaphien.sinhCau();
				else cau = dauphienchieu.sinhCau();
			}
			if (delta > 0) {
				if (delta0 > 0) cau = tieptuctang.sinhCau();
				if (delta0 < 0) cau = giam_tang.sinhCau();
			}
			if (delta < 0) {
				if (delta0 < 0) cau = tieptucgiam.sinhCau();
				if (delta0 > 0) cau = tang_giam.sinhCau();
			}
		}
		
		return cau;
	}
}
