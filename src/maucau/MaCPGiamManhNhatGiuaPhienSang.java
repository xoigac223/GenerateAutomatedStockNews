package maucau;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import stockmarket.StockExchange;


<<<<<<< HEAD
public class MaCPGiamManhNhatGiuaPhienSang extends MauCauDuaTrenStockExchange implements MauCau {
=======
public class MaCPGiamManhNhatGiuaPhienSang extends MauCauDuaTrenStockExchange implements iMauCau {
>>>>>>> 2a6a882432db4013e019f6b914ac2c2b927134ce
	
	private static List<String> moDau;
	private static List<String> giuaCauGiam;
	private static List<String> cuoiCau;
	
	private StockExchange se;
	
	public MaCPGiamManhNhatGiuaPhienSang(StockExchange se) {
		
		super(se);
		moDau = new ArrayList<String>();
		giuaCauGiam = new ArrayList<String>();
		cuoiCau = new ArrayList<String>();
		
		moDau.add("Sau khi thị trường giao dịch trở lại thì đến giữa phiên sáng nay, mã ");
		moDau.add("Với khởi đầu ảm đạm ở đầu phiên, đến giữa phiên sáng nay, mã ");
		moDau.add("Xuất hiện một vài tín hiệu không khả quan trên thị trường khiến mã ");
		
		giuaCauGiam.add(" giảm xuống đáy với mức giảm ");
		giuaCauGiam.add(" trở thành mã giảm sâu nhất với mức giảm ");
		giuaCauGiam.add(" giảm sâu hơn các mã còn lại với mức giảm ");
		
		cuoiCau.add(". Tuy nhiên, một số chuyên gia cho rằng đây rất có thể là cái bẫy mà nhà đầu tư cần phải cẩn trọng.");
		cuoiCau.add(". Điều này có thể vừa là cơ hội vừa là rủi ro cho những nhà đầu tư.");
		cuoiCau.add(". Một số nhà đầu tư đã bắt đầu mua ồ ạt mã này.");
		
	}
	
	public String sinhCau() {
		
		 String maCPGiamManhNhatGiuaPhienSang = null;
		 List<String> array = stockExchange.sapXepLaiMaCoPhieu();
		 int sizeArray = array.size();
		 StringBuffer sb = new StringBuffer();
		 String dauCau = moDau.get(new Random().nextInt(moDau.size()));
		 String giuaCau = giuaCauGiam.get(new Random().nextInt(giuaCauGiam.size()));
		 String cauNoi = cuoiCau.get(new Random().nextInt(cuoiCau.size()));
		 
		 sb.append(dauCau); sb.append(array.get(0)); sb.append(giuaCau); 
		 sb.append(stockExchange.getThayDoiCoPhieu().get(array.get(0))); sb.append(" %");
		 sb.append(cauNoi);
		 maCPGiamManhNhatGiuaPhienSang = sb.toString();
			
		 return maCPGiamManhNhatGiuaPhienSang;
		
		
	}

}