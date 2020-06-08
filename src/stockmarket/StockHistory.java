package stockmarket;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import readfile.ReadFiles;

public class StockHistory {
	
	private Date today;
	private Map<Date, Stock> stockHistory;
	
	public StockHistory(ReadFiles f) {
		stockHistory = new HashMap<Date, Stock>();
		String[][] s = f.getArray();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		try {
			today = (Date) dateFormat.parse(s[0][1]);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		for (int i = 0; i < s.length; i++) {
			String symbol = s[i][0];
			Date date = null;
			try {
				date = (Date) dateFormat.parse(s[i][1]);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			double giaMoCua = Double.parseDouble(s[i][2]);
			double giaGiuaPhienSang = Double.parseDouble(s[i][3]);
			double giaChotPhienSang = Double.parseDouble(s[i][4]);
			double giaDauPhienChieu = Double.parseDouble(s[i][5]);
			double giaGiuaPhienChieu = Double.parseDouble(s[i][6]);
			double giaDongCua = Double.parseDouble(s[i][7]);
			double giaThapNhat = Double.parseDouble(s[i][8]);
			double giaCaoNhat = Double.parseDouble(s[i][9]);
			double volume = Double.parseDouble(s[i][10]);
			Stock stock = new Stock(symbol, date, giaMoCua, giaGiuaPhienSang, giaChotPhienSang, giaDauPhienChieu, giaGiuaPhienChieu, giaDongCua, giaThapNhat, giaCaoNhat, volume);
			stockHistory.put(date, stock);
		}
	}
	
	
	public Date getToday() {
		return today;
	}
	
	public Map<Date, Stock> getStockHistory() {
		return stockHistory;
	}

	public Stock getStockToday() {
		return stockHistory.get(today);
	}
	public Stock getStock(int n) {
		Calendar c = Calendar.getInstance();
		c.setTime(today);
		c.add(Calendar.DAY_OF_MONTH, n);
		return stockHistory.get(c.getTime());
	}
	public int getSizeHistory() {
		return stockHistory.size();
	}
	
}
