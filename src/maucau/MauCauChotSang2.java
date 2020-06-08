package maucau;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

import stockmarket.Stock;

public class MauCauChotSang2 implements iMauCau{
	private static List<String> cauTang;
	private static List<String> cauGiam;
	private Map<String, Stock> stockMap;
	private int soMaTang = 0;
	private int soMaGiam = 0;
	
	public MauCauChotSang2(Map<String, Stock> stockMap) {
		this.stockMap = stockMap;
		cauTang = new ArrayList<String>();
		cauGiam = new ArrayList<String>();
		setupMa();
		setupCauGiam();
		setupCauTang();
	}
	
	public void setupCauTang() {
		cauTang.add("Kết thúc phiên sáng, thị trường chứng khoán nhuộm sắc xanh với "+soMaTang + " mã đi lên và "+
				soMaGiam +" mã đi xuống.");
		cauTang.add("Thị trường chuyển biến tích cực với " +soMaTang + " mã đi lên và " + 
			soMaGiam + " mã đi xuống.");
	}
	
	public void setupCauGiam() {
		cauGiam.add("Kết thúc phiên sáng, thị trường chứng khoán nhuộm đỏ với "+soMaGiam + " mã đi xuống");
		cauGiam.add("Thị trường chuyển biến xấu đi với " +soMaGiam + " mã nhuộm đỏ sau phiên sáng.");
	}
	
	public void setupMa() {
		for (Map.Entry<String, Stock> entry : stockMap.entrySet()) {
			double chenhLech = entry.getValue().getGiaChotPhienSang() - entry.getValue().getGiaMoCua();
            if(chenhLech >= 0 ) 
            	this.soMaTang +=1;     
            else
            	this.soMaGiam +=1;
        }
	}
	
	public String sinhCau() {
		String MauCauChotSang2;
		if (soMaTang >= soMaGiam) {
			MauCauChotSang2 = cauTang.get(new Random().nextInt(cauTang.size()));
		} 
		else {
			MauCauChotSang2 = cauGiam.get(new Random().nextInt(cauGiam.size()));
		}
		return MauCauChotSang2;
	}
	
}
