package maucau;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import stockmarket.BigStock;

public class GiuaPhienSangHaiMa implements MauCau {
	
	private static List<String> dauCauTang;
	private static List<String> giuaCauTang;
	private static List<String> dauCauGiam;
	private static List<String> giuaCauGiam;

	private BigStock stock;
	
	public GiuaPhienSangHaiMa(BigStock stock1, BigStock stock2) {
		this.stock = stock1;
		this.stock = stock2;
		dauCauTang = new ArrayList();
		giuaCauTang = new ArrayList();
		dauCauGiam = new ArrayList();
		giuaCauGiam = new ArrayList(); 
		
		dauCauTang.add("Nghỉ giữa phiên, ");
		dauCauTang.add("Tiếp tục đà tăng từ đầu phiên, ");
		dauCauTang.add("Tiếp tục tín hiệu khởi sắc sáng nay,  ");
		
		giuaCauTang.add("tăng thêm ");
		giuaCauTang.add("nhích thêm ");
		giuaCauTang.add("cộng thêm ");
		giuaCauTang.add("tăng ");
		
		dauCauGiam.add("Vào giữa phiên sáng nay, ");
		dauCauGiam.add("Tạm nghỉ giữa phiên sáng nay, ");
		
		giuaCauGiam.add("giảm ");
		giuaCauGiam.add("tụt ");
		giuaCauGiam.add("mất ");
		
	}
	
	public String sinhCau() {
		
		String giuaPhienSangHaiMa = null;
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
		
		sb.append(dauCau); sb.append(symbol); sb.append(giuaCau); sb.append(String.format("%3g", chenhLech));
		sb.append(" điểm, dừng ở "); sb.append(giaGiuaPhien); sb.append(" , trong khi ");
		sb.append(dauCau); sb.append(symbol); sb.append(giuaCau); sb.append(String.format("%3g", chenhLech));
		sb.append(" điểm, dừng ở "); sb.append(giaGiuaPhien); sb.append(".");
		giuaPhienSangHaiMa = sb.toString();
		
		return giuaPhienSangHaiMa;
		
	}

}

