package maucau.phienchieu;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Random;

import maucau.MauCauDuaTrenBigStock;
import maucau.iMauCau;
import stockmarket.BigStock;

public class NghiGiuaPhien extends MauCauDuaTrenBigStock implements iMauCau{
	private static ArrayList<String> dauCau = new ArrayList<String>();
	private static ArrayList<String> giuaCauTang1 = new ArrayList<String>();
	private static ArrayList<String> giuaCauTang2 = new ArrayList<String>();
	private static ArrayList<String> giuaCauGiam1 = new ArrayList<String>();
	private static ArrayList<String> giuaCauGiam2 = new ArrayList<String>();
	private static ArrayList<String> cuoiCau = new ArrayList<String>();
	private static ArrayList<String> cuoiCauGiuNguyen = new ArrayList<String>();
	
	public NghiGiuaPhien(BigStock stock) {
		super(stock);
		dauCau.add("Lúc nghỉ giữa phiên, ");
		dauCau.add("Nghỉ giữa phiên, ");
		dauCau.add("Nghỉ giữa phiên ngày " + new SimpleDateFormat("dd/MM/yyyy").format(stock.getDate()) + ", ");
		dauCau.add("Nghỉ giữa phiên hôm nay, ");
		dauCau.add("Tạm nghỉ giữa phiên, ");
		dauCau.add("Tạm nghỉ giữa phiên hôm nay, ");
		dauCau.add("Tạm nghỉ giữa phiên ngày " + new SimpleDateFormat("dd/MM/yyyy").format(stock.getDate()) + ", ");
		
		giuaCauTang1.add(" tăng ");
		giuaCauTang1.add(" tăng thêm ");
		giuaCauTang1.add(" cộng thêm ");
		
		giuaCauTang2.add(" lên ");
		giuaCauTang2.add(" đạt ");
		giuaCauTang2.add(" đạt mốc ");
		
		giuaCauGiam1.add(" giảm ");
		giuaCauGiam1.add(" mất ");
		giuaCauGiam1.add(" mất đi ");
		
		giuaCauGiam2.add(" xuống ");
		giuaCauGiam2.add(" xuống còn ");
		giuaCauGiam2.add(" còn ");
		
		
		cuoiCau.add(" so với phiên sáng");
		
		cuoiCauGiuNguyen.add(" giữ nguyên số điểm.");
		cuoiCauGiuNguyen.add(" giữ nguyên số điểm so với cuối phiên sáng.");
		cuoiCauGiuNguyen.add(" giữ nguyên số điểm so với sáng nay.");
	}
	
	public String sinhCau () {
		String cau;
		StringBuffer sb = new StringBuffer();
		String symbol = stock.getSymbol();
		double delta = stock.getGiaDauPhienChieu() - stock.getGiaChotPhienSang();
		String giuacau1, giuacau2, cuoicau;
		String giunguyen;
		int cachviet = new Random().nextInt(2);
		
		String daucau = dauCau.get(new Random().nextInt(dauCau.size()));
		if (delta > 0) {
			giuacau1 = giuaCauTang1.get(new Random().nextInt(giuaCauTang1.size()));
			giuacau2 = giuaCauTang2.get(new Random().nextInt(giuaCauTang2.size()));
			cuoicau = cuoiCau.get(new Random().nextInt(cuoiCau.size()));
			if (cachviet == 0) {
				sb.append(daucau); sb.append(symbol);
				sb.append(giuacau1); sb.append(String.format("%.2g", delta)); sb.append(" điểm,");
				sb.append(giuacau2); sb.append(stock.getGiaDauPhienChieu()); sb.append(" điểm");
				sb.append(cuoicau);
			} else {
				sb.append(daucau); sb.append(symbol);
				sb.append(giuacau2); sb.append(stock.getGiaDauPhienChieu()); sb.append(" điểm,");
				sb.append(giuacau1); sb.append(String.format("%.2g", delta)); sb.append(" điểm");
				sb.append(cuoicau);
			}
		}
		if (delta < 0) {
			giuacau1 = giuaCauGiam1.get(new Random().nextInt(giuaCauGiam1.size()));
			giuacau2 = giuaCauGiam2.get(new Random().nextInt(giuaCauGiam2.size()));
			cuoicau = cuoiCau.get(new Random().nextInt(cuoiCau.size()));
			if (cachviet == 0) {
				sb.append(daucau); sb.append(symbol);
				sb.append(giuacau1); sb.append(String.format("%.2g", delta)); sb.append(" điểm,");
				sb.append(giuacau2); sb.append(stock.getGiaDauPhienChieu()); sb.append(" điểm");
				sb.append(cuoicau);
			} else {
				sb.append(daucau); sb.append(symbol);
				sb.append(giuacau2); sb.append(stock.getGiaDauPhienChieu()); sb.append(" điểm,");
				sb.append(giuacau1); sb.append(String.format("%.2g", delta)); sb.append(" điểm");
				sb.append(cuoicau);
			}
		}
		if (delta == 0) {
			giunguyen = cuoiCauGiuNguyen.get(new Random().nextInt(cuoiCauGiuNguyen.size()));
			sb.append(daucau); sb.append(symbol); sb.append(giunguyen);
		}
		
		cau = sb.toString();
		return cau;
	}
}
