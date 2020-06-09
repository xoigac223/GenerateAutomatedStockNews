package maucau;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import stockmarket.BigStock;
import stockmarket.StockExchange;

public class TangGiamCaoNhatGiuaPhienSang implements iMauCau{
	
	private static List<String> moDautang;
	private static List<String> moDauGiam;
	private static List<String> giuaCauTang1;
	private static List<String> giuaCauGiam1;
	private static List<String> giuaCauTang2;
	private static List<String> giuaCauGiam2;
	private static List<String> cuoiCauTang;
	private static List<String> cuoiCauGiam;
	
	private BigStock stock;
	
	public TangGiamCaoNhatGiuaPhienSang(BigStock stock) {
		
		this.stock = stock;
		moDautang = new ArrayList<String>();
		moDauGiam = new ArrayList<String>();
		giuaCauTang1 = new ArrayList<String>();
		giuaCauGiam1 = new ArrayList<String>();
		giuaCauTang2 = new ArrayList<String>();
		giuaCauGiam2 = new ArrayList<String>();
		cuoiCauTang= new ArrayList<String>();
		cuoiCauGiam = new ArrayList<String>();
		
		moDautang.add("Tín hiệu khởi sắc đã xuất hiện vào giữa phiên sáng nay, ");
		moDautang.add("Sau đầu phiên sáng với mức tăng phi mã, đến giữa phiên sáng nay, ");
		moDautang.add("Nghỉ giữa phiên sáng nay, ");
		moDautang.add("Tiếp tục đà tăng những ngày qua, bước vào giữa phiên sáng nay, ");
		
		moDauGiam.add("Sau mở đầu ảm đạm, đến giữa phiên sáng nay, ");
		moDauGiam.add("Màu sắc u ám tiếp tục bao trùm lên toàn thị trường khi đến giữa phiên sáng, ");
		moDauGiam.add("Thị trường tiếp tục cho thấy sự yếu kém khi giữa phiên sáng nay, ");
		
		giuaCauTang1.add(" tăng mạnh ");
		giuaCauTang1.add(" có thêm ");
		
		giuaCauGiam1.add(" giảm mạnh ");
		giuaCauGiam1.add(" mất thêm ");
		
		giuaCauTang2.add(" điểm, chạm đỉnh ");
		giuaCauTang2.add(" điểm, xác lập kỷ lục ");
		giuaCauTang2.add(" điểm, đạt đỉnh ");
		
		giuaCauGiam2.add(" điểm, chạm đáy ");
		giuaCauGiam2.add(" điểm, chỉ còn ");
		
		cuoiCauTang.add(", đạt mức tăng cao nhất trong tuần qua.");
		cuoiCauTang.add(", có thể sẽ là đợt tăng cao nhất trong tháng này.");
		
		cuoiCauGiam.add(", đây là mức giảm thấp nhất trong tuần qua.");
		cuoiCauGiam.add(", xác lập mức giảm thấp nhất trong tháng.");
		cuoiCauGiam.add(", có thể sẽ là mức giảm thấp nhất trong tuần.");
		
	}
	
	public String sinhCau() {
		
		String tangGiamCaoNhat = null;
		StringBuffer sb = new StringBuffer();
		String dauCau;
		String giuaCau1;
		String giuaCau2;
		String cuoiCau;
		String symbol = stock.getSymbol();
		double giaMoCuaHomNay = stock.getGiaMoCua();
		double giaGiuaPhien = stock.getGiaGiuaPhienSang();
		double chenhLech = giaGiuaPhien - giaMoCuaHomNay;
		
		if(chenhLech >= 0) {
			dauCau = moDautang.get(new Random().nextInt(moDautang.size()));
			giuaCau1 = giuaCauTang1.get(new Random().nextInt(giuaCauTang1.size()));
			giuaCau2 = giuaCauTang2.get(new Random().nextInt(giuaCauTang2.size()));
			cuoiCau = cuoiCauTang.get(new Random().nextInt(cuoiCauTang.size()));
		}
		else {
			dauCau = moDauGiam.get(new Random().nextInt(moDauGiam.size()));
			giuaCau1 = giuaCauGiam1.get(new Random().nextInt(giuaCauGiam1.size()));
			giuaCau2 = giuaCauGiam2.get(new Random().nextInt(giuaCauGiam2.size()));
			cuoiCau = cuoiCauGiam.get(new Random().nextInt(cuoiCauGiam.size()));
			chenhLech = -chenhLech;
		}
		
		
			sb.append(dauCau); sb.append(symbol); sb.append(giuaCau1); sb.append(chenhLech); sb.append(giuaCau2);
			sb.append(giaGiuaPhien); sb.append(cuoiCau);
		
		
		
		tangGiamCaoNhat = sb.toString();

		return tangGiamCaoNhat;
		
	}

}
