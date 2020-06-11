package maucau;

import java.util.Map;

import stockmarket.StockExchange;

<<<<<<< HEAD
public class MauCauCoPhieuLon extends MauCauDuaTrenStockExchange implements MauCau {
=======
public class MauCauCoPhieuLon extends MauCauDuaTrenStockExchange implements iMauCau {
>>>>>>> 2a6a882432db4013e019f6b914ac2c2b927134ce
	
	public MauCauCoPhieuLon(StockExchange se) {
		super(se);
	}
	
	
	public String sinhCau() {
		StringBuffer sb1 = new StringBuffer();
		Map<String, Double> thayDoi = stockExchange.getThayDoiCoPhieu();
		double thayDoiVNM = thayDoi.get("VNM");
		double thayDoiVCB = thayDoi.get("VCB");
		if (stockExchange.getSymbolStockExchange() == "HOSE") {
			if (thayDoiVNM > 0) {
				sb1.append("Một số mã cố phiếu lớn như VNM tăng "); sb1.append(thayDoiVNM);
				sb1.append(" %, ");
			} else if (thayDoiVNM == 0) {
				sb1.append("Một số mã cố phiếu lớn như VNM giữ nguyên điểm,  ");
			} else {
				sb1.append("Một số mã cố phiếu lớn như VNM giảm "); sb1.append(-thayDoiVNM);
				sb1.append(" %, ");
			}
			if (thayDoiVCB > 0) {
				sb1.append("VCB tăng "); sb1.append(thayDoiVCB);
				sb1.append(" %.");
			} else if (thayDoiVNM == 0) {
				sb1.append("VCB thì giữ nguyên điểm.");
			} else {
				sb1.append("VCB giảm "); sb1.append(-thayDoiVCB);sb1.append(" %");
			}
		}
		return sb1.toString();
	}
}
