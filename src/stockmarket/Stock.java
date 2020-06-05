package stockmarket;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Stock {
	protected String symbol;
	protected Date date;
	protected double openingPrice;
	protected double highestPrice;
	protected double lowestPrice;
	protected double closingPrice;
	protected double volumn;
	
	public Stock() {
		
	}
		
	public Stock(String symbol, Date date, double openingPrice, double highestPrice, double lowestPrice,
			double closingPrice, double volumn) {
		this.symbol = symbol;
		this.date = date;
		this.openingPrice = openingPrice;
		this.highestPrice = highestPrice;
		this.lowestPrice = lowestPrice;
		this.closingPrice = closingPrice;
		this.volumn = volumn;
	}


	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public double getOpeningPrice() {
		return openingPrice;
	}
	public void setOpeningPrice(double openingPrice) {
		this.openingPrice = openingPrice;
	}
	public double getHighestPrice() {
		return highestPrice;
	}
	public void setHighestPrice(double highestPrice) {
		this.highestPrice = highestPrice;
	}
	public double getLowestPrice() {
		return lowestPrice;
	}
	public void setLowestPrice(double lowestPrice) {
		this.lowestPrice = lowestPrice;
	}
	public double getClosingPrice() {
		return closingPrice;
	}
	public void setClosingPrice(double closingPrice) {
		this.closingPrice = closingPrice;
	}
	public double getVolumn() {
		return volumn;
	}
	public void setVolumn(double volumn) {
		this.volumn = volumn;
	}
	
	public void printStock() {
		System.out.printf("%s - %s, %s, %s, %s, %s, %s", symbol, new SimpleDateFormat("dd/MM/yyyy").format(date), openingPrice, highestPrice, lowestPrice, closingPrice, volumn);
		System.out.println();
	}
}
