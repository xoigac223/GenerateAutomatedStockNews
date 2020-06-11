package maucau.chotngay;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import maucau.MauCauDuaTrenStockExchange;
import maucau.iMauCau;
import stockmarket.Stock;
import stockmarket.StockExchange;

public class MauCauPhanTichCoPhieuTrongNgay extends MauCauDuaTrenStockExchange implements iMauCau {
	public List<String> cau;

	private Stock stock;
	private String symbol;

	public MauCauPhanTichCoPhieuTrongNgay(String symbol, StockExchange se) {
		super(se);
		this.symbol = symbol;
		this.stock = se.getStockMap().get(symbol);
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
