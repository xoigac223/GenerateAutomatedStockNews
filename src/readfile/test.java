package readfile;

import stockmarket.*;

public class test {
	public static void main(String[] args) {
		ReadFiles r = new ReadFiles("C:\\Users\\daonv\\OneDrive\\Documents\\Java\\BaiTapLon\\data\\CafeF.HSX.CSV.04.06.2020.csv");
		StockExchange se = new StockExchange(r,"Sở Giao dịch Chứng khoán Thành phố Hồ Chí Minh", "HOSE");
		se.printStockMap();
	}
}

