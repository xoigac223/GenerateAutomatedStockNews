package maucau;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import stockmarket.BigStock;

<<<<<<< HEAD
public class MauCauMoCua extends MauCauDuaTrenBigStock implements MauCau{
=======
public class MauCauMoCua extends MauCauDuaTrenBigStock implements iMauCau{
>>>>>>> 2a6a882432db4013e019f6b914ac2c2b927134ce
	private static List<String> dauCauTang; 
	private static List<String> giuaCauTang; 
	private static List<String> dauCauGiam; 
	private static List<String> giuaCauGiam; 
	
	public MauCauMoCua(BigStock stock) {
		super(stock);
		dauCauTang = new ArrayList<String>();
		giuaCauTang = new ArrayList<String>();
		dauCauGiam = new ArrayList<String>();
		giuaCauGiam = new ArrayList<String>();
		
		dauCauTang.add("Tiáº¿p tá»¥c tÃ­n hiá»‡u khá»Ÿi sáº¯c tá»« hÃ´m qua, bÆ°á»›c vÃ o Ä‘áº§u phiÃªn giao dá»‹ch, ");
		dauCauTang.add("Má»Ÿ cá»­a hÃ´m nay, ");
		dauCauTang.add("Má»Ÿ cá»­a phiÃªn sÃ¡ng nay, ");
		dauCauTang.add("TrÆ°á»›c Ä‘Ã³, lÃºc má»Ÿ cá»­a phiÃªn, tiáº¿p ná»‘i Ä‘Ã  tÄƒng tá»« hÃ´m trÆ°á»›c, ");
		
		dauCauGiam.add("Má»Ÿ cá»­a hÃ´m nay, ");
		dauCauGiam.add("Má»Ÿ cá»­a phiÃªn sÃ¡ng nay, ");
		
		giuaCauTang.add(" tÄƒng thÃªm ");
		giuaCauTang.add(" tiáº¿p tá»¥c tÃ­n hiá»‡u láº¡c quan khi nhÃ­ch thÃªm ");
		giuaCauTang.add(" cá»™ng thÃªm ");
		
		giuaCauGiam.add(" Ä‘iá»�u chá»‰nh vÃ  giáº£m ");

	}
	
	public String sinhCau() {
		String mauCauMoCua = null;
		StringBuffer sb = new StringBuffer();
		String dauCau;
		String giuaCau;
		String symbol = stock.getSymbol();
		double giaMoCuaHomNay = stock.getGiaMoCua();
		double giaDongCuaHomTruoc = stock.history(-1).getGiaDongCua();
		double chenhLech = giaMoCuaHomNay - giaDongCuaHomTruoc;
		if (chenhLech >= 0) {
			dauCau = dauCauTang.get(new Random().nextInt(dauCauTang.size()));
			giuaCau = giuaCauTang.get(new Random().nextInt(giuaCauTang.size()));
		} else {
			dauCau = dauCauGiam.get(new Random().nextInt(dauCauGiam.size()));
			giuaCau = giuaCauGiam.get(new Random().nextInt(giuaCauGiam.size()));
			chenhLech = -chenhLech;
		}
		sb.append(dauCau); sb.append(symbol); sb.append(giuaCau); sb.append(String.format("%.3g", chenhLech));
		sb.append(" Ä‘iá»ƒm, dá»«ng á»Ÿ "); sb.append(giaMoCuaHomNay); sb.append(".");
		mauCauMoCua = sb.toString();
		return mauCauMoCua;
	}
}