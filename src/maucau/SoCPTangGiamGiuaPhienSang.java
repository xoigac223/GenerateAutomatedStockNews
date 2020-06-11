package maucau;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import stockmarket.BigStock;
import stockmarket.StockExchange;

public class SoCPTangGiamGiuaPhienSang implements MauCau {
	
	private static List<String> moDau;
	private static List<String> giuaCauTang;
	private static List<String> giuaCauGiam;
	
	private BigStock stock;
	private StockExchange sE;
	
	public SoCPTangGiamGiuaPhienSang(BigStock stock) {
		
		this.stock = stock;
		moDau = new ArrayList();
		giuaCauTang = new ArrayList();
		giuaCauGiam = new ArrayList();
		
		moDau.add("Nghỉ giữa phiên sáng, thị trường thu hẹp khoản cách hơn với ");
		moDau.add("Đến giữa phiên sáng nay, dao dịch biến động với ");
		moDau.add("Nghỉ giữa phiên sáng, có ");
		
		giuaCauTang.add(" tăng thêm ");
		giuaCauTang.add(" cộng thêm ");
		giuaCauTang.add(" có thêm ");
		
		giuaCauGiam.add(" giảm ");
		giuaCauGiam.add(" mất thêm ");

	}
	
	public String sinhCau() {
		String soCPTangGiamGiuaPhienSang = null;
		StringBuffer sb = new StringBuffer();
		String dauCau = moDau.get(new Random().nextInt(moDau.size()));
		String giuaCau;
		String symbol = stock.getSymbol();
		double giaMoCuaHomNay = stock.getGiaMoCua();
		double giaGiuaPhien = stock.getGiaGiuaPhienSang();
		double chenhLech = giaGiuaPhien - giaMoCuaHomNay;
		
		if(chenhLech >= 0) {
			giuaCau = giuaCauTang.get(new Random().nextInt(giuaCauTang.size()));
		}
		else {
			giuaCau = giuaCauGiam.get(new Random().nextInt(giuaCauGiam.size()));
			chenhLech = -chenhLech;
		}
		
		sb.append(dauCau); sb.append(sE.timSoCoPhieuGiamGia()); sb.append(" mã tăng và "); sb.append(sE.timSoCoPhieuGiamGia());
		sb.append(" mã giảm, "); sb.append(symbol); sb.append(giuaCau); sb.append(String.format("%3g", chenhLech));
		sb.append(" điểm, dừng ở "); sb.append(giaGiuaPhien); sb.append(".");
		soCPTangGiamGiuaPhienSang = sb.toString();
		
		return soCPTangGiamGiuaPhienSang;
	}

}
