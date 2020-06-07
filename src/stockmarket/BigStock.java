package stockmarket;

import java.util.Date;
import java.util.Map;

import readfile.*;

public class BigStock extends Stock{
	
	private ReadFiles stockHistoryFile;
	private StockHistory stockHistory;
	
	public BigStock(ReadFiles f) {
		super();
		this.stockHistoryFile = f;
		stockHistory = new StockHistory(stockHistoryFile);
		this.symbol = "VNINDEX";
		Date date = stockHistory.getToday();
		double giaMoCua = stockHistory.getStockToday().getGiaMoCua();
		double giaGiuaPhienSang = stockHistory.getStockToday().getGiaGiuaPhienSang();
		double giaChotPhienSang = stockHistory.getStockToday().getGiaChotPhienSang();
		double giaDauPhienChieu = stockHistory.getStockToday().getGiaDauPhienChieu();
		double giaGiuaPhienChieu = stockHistory.getStockToday().getGiaGiuaPhienChieu();
		double giaDongCua = stockHistory.getStockToday().getGiaDongCua();
		double giaThapNhat = stockHistory.getStockToday().getGiaThapNhat();
		double giaCaoNhat = stockHistory.getStockToday().getGiaCaoNhat();
		double volume = stockHistory.getStockToday().getVolume();
		this.date = date;
		this.giaMoCua = giaMoCua;
		this.giaGiuaPhienSang = giaGiuaPhienSang;
		this.giaChotPhienSang = giaChotPhienSang;
		this.giaDauPhienChieu = giaDauPhienChieu;
		this.giaGiuaPhienChieu = giaGiuaPhienChieu;
		this.giaDongCua = giaDongCua;
		this.giaThapNhat = giaThapNhat;
		this.giaCaoNhat = giaCaoNhat;
		this.volume = volume;
	}
	
	public Stock history(int n) {
		return stockHistory.getStock(n);
	}
	public int sizeHistory() {
		return stockHistory.getSizeHistory();
	}
	public Map<Date, Stock> getHistory() {
		return stockHistory.getStockHistory();
	}
}
