package maucau;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import stockmarket.BigStock;
import stockmarket.Stock;

public class MauCauMucThapNhat implements MauCau{
	private BigStock stock;
	
	public MauCauMucThapNhat(BigStock stock) {
		this.stock = stock;
	}
	
	public String sinhCau() {
		String mauCauMucThapNhat = null;
		double mucThapNhat = tinhMucThapNhat();
		double mucThapNhatHomNay = stock.getGiaThapNhat();
		StringBuffer sb = new StringBuffer();
		double chenhLech = mucThapNhatHomNay - mucThapNhat;
		if (chenhLech > 0) {
			sb.append("Như vậy, trong ngày hôm nay chỉ số ");
			sb.append(stock.getSymbol());
			sb.append(" đạt mức thấp nhất là "); sb.append(mucThapNhatHomNay); sb.append(" điểm, cao hơn mức thấp nhất trong 3 năm qua ");
			sb.append(String.format("%.3g", chenhLech)); sb.append(" điểm.");
		} else {
			sb.append("Như vậy, trong ngày hôm nay chỉ số "); sb.append(stock.getSymbol()); sb.append(" đạt mức thấp nhất trong 3 năm qua");
			sb.append(" Khi xuống mốc "); sb.append(mucThapNhatHomNay); sb.append(" điểm.");
		}
		mauCauMucThapNhat = sb.toString();
		return mauCauMucThapNhat;
	}
	
	public double tinhMucThapNhat() {
		double mucThapNhat = stock.getGiaThapNhat();
		Map<Date, Stock> history = new HashMap<Date, Stock>();
		history = stock.getHistory();
		for (Stock stock : history.values()) {
			if (mucThapNhat > stock.getGiaThapNhat()) mucThapNhat = stock.getGiaThapNhat();
		}
		return mucThapNhat;
	}
}
