package readfile;

import stockmarket.BigStock;
import stockmarket.StockExchange;
import maucau.*;

public class test {
	public static void main(String[] args) {
		ReadFiles r = new ReadFiles("C:\\Users\\daonv\\OneDrive\\Documents\\Java\\BaiTapLon\\data\\input.csv");
		ReadFiles f = new ReadFiles("C:\\Users\\daonv\\OneDrive\\Documents\\Java\\BaiTapLon\\data\\CafeF.HSX.CSV.04.06.2020.csv");
		BigStock vnIndex = new BigStock(r);
		StockExchange se = new StockExchange(f, "Sở giao dịch thành phố Hồ Chí Minh", "HOSE");
		MauCau mauCau1 = new MauCauMoCua(vnIndex);
		MauCau mauCau2 = new MauCauMucThapNhat(vnIndex);
		MauCau mauCau3 = new MaCoPhieuTangManhNhat(se);
		MauCau mauCau4 = new MauCauCoPhieuLon(se);
		System.out.println(mauCau1.sinhCau());
		System.out.println(mauCau2.sinhCau());
		System.out.println(mauCau3.sinhCau());
		System.out.println(mauCau4.sinhCau());
	}
}

