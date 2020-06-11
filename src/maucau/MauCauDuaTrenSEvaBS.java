package maucau;

import stockmarket.BigStock;
import stockmarket.StockExchange;

public abstract class MauCauDuaTrenSEvaBS {
	
	protected BigStock stock;
	protected StockExchange stockExchange;
	
	public MauCauDuaTrenSEvaBS (BigStock bs, StockExchange se) {
		stock = bs;
		stockExchange = se; 
	}
	public abstract String sinhCau();
}
