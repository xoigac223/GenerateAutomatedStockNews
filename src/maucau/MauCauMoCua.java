package maucau;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import stockmarket.BigStock;

public class MauCauMoCua extends MauCauDuaTrenBigStock implements MauCau{
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
		
		dauCauTang.add("Tiếp tục tín hiệu khởi sắc từ hôm qua, bước vào đầu phiên giao dịch, ");
		dauCauTang.add("Mở cửa hôm nay, ");
		dauCauTang.add("Mở cửa phiên sáng nay, ");
		dauCauTang.add("Trước đó, lúc mở cửa phiên, tiếp nối đà tăng từ hôm trước, ");
		
		dauCauGiam.add("Mở cửa hôm nay, ");
		dauCauGiam.add("Mở cửa phiên sáng nay, ");
		
		giuaCauTang.add(" tăng thêm ");
		giuaCauTang.add(" tiếp tục tín hiệu lạc quan khi nhích thêm ");
		giuaCauTang.add(" cộng thêm ");
		
		giuaCauGiam.add(" điều chỉnh và giảm ");

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
		sb.append(" điểm, dừng ở "); sb.append(giaMoCuaHomNay); sb.append(".");
		mauCauMoCua = sb.toString();
		return mauCauMoCua;
	}
}