package maucau;

import java.util.ArrayList;
import java.util.List;

import stockmarket.StockExchange;

<<<<<<< HEAD
public class MauCauNhomNganh extends MauCauDuaTrenStockExchange implements MauCau {
=======
public class MauCauNhomNganh extends MauCauDuaTrenStockExchange implements iMauCau {
>>>>>>> 2a6a882432db4013e019f6b914ac2c2b927134ce
	
	private static List<String> maCoPhieuNhomNganhBDS;
	private static List<String> maCoPhieuNhomNganhCongNgheVienThong;
	private static List<String> maCoPhieuDichVuDuLich;
	private static List<String> maCoPhieuYTe;
	private static List<String> maCoPhieuNangLuong;
	private static List<String> maCoPhieuThuySan;
	private static List<String> maCoPhieuNganHang;
	
	public MauCauNhomNganh(StockExchange se) {
		super(se);
		maCoPhieuNhomNganhBDS = new ArrayList<String>();
		maCoPhieuNhomNganhCongNgheVienThong = new ArrayList<String>();
		maCoPhieuDichVuDuLich = new ArrayList<String>();
	}
	
		public String sinhCau() {
			String mauCauNhomNganh = "Hello";
			return mauCauNhomNganh;
		}
}

