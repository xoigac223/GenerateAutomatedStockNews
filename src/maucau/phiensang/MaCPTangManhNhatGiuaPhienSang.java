package maucau.phiensang;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import maucau.MauCauDuaTrenStockExchange;
import maucau.iMauCau;
import stockmarket.StockExchange;

public class MaCPTangManhNhatGiuaPhienSang extends MauCauDuaTrenStockExchange implements iMauCau {
	
	private static List<String> moDau;
	private static List<String> giuaCauTang;
	
	
	public MaCPTangManhNhatGiuaPhienSang(StockExchange se) {
		super(se);
		moDau = new ArrayList<String>();
		giuaCauTang = new ArrayList<String>();
		
		moDau.add("Đến giữa phiên sáng nay ghi nhận mã ");
		moDau.add("Sau khởi đầu tốt ở đầu phiên sáng, đến giữa phiên mã ");
		moDau.add("Nghỉ giữa phiên sáng, mã ");
		
		giuaCauTang.add(" trở thành mã cổ phiếu tăng nhanh nhất qua đó, xác lập kỷ lục mới với mức tăng ");
		giuaCauTang.add(" vượt lên đầu sau khi cạnh tranh khốc liệt với các mã khác khi có mức tăng  ");
		giuaCauTang.add(" đã bỏ xa hầu hết các mã còn lại với mức tăng cao nhất là ");
		giuaCauTang.add(" đã bùng nổ trở thành mã tăng mạnh nhất vói mức tăng ");
		
	}
	
	public String sinhCau() {
		
		String maCPTangManhNhatGiuaPhienSang = null;
		List<String> array = stockExchange.sapXepLaiMaCoPhieu();
		int sizeArray = array.size();
		StringBuffer sb = new StringBuffer();
		String dauCau = moDau.get(new Random().nextInt(moDau.size()));
		String giuaCau = giuaCauTang.get(new Random().nextInt(giuaCauTang.size()));	
		sb.append(dauCau); sb.append(array.get(sizeArray-1)); sb.append(giuaCau); 
		sb.append(stockExchange.getThayDoiCoPhieu().get(array.get(sizeArray-1))); sb.append("%"); sb.append(".");
		maCPTangManhNhatGiuaPhienSang = sb.toString();
		
		return maCPTangManhNhatGiuaPhienSang ;
		
	}

}
