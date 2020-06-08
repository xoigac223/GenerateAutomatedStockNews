package maucau;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

import stockmarket.Stock;

public class MauCauPhanTichCoPhieuTrongNgay implements iMauCau {
	public List<String> cau;

	private Stock stock;
	private String symbol;

	public MauCauPhanTichCoPhieuTrongNgay(String symbol,Map<String, Stock> stockMap ) {
		this.symbol = symbol;
		this.stock = stockMap.get(symbol);
		cau = new ArrayList<String>();
		setupCau();
	}
	
	public void setupCau() {
		cau.add("Mở đầu phiên sáng, " + symbol + " khởi điểm với " + stock.getGiaMoCua() + " điểm. Đến đầu chiều "
				+ symbol + " đạt " + stock.getGiaDauPhienChieu() + ". Cuối ngày " + symbol + " dừng lại ở " + stock.getGiaDongCua()
				+ " ứng với " + stock.getVolume() + " cổ phiếu.");
		cau.add("Kết thúc ngày với "+ stock.getGiaDongCua() + " điểm, " + symbol + " giao dịch " + stock.getVolume()
				+ " cổ phiếu.");
		
	}
	
	
	
	public String sinhCau() {
		String mauCauInRa ;
		mauCauInRa = cau.get(new Random().nextInt(cau.size()));
		return mauCauInRa;
	}
}
