package readfile;

import stockmarket.BigStock;
import stockmarket.StockExchange;
import maucau.*;

public class test {
	public static void main(String[] args) {
		ReadFiles r = new ReadFiles("C:\\Users\\daonv\\OneDrive\\Documents\\Java\\BaiTapLon\\data\\input.csv");
		ReadFiles f = new ReadFiles("C:\\Users\\daonv\\OneDrive\\Documents\\Java\\BaiTapLon\\data\\CafeF.HSX.CSV.04.06.2020.csv");
		BigStock vnIndex = new BigStock(r);
		MauCau mauCau = new MauCauMucThapNhat(vnIndex);
		System.out.println(mauCau.sinhCau());
		StockExchange se = new StockExchange(f, "Sàn giao dịch Hồ Chí Minh", "HOSE");
		System.out.println(se.getSoLuongCoPhieu());
		System.out.println(se.timSoCoPhieuTangGia());
		System.out.println(se.timSoCoPhieuGiamGia());
		System.out.println(se.timSoCoPhieuGiuNguyenGia());
	}
}

