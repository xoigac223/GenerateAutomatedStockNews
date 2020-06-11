package maucau.phiensang;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import maucau.MauCauDuaTrenBigStock;
import maucau.iMauCau;

import java.lang.Math;

import stockmarket.BigStock;

public class MauCauChotSang1 extends MauCauDuaTrenBigStock implements iMauCau{
	private static List<String> cauTang;
	private static List<String> cauGiam;
	String symbol = null;
	double chenhLech = 0;
	double diemHienTai = 0;
	double soCoPhieu = 0;
	
	public MauCauChotSang1(BigStock bs) {
		super(bs);
		symbol = stock.getSymbol();
		chenhLech = Math.round( (stock.getGiaChotPhienSang() - stock.getGiaMoCua()) );
		diemHienTai = stock.getGiaChotPhienSang();
		soCoPhieu = stock.getVolume();
		cauTang = new ArrayList<String>();
		cauGiam = new ArrayList<String>();
		setupcauTang();
		setupcauGiam();
	}
	
	public void setupcauTang() {
		cauTang.add("Chốt phiên sáng " + symbol + " tăng " + chenhLech + " điểm, lên " + diemHienTai
				+ " điểm, tương ứng " + soCoPhieu + " cổ phiếu." );
		cauTang.add("Cuối phiên sáng " + symbol + " tăng " + chenhLech + " điểm, lên " + diemHienTai
				+ " điêm, tương ứng " + soCoPhieu + " cổ phiếu." );
		cauTang.add("Cuối phiên sáng " + symbol + " tăng " + chenhLech + " điểm, lên " + diemHienTai
				+ " điểm, tương ứng " + soCoPhieu + " cổ phiếu." );
		cauTang.add("Kết thúc phiên sáng " + symbol + " tăng " + chenhLech + " điểm, lên " + diemHienTai
				+ " điểm, tương ứng " + soCoPhieu + " cổ phiếu." );
		cauTang.add(symbol + " tăng " + chenhLech + " điểm, lên " + diemHienTai + " điểm sau phiên sáng." );
	}
	
	public void setupcauGiam() {
		cauGiam.add("Cuối phiên sáng " + symbol + " giảm " + chenhLech + " điểm, xuống " + diemHienTai
				+ " điểm." );
		cauGiam.add("Chốt phiên sáng " + symbol + " giảm " + chenhLech + " điểm, xuống " + diemHienTai
				+ " điểm." );
		cauGiam.add(symbol + " giảm " + chenhLech + " điểm, xuống " + diemHienTai + " điểm sau phiên sáng." );
		cauGiam.add("Hết phiên sáng, " + symbol + " giảm " + chenhLech + " điểm, bất chấp dấu hiệu khởi sắc trong giao dịch những phút đầu của phiên.");
	}
	


	public String sinhCau() {
		String mauCauChotSang = null;
		if (chenhLech >= 0) {
			mauCauChotSang = cauTang.get(new Random().nextInt(cauTang.size()));
		} else {
			mauCauChotSang = cauGiam.get(new Random().nextInt(cauGiam.size()));
		}
		return mauCauChotSang;
	}
}
