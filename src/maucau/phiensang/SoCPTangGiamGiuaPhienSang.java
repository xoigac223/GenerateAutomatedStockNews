package maucau.phiensang;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import maucau.MauCauDuaTrenSEvaBS;
import maucau.iMauCau;
import stockmarket.BigStock;
import stockmarket.StockExchange;

public class SoCPTangGiamGiuaPhienSang extends MauCauDuaTrenSEvaBS implements iMauCau {
	
	private static List<String> moDau;
	private static List<String> giuaCauTang;
	private static List<String> giuaCauGiam;
	

	public SoCPTangGiamGiuaPhienSang(BigStock stock, StockExchange se) {
		super(stock, se);
		moDau = new ArrayList<String>();
		giuaCauTang = new ArrayList<String>();
		giuaCauGiam = new ArrayList<String>();
		
		moDau.add("Nghỉ giữa phiên sáng, thị trường thu hẹp khoảng cách hơn với ");
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
		
		sb.append(dauCau); sb.append(stockExchange.timSoCoPhieuGiamGia()); sb.append(" mã tăng và "); sb.append(stockExchange.timSoCoPhieuGiamGia());
		sb.append(" mã giảm, "); sb.append(symbol); sb.append(giuaCau); sb.append(String.format("%.2g", chenhLech));
		sb.append(" điểm, dừng ở "); sb.append(giaGiuaPhien); sb.append(".");
		soCPTangGiamGiuaPhienSang = sb.toString();
		
		return soCPTangGiamGiuaPhienSang;
	}

}
