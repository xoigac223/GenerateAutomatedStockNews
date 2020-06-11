package maucau;

import java.util.ArrayList;
import java.util.Random;

import stockmarket.BigStock;

public class TangSangGiamChieu extends MauCau {
	private static ArrayList<String> dauCau = new ArrayList<String>();
	private static ArrayList<String> giuaCau1 = new ArrayList<String>();
	private static ArrayList<String> giuaCau2 = new ArrayList<String>();
	
	private void maucau() {
		dauCau.add("Trái với phiên sáng, thị trường đã khả quan hơn, ");
		dauCau.add("Trái với phiên giao dịch sáng nay, thị trường đã khả quan hơn, ");
		dauCau.add("Bước vào phiên giao dịch chiều với sắc xanh đã quay trở lại, ");
		dauCau.add("Tín hiệu lạc quan đã quay trở lại khi bước vào đầu phiên giao dịch chiều, ");
		dauCau.add("Sắc xanh đã quay trở lại khi phiên giao dịch chiều bắt đầu, ");
		
		giuaCau1.add(" tiếp tục giảm ");
		giuaCau1.add(" giảm thêm ");
		giuaCau1.add(" mất thêm ");
		
		giuaCau2.add(" xuống ");
		giuaCau2.add(" còn ");
		giuaCau2.add(" xuống còn ");
		giuaCau2.add(" chạm mốc ");
	}
	
	@Override
	public String sinhCau(BigStock stock) {
		String cau;
		StringBuffer sb = new StringBuffer();
		String symbol = stock.getSymbol();
		double delta = stock.getGiaDauPhienChieu() - stock.getGiaChotPhienSang();
		int cachviet = new Random().nextInt(2);
		
		String daucau = dauCau.get(new Random().nextInt(dauCau.size()));
		String giuacau1 = giuaCau1.get(new Random().nextInt(giuaCau1.size()));
		String giuacau2 = giuaCau2.get(new Random().nextInt(giuaCau2.size()));
		
		sb.append(daucau); sb.append(symbol);
		if (cachviet == 0) {
			sb.append(giuacau1); sb.append(delta); sb.append(" điểm,");
			sb.append(giuacau2); sb.append(stock.getGiaDauPhienChieu()); sb.append(" điểm.");
		} else {
			sb.append(giuacau2); sb.append(stock.getGiaDauPhienChieu()); sb.append(" điểm,");
			sb.append(giuacau1); sb.append(delta); sb.append(" điểm.");
		}
		
		cau = sb.toString();
		return cau;
	}
}
