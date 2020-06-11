package maucau;

import java.util.List;

import stockmarket.StockExchange;

<<<<<<< HEAD
<<<<<<< HEAD
public class MaCoPhieuTangManhNhat extends MauCauDuaTrenStockExchange implements MauCau{
=======
public class MaCoPhieuTangManhNhat extends MauCauDuaTrenStockExchange implements iMauCau{
>>>>>>> 2a6a882432db4013e019f6b914ac2c2b927134ce

	public MaCoPhieuTangManhNhat(StockExchange se) {
		super(se);
	}
	
=======
public class MaCoPhieuTangManhNhat implements MauCau {
	private StockExchange stockExchange;
	
	public MaCoPhieuTangManhNhat(StockExchange se) {
		stockExchange = se;
	}
>>>>>>> 374f65ae75b8d985f29ae0dca5ace26f3ba022b2
	public String sinhCau() {
		String mauCauMaCoPhieuTangNhanhNhat = null;
		List<String> array = stockExchange.sapXepLaiMaCoPhieu();
		int sizeArray = array.size();
		StringBuffer sb = new StringBuffer();
		sb.append("Trong ngày hôm nay, "); sb.append(array.get(sizeArray-1)); sb.append(", ");
		sb.append(array.get(sizeArray-2)); sb.append(", "); sb.append(array.get(sizeArray-3));
		sb.append(" là các mã cố phiếu có mức tăng nhanh nhất, với mức tăng mạnh nhất là ");
		sb.append(stockExchange.getThayDoiCoPhieu().get(array.get(sizeArray-1)));
		sb.append(" % \n"); sb.append("Trong khi đó, "); sb.append(array.get(0)); sb.append(", ");
		sb.append(array.get(1)); sb.append(", "); sb.append(array.get(2)); sb.append(" là các mã cổ phiếu có mức giảm nhanh nhất");
		sb.append(" với mức giảm mạnh nhất là "); sb.append(stockExchange.getThayDoiCoPhieu().get(array.get(0)));
		sb.append(" %");
		mauCauMaCoPhieuTangNhanhNhat = sb.toString();
		return mauCauMaCoPhieuTangNhanhNhat;
	}
}
