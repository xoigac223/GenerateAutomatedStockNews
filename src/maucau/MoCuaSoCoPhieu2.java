package maucau;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import stockmarket.*;

public class MoCuaSoCoPhieu2 implements iMauCau{
	private static List<String> dauCauTang; 
	private static List<String> giuaCauTang;
	private static List<String> dauCauOnDinh;
	private static List<String> dauCauGiam; 
	private static List<String> giuaCauGiam; 
	private BigStock stock;
	private StockExchange se;
	
	public MoCuaSoCoPhieu2(BigStock stock,StockExchange se ) {
		this.stock = stock;
		this.se = se;
		dauCauTang = new ArrayList<String>();
		dauCauOnDinh = new ArrayList<String>();
		giuaCauTang = new ArrayList<String>();
		dauCauGiam = new ArrayList<String>();
		giuaCauGiam = new ArrayList<String>();

		dauCauTang.add("Má»Ÿ cá»­a hÃ´m nay, báº£ng cá»• phiáº¿u trÃ n ngháº­p mÃ£ blue,");
		
		
		dauCauOnDinh.add("Má»Ÿ cá»­a phiÃªn sÃ¡ng nay,báº£ng mÃ£ khÃ¡ hÃ i hÃ²a ");
		dauCauOnDinh.add("Má»Ÿ cá»­a phiÃªn sÃ¡ng nay,báº£ng mÃ£ khÃ¡ á»•n Ä‘á»‹nh ");
		
		
		dauCauGiam.add("Má»Ÿ cá»­a hÃ´m nay, trÃ n ngáº­p sáº¯c Ä‘á»�");
		dauCauGiam.add("Má»Ÿ cá»­a phiÃªn sÃ¡ng nay, sÃ n cÃ³ nhiá»�u sáº¯c Ä‘á»�");
		
		giuaCauTang.add(" tÄƒng lÃªn ");
		giuaCauTang.add(" tiáº¿p tá»¥c tÃ­n hiá»‡u láº¡c quan khi nhÃ­ch thÃªm ");
		giuaCauTang.add(" cá»™ng Ä‘iá»ƒm ");
		
		giuaCauGiam.add(" Ä‘iá»�u chá»‰nh vÃ  giáº£m ");
		giuaCauGiam.add("mÃ£ Ä‘iá»�u chá»‰nh vÃ  giáº£m");
		giuaCauGiam.add("mÃ£ giáº£m Ä‘iá»ƒm");
		giuaCauGiam.add("mÃ£ tá»¥t Ä‘iá»ƒm");
		giuaCauGiam.add("mÃ£ lao dá»‘c");

	}
	
	public String sinhCau() {
		String mauCauMoCua = null;
		StringBuffer sb = new StringBuffer();
		String dauCau;
		String giuaTang;
		String giuaGiam;
		String symbol = stock.getSymbol();
		double timSoCoPhieuTangGia = se.timSoCoPhieuTangGia();
		double SoLuongCoPhieu = se.getSoLuongCoPhieu();
		double timSoCoPhieuGiamGia = se.timSoCoPhieuGiamGia();
		giuaTang = giuaCauTang.get(new Random().nextInt(giuaCauTang.size()));
		giuaGiam = giuaCauGiam.get(new Random().nextInt(giuaCauGiam.size()));
		double chenhLech =timSoCoPhieuTangGia-timSoCoPhieuGiamGia;
		if (chenhLech >= 10) {
			dauCau = dauCauTang.get(new Random().nextInt(dauCauTang.size()));
		} else {if(chenhLech>=-10){
				dauCau = dauCauOnDinh.get(new Random().nextInt(dauCauOnDinh.size()));
		}else{
			dauCau = dauCauGiam.get(new Random().nextInt(dauCauGiam.size()));
		}
		}
		sb.append(dauCau);sb.append(String.format("%.3g", SoLuongCoPhieu));
		sb.append("cá»§a sÃ n ");sb.append(symbol);sb.append(",trong Ä‘Ã³ cÃ³");sb.append(String.format("%.3g", timSoCoPhieuTangGia));
		sb.append(giuaTang);sb.append("vÃ ");sb.append(String.format("%.3g", timSoCoPhieuGiamGia));sb.append(giuaGiam);
		sb.append(".");
		mauCauMoCua = sb.toString();
		return mauCauMoCua;
	}
}