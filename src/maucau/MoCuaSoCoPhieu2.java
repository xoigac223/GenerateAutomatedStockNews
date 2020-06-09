package maucau;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import stockmarket.*;

public class MoCuaSoCoPhieu2 implements MauCau{
	private static List<String> dauCauTang; 
	private static List<String> giuaCauTang;
	private static List<String> dauCauOnDinh;
	private static List<String> dauCauGiam; 
	private static List<String> giuaCauGiam; 
	private BigStock stock;
	private StockExchange se;
	
	public MoCuaSoCoPhieu2(BigStock stock,StockExchange se ) {
		this.stock = stock;
		this.se = se;
		dauCauTang = new ArrayList<String>();
		dauCauOnDinh = new ArrayList<String>();
		giuaCauTang = new ArrayList<String>();
		dauCauGiam = new ArrayList<String>();
		giuaCauGiam = new ArrayList<String>();

		dauCauTang.add("Mở cửa hôm nay, bảng cổ phiếu tràn nghập mã blue,");
		
		
		dauCauOnDinh.add("Mở cửa phiên sáng nay,bảng mã khá hài hòa ");
		dauCauOnDinh.add("Mở cửa phiên sáng nay,bảng mã khá ổn định ");
		
		
		dauCauGiam.add("Mở cửa hôm nay, tràn ngập sắc đỏ");
		dauCauGiam.add("Mở cửa phiên sáng nay, sàn có nhiều sắc đỏ");
		
		giuaCauTang.add(" tăng lên ");
		giuaCauTang.add(" tiếp tục tín hiệu lạc quan khi nhích thêm ");
		giuaCauTang.add(" cộng điểm ");
		
		giuaCauGiam.add(" điều chỉnh và giảm ");
		giuaCauGiam.add("mã điều chỉnh và giảm");
		giuaCauGiam.add("mã giảm điểm");
		giuaCauGiam.add("mã tụt điểm");
		giuaCauGiam.add("mã lao dốc");

	}
	
	public String sinhCau() {
		String mauCauMoCua = null;
		StringBuffer sb = new StringBuffer();
		String dauCau;
		String giuaTang;
		String giuaGiam;
		String symbol = stock.getSymbol();
		double timSoCoPhieuTangGia = se.timSoCoPhieuTangGia();
		double SoLuongCoPhieu = se.getSoLuongCoPhieu();
		double timSoCoPhieuGiamGia = se.timSoCoPhieuGiamGia();
		giuaTang = giuaCauTang.get(new Random().nextInt(giuaCauTang.size()));
		giuaGiam = giuaCauGiam.get(new Random().nextInt(giuaCauGiam.size()));
		double chenhLech =timSoCoPhieuTangGia-timSoCoPhieuGiamGia;
		if (chenhLech >= 10) {
			dauCau = dauCauTang.get(new Random().nextInt(dauCauTang.size()));
		} else {if(chenhLech>=-10){
				dauCau = dauCauOnDinh.get(new Random().nextInt(dauCauOnDinh.size()));
		}else{
			dauCau = dauCauGiam.get(new Random().nextInt(dauCauGiam.size()));
		}
		}
		sb.append(dauCau);sb.append(String.format("%.3g", SoLuongCoPhieu));
		sb.append("của sàn ");sb.append(symbol);sb.append(",trong đó có");sb.append(String.format("%.3g", timSoCoPhieuTangGia));
		sb.append(giuaTang);sb.append("và");sb.append(String.format("%.3g", timSoCoPhieuGiamGia));sb.append(giuaGiam);
		sb.append(".");
		mauCauMoCua = sb.toString();
		return mauCauMoCua;
	}
}