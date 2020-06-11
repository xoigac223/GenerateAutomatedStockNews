package maucau.phiensang;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import maucau.MauCauDuaTrenBigStock;
import maucau.iMauCau;
import stockmarket.BigStock;

public class GiuaPhienSang extends MauCauDuaTrenBigStock implements iMauCau {
	private static List<String> dauCauTang;
	private static List<String> giuaCauTang;
	private static List<String> dauCauGiam;
	private static List<String> giuaCauGiam;
	
	public GiuaPhienSang(BigStock stock) {
		
		super(stock);
		dauCauTang = new ArrayList<String>();
		giuaCauTang = new ArrayList<String>();
		dauCauGiam = new ArrayList<String>();
		giuaCauGiam = new ArrayList<String>();
		
		dauCauTang.add("Nghỉ giữa phiên sáng, ");
		dauCauTang.add("Tiếp tục đà tăng từ đầu phiên, giữa phiên sáng nay ");
		dauCauTang.add("Tiếp tục tín hiệu khởi sắc sáng nay, ");
		
		giuaCauTang.add(" tăng thêm ");
		giuaCauTang.add(" nhích thêm ");
		giuaCauTang.add(" cộng thêm ");
		giuaCauTang.add(" tăng ");
		
		dauCauGiam.add("Vào giữa phiên sáng nay, ");
		dauCauGiam.add("Tạm nghỉ giữa phiên sáng nay, ");
		
		giuaCauGiam.add(" giảm ");
		giuaCauGiam.add(" tụt ");
		giuaCauGiam.add(" mất ");
		
	}
	
	public String sinhCau() {
		
		String giuaPhienSang = null;
		StringBuffer sb = new StringBuffer();
		String dauCau;
		String giuaCau;
		String symbol = stock.getSymbol();
		double giaMoCuaHomNay = stock.getGiaMoCua();
		double giaGiuaPhien = stock.getGiaGiuaPhienSang();
		double chenhLech = giaGiuaPhien - giaMoCuaHomNay;
		
		if(chenhLech >= 0) {
			dauCau = dauCauTang.get(new Random().nextInt(dauCauTang.size()));
			giuaCau = giuaCauTang.get(new Random().nextInt(giuaCauTang.size()));
		}
		else {
			dauCau = dauCauGiam.get(new Random().nextInt(dauCauGiam.size()));
			giuaCau = giuaCauGiam.get(new Random().nextInt(giuaCauGiam.size()));
			chenhLech = -chenhLech;
		}
		
		sb.append(dauCau); sb.append(symbol); sb.append(giuaCau); sb.append(String.format("%.2g", chenhLech));
		sb.append(" điểm, dừng ở "); sb.append(giaGiuaPhien); sb.append(".");
		giuaPhienSang = sb.toString();
		
		return giuaPhienSang;
		
	}

}