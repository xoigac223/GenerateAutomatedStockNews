package maucau;

import stockmarket.StockExchange;

<<<<<<< HEAD
public abstract class MauCauDuaTrenStockExchange {
	protected StockExchange stockExchange;
	
	public MauCauDuaTrenStockExchange(StockExchange stockExchange) {
		this.stockExchange = stockExchange;
=======
public abstract class MauCauDuaTrenStockExchange implements iMauCau {
	protected StockExchange stockExchange;
	
	public MauCauDuaTrenStockExchange(StockExchange se) {
		stockExchange = se;
>>>>>>> 2a6a882432db4013e019f6b914ac2c2b927134ce
	}
	public abstract String sinhCau();
	
}
