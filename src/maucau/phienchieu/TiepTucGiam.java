package maucau.phienchieu;

import java.util.ArrayList;
import java.util.Random;

import maucau.MauCauDuaTrenBigStock;
import maucau.iMauCau;
import stockmarket.BigStock;

public class TiepTucGiam extends MauCauDuaTrenBigStock implements iMauCau {
	private static ArrayList<String> dauCau = new ArrayList<String>();
	private static ArrayList<String> giuaCau1 = new ArrayList<String>();
	private static ArrayList<String> giuaCau2 = new ArrayList<String>();
	
	public TiepTucGiam(BigStock stock) {
		super(stock);
		dauCau.add("Tiếp đà giảm của phiên sáng, ");
		dauCau.add("Tiếp đà giảm của phiên sáng nay, ");
		dauCau.add("Tiếp đà giảm của phiên giao dịch sáng nay, ");
		dauCau.add("Nối dài sắc đỏ từ phiên sáng, ");
		dauCau.add("Nối dài sắc đỏ của phiên giao dịch sáng nay, ");
		
		giuaCau1.add(" tiếp tục giảm ");
		giuaCau1.add(" giảm thêm ");
		giuaCau1.add(" mất thêm ");
		
		giuaCau2.add(" xuống ");
		giuaCau2.add(" còn ");
		giuaCau2.add(" xuống còn ");
		giuaCau2.add(" chạm mốc ");
	}
	
	public String sinhCau () {
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
			sb.append(giuacau1); sb.append(String.format("%.2g", delta)); sb.append(" điểm,");
			sb.append(giuacau2); sb.append(stock.getGiaDauPhienChieu()); sb.append(" điểm.");
		} else {
			sb.append(giuacau2); sb.append(stock.getGiaDauPhienChieu()); sb.append(" điểm,");
			sb.append(giuacau1); sb.append(String.format("%.2g", delta)); sb.append(" điểm.");
		}
		
		cau = sb.toString();
		return cau;
	}
}
