package maucau.phiensang;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import maucau.MauCauDuaTrenSEvaBS;
import maucau.iMauCau;
import stockmarket.*;

public class MoCuaSoCoPhieu extends MauCauDuaTrenSEvaBS implements iMauCau{
	private static List<String> giuaCauTang; 
	private static List<String> giuaCauGiam; 

	
	public MoCuaSoCoPhieu(BigStock stock,StockExchange se ) {
		super(stock,se);
		giuaCauTang = new ArrayList<String>();
		giuaCauGiam = new ArrayList<String>();
		
		giuaCauTang.add(" mã tăng lên");
		giuaCauTang.add(" mã nhích thêm");
		giuaCauTang.add(" mã tăng điểm");
		
		giuaCauGiam.add(" mã điều chỉnh và giảm");
		giuaCauGiam.add(" mã giảm điểm");
		giuaCauGiam.add(" mã tụt điểm");
		giuaCauGiam.add(" mã lao dốc");

	}
	public String sinhCau() {
		String MoCuaSoCoPhieu = null;
		StringBuffer sb = new StringBuffer();
		String giuaTang;
		String giuaGiam;
		String symbol = stock.getSymbol();
		double timSoCoPhieuTangGia = stockExchange.timSoCoPhieuTangGia();
		double SoLuongCoPhieu = stockExchange.getSoLuongCoPhieu();
		double timSoCoPhieuGiamGia = stockExchange.timSoCoPhieuGiamGia();
		giuaTang = giuaCauTang.get(new Random().nextInt(giuaCauTang.size()));
		giuaGiam = giuaCauGiam.get(new Random().nextInt(giuaCauGiam.size()));
		sb.append("Mở cửa đầu phiên giao dịch có nhiều sự biến động,trong tổng số ");sb.append(String.format("%.3g", SoLuongCoPhieu));
		sb.append(" của sàn ");sb.append(symbol);sb.append(" ,trong đó có ");sb.append(String.format("%.3g", timSoCoPhieuTangGia));
		sb.append(giuaTang);sb.append(" và ");sb.append(String.format("%.3g", timSoCoPhieuGiamGia));sb.append(giuaGiam);
		sb.append(".");
		MoCuaSoCoPhieu = sb.toString();
		return MoCuaSoCoPhieu;
	}
}