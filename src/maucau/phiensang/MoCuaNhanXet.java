package maucau.phiensang;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import maucau.MauCauDuaTrenBigStock;
import maucau.iMauCau;
import stockmarket.BigStock;

public class MoCuaNhanXet extends MauCauDuaTrenBigStock implements iMauCau{
	private static List<String> dauCauTichCuc;	
	private static List<String> giuaCauTang; 
	private static List<String> dauCauTieuCuc; 
	private static List<String> giuaCauGiam; 
	private static List<String> dauCauOnDinh;
	
	public MoCuaNhanXet(BigStock stock) {
		super(stock);
		dauCauTichCuc = new ArrayList<String>();
		giuaCauTang = new ArrayList<String>();
		dauCauTieuCuc = new ArrayList<String>();
		giuaCauGiam = new ArrayList<String>();
		dauCauOnDinh = new ArrayList<String>();
		
		dauCauTichCuc.add("Sắc xanh của phiên cuối tuần trước tiếp tục được duy trì trên sàn ");
		
		dauCauTieuCuc.add("Sắc đỏ của phiên cuối tuần trước tiếp tục được duy trì trên sàn ");
		
		dauCauOnDinh.add("Mở đầu phiên giao dịch, cổ phiếu nhận tín hiệu trái ngược với tuần trước cụ thể ");
		
		giuaCauTang.add(" tăng thêm ");
		giuaCauTang.add(" tiếp tục tín hiệu lạc quan khi nhích thêm ");
		giuaCauTang.add(" cộng thêm ");
		
		giuaCauGiam.add(" điều chỉnh và giảm ");
		giuaCauGiam.add("giảm điểm");
		giuaCauGiam.add("tụt điểm");

	}
	
	public String sinhCau() {
		String moCuaNhanXet = null;
		StringBuffer sb = new StringBuffer();
		String dauCau;
		String giuaCau;
		String symbol = stock.getSymbol();
		double giaMoCuaHomNay = stock.getGiaMoCua();
		double giaDongCuaHomTruoc = stock.history(-1).getGiaDongCua();
		double chenhLechHomNay = giaMoCuaHomNay - giaDongCuaHomTruoc;
		
		
		double giaMoCuaTuanTruoc = stock.history(-7).getGiaMoCua();
		double giaDongCuaTuanTruoc = stock.history(-8).getGiaDongCua();
		double chenhLechTuanTruoc = giaMoCuaTuanTruoc - giaDongCuaTuanTruoc;
		
		
		if ((chenhLechHomNay>0)&&(chenhLechTuanTruoc>0)) {
			dauCau = dauCauTichCuc.get(new Random().nextInt(dauCauTichCuc.size()));
		}else{
		if((chenhLechHomNay<0)&&(chenhLechTuanTruoc<0)){
			dauCau = dauCauTieuCuc.get(new Random().nextInt(dauCauTieuCuc.size()));
		}else{
			dauCau = dauCauOnDinh.get(new Random().nextInt(dauCauOnDinh.size()));
		}
		}
		if (chenhLechHomNay >= 0) {
			giuaCau = giuaCauTang.get(new Random().nextInt(giuaCauTang.size()));
		} else{
			giuaCau = giuaCauGiam.get(new Random().nextInt(giuaCauGiam.size()));
			chenhLechHomNay = -chenhLechHomNay;
		}
		sb.append(dauCau); sb.append(symbol); sb.append(" hôm nay ");sb.append(giaMoCuaHomNay);sb.append(giuaCau);sb.append("với độ tăng ");
		sb.append(String.format("%.3g", chenhLechHomNay)); sb.append(" điểm");sb.append(".");
		moCuaNhanXet = sb.toString();
		return moCuaNhanXet;
	}
}