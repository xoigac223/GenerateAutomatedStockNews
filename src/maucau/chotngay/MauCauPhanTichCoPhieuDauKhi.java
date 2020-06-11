package maucau.chotngay;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

import maucau.MauCauDuaTrenStockExchange;
import maucau.iMauCau;
import stockmarket.*;

public class MauCauPhanTichCoPhieuDauKhi extends MauCauDuaTrenStockExchange implements iMauCau {
	private static List<String> cau;
	private Map<String, Stock> dauKhi ;
	public static String[] maDauKhi= {"GAS","PLX","PVD","PVT"};
	
	public MauCauPhanTichCoPhieuDauKhi(StockExchange se) {
		super(se);
		this.dauKhi = se.getStockMap();
		cau = new ArrayList<String>();
		setupCau();
	}
	
	public void setupCau() {
		String temp = "Các cổ phiếu nhóm dầu khí có sự biến động với ";
		for(String i : maDauKhi) {
			double chenhLech = (this.dauKhi.get(i).getGiaDongCua() - this.dauKhi.get(i).getGiaMoCua())/this.dauKhi.get(i).getGiaMoCua() * 100;
			chenhLech = Math.round(chenhLech*100.0)/100.0;
			temp += this.dauKhi.get(i).getSymbol() + "(" + chenhLech + "%), ";
		}
		temp += "...";
		cau.add(temp);
	}
	
	public String sinhCau() {
		String MauCauPhanTichCoPhieuDauKhi;
		MauCauPhanTichCoPhieuDauKhi = cau.get(new Random().nextInt(cau.size()));
		return MauCauPhanTichCoPhieuDauKhi;
	}
}
