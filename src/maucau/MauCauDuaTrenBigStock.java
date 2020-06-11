package maucau;

import stockmarket.BigStock;

public abstract class MauCauDuaTrenBigStock {
	
	protected BigStock stock;
	
	public MauCauDuaTrenBigStock(BigStock stock) {
		this.stock = stock;
	}
	public abstract String sinhCau();
}
