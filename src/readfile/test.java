package readfile;

import stockmarket.BigStock;
import maucau.*;

public class test {
	public static void main(String[] args) {
		ReadFiles r = new ReadFiles("C:\\Users\\daonv\\OneDrive\\Documents\\Java\\BaiTapLon\\data\\input.csv");
		BigStock vnIndex = new BigStock(r);
		MauCau mauCau = new MauCauMoCua(vnIndex);
		System.out.println(mauCau.sinhCau());
	}
}

