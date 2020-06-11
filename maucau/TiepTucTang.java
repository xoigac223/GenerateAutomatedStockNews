<<<<<<< HEAD
package maucau;

import java.util.ArrayList;
import java.util.Random;

import stockmarket.BigStock;

public class TiepTucTang extends MauCau {
	private static ArrayList<String> dauCau = new ArrayList<String>();
	private static ArrayList<String> giuaCau1 = new ArrayList<String>();
	private static ArrayList<String> giuaCau2 = new ArrayList<String>();
	
	private void maucau() {
		dauCau.add("Tiếp đà tăng của phiên sáng, ");
		dauCau.add("Tiếp đà tăng của phiên sáng nay, ");
		dauCau.add("Tiếp đà tăng của phiên giao dịch sáng nay, ");
		dauCau.add("Nối dài sắc xanh từ phiên sáng, ");
		dauCau.add("Nối dài sắc xanh của phiên giao dịch sáng nay, ");
		
		giuaCau1.add(" tiếp tục tăng ");
		giuaCau1.add(" tăng thêm ");
		giuaCau1.add(" cộng thêm ");
		
		giuaCau2.add(" lên ");
		giuaCau2.add(" đạt ");
		giuaCau2.add(" đạt mốc ");
	}
	
	@Override
	public String sinhCau (BigStock stock) {
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
=======
package maucau;

import java.util.ArrayList;
import java.util.Random;

import stockmarket.BigStock;

public class TiepTucTang extends MauCau {
	private static ArrayList<String> dauCau = new ArrayList<String>();
	private static ArrayList<String> giuaCau1 = new ArrayList<String>();
	private static ArrayList<String> giuaCau2 = new ArrayList<String>();
	
	private void maucau() {
		dauCau.add("Tiếp đà tăng của phiên sáng, ");
		dauCau.add("Tiếp đà tăng của phiên sáng nay, ");
		dauCau.add("Tiếp đà tăng của phiên giao dịch sáng nay, ");
		dauCau.add("Nối dài sắc xanh từ phiên sáng, ");
		dauCau.add("Nối dài sắc xanh của phiên giao dịch sáng nay, ");
		
		giuaCau1.add(" tiếp tục tăng ");
		giuaCau1.add(" tăng thêm ");
		giuaCau1.add(" cộng thêm ");
		
		giuaCau2.add(" lên ");
		giuaCau2.add(" đạt ");
		giuaCau2.add(" đạt mốc ");
	}
	
	@Override
	public String sinhCau (BigStock stock) {
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
>>>>>>> 2a6a882432db4013e019f6b914ac2c2b927134ce
