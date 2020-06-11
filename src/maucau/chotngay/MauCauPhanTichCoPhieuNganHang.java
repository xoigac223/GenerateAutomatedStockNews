package maucau.chotngay;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

import maucau.MauCauDuaTrenStockExchange;
import maucau.iMauCau;
import stockmarket.*;

public class MauCauPhanTichCoPhieuNganHang extends MauCauDuaTrenStockExchange implements iMauCau {
	private static List<String> cau;
	private Map<String, Stock> nganHang ;
	public static String[] maNganHang= {"STB","VCB","CTG","EIB","MBB","BID","VPB","HDB","TPB","TCB"};
	
	public MauCauPhanTichCoPhieuNganHang(StockExchange se) {
		super(se);
		this.nganHang = se.getStockMap();
		cau = new ArrayList<String>();
		setupCau();
	}
	
	public void setupCau() {
		String temp = "Nhóm cổ phiếu chiếm tỷ trọng lớn nhất thị trường là ngân hàng với các mã: ";
		for(String i : maNganHang) {
			double chenhLech = (this.nganHang.get(i).getGiaDongCua() - this.nganHang.get(i).getGiaMoCua())/this.nganHang.get(i).getGiaMoCua() * 100;
			chenhLech = Math.round(chenhLech*100.0)/100.0;
			temp += this.nganHang.get(i).getSymbol() + "(" + chenhLech + "%), ";
		}
		temp += "...";
		cau.add(temp);
	}
	
	public String sinhCau() {
		String MauCauPhanTichCoPhieuNganHang;
		MauCauPhanTichCoPhieuNganHang = cau.get(new Random().nextInt(cau.size()));
		return MauCauPhanTichCoPhieuNganHang;
	}
}
