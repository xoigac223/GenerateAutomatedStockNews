package maucau;

import stockmarket.StockExchange;

public abstract class MauCauDuaTrenStockExchange implements iMauCau {
	protected StockExchange stockExchange;
	
	public MauCauDuaTrenStockExchange(StockExchange se) {
		stockExchange = se;
	}
	public abstract String sinhCau();
	
}
