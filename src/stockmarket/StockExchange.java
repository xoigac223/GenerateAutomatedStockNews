package stockmarket;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import readfile.ReadFiles;

public class StockExchange {
	
	private String nameStockExchange;
	private String symbolStockExchange;
	private Map<String, Stock> stockMap;

	
	public StockExchange(ReadFiles f, String nameStockExchange, String symbolStockExchange) {
		stockMap = new HashMap<String, Stock>();
		this.nameStockExchange = nameStockExchange;
		this.symbolStockExchange = symbolStockExchange;
		createStockMap(f.getArray());
		
	}
	
	public void createStockMap(String[][] s) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		for (int i = 0; i < s.length; i++) {
			String symbol = s[i][0];
			Date date = null;
			try {
				date = (Date) dateFormat.parse(s[i][1]);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			double openingPrice = Double.parseDouble(s[i][2]);
			double highestPrice = Double.parseDouble(s[i][3]);
			double lowestPrice = Double.parseDouble(s[i][4]);
			double closingPrice = Double.parseDouble(s[i][5]);
			double volumn = Double.parseDouble(s[i][6]);
			stockMap.put(symbol, new Stock(symbol, date, openingPrice, highestPrice, lowestPrice, closingPrice, volumn));

		}
		
	}
	public void printStockMap() {
		System.out.println("Tên sàn chứng khoán: " + nameStockExchange + " - " + symbolStockExchange);
		for (Stock stock: stockMap.values()) {
	        stock.printStock();
	    }
	}
	
	
}

