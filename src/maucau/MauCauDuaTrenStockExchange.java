package maucau;

import stockmarket.StockExchange;

public abstract class MauCauDuaTrenStockExchange {
	protected StockExchange stockExchange;
	
	public MauCauDuaTrenStockExchange(StockExchange stockExchange) {
		this.stockExchange = stockExchange;
	}
	public abstract String sinhCau();
	
}
