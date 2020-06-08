package maucau;

import java.util.ArrayList;
import java.util.List;

import stockmarket.StockExchange;

public class MauCauNhomNganh extends MauCauDuaTrenStockExchange implements MauCau {
	
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

