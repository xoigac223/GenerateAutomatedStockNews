package maucau;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

import maucau.MauCauDuaTrenStockExchange;
import stockmarket.BigStock;
import stockmarket.StockExchange;

public class MauCauChotNgay extends MauCauDuaTrenStockExchange {
	private BigStock data;
	private List<String[]> GiuNguyen;
	private List<String[]> GiamNhe;
	private List<String[]> Giam;
	private List<String[]> GiamManh;
	private List<String[]> GiamLienTuc;
	private List<String[]> TangNhe;
	private List<String[]> Tang;
	private List<String[]> TangManh;
	private List<String[]> TangLienTuc;
	public MauCauChotNgay(BigStock stock, StockExchange stockExchange) {
		super(stockExchange);
		String[] GiuNguyenNgay = {"Số điểm của @symbol@ giữ nguyên khi kết thúc phiên giao dịch hôm nay,@date@ ở mốc @điểm@."};
		String[] GiamNheNgay = {"Kết thúc phiên giao dịch hôm nay, @symbol@ đóng cửa ở @điểm@ điểm, giảm nhẹ @hiệu@ điểm (@tỉ lệ@%)."};
		String[] GiamNgay = {"@symbol@ giảm @hiệu@ điểm vào lúc kết thúc giao dịch, đóng cửa tại @điểm@ điểm (giao dịch @volume@ triệu cổ phiếu)."};
		String[] GiamManhNgay = {"Đóng cửa phiên giao dịch ngày @date@, @symbol@ điều chỉnh mạnh với @mã giảm@ mã sắc đỏ, giảm @tỉ lệ@%, xuống còn @điểm@ điểm."};
		String[] GiamLienTucNgay = {"@symbol@ liên tục chìm trong sắc đỏ cụ thể là @mã giảm@ mã, với mức giảm từ @điểm trước@ xuống còn @điểm@"};
		String[] TangNheNgay = {"@symbol@ chỉ tăng nhẹ so với đợt mở đầu phiên sáng, với thêm @hiệu@ điểm (@tỉ lệ@%), lên mức @điểm@ điểm đạt gần @volume@ KLGD.","Cuối ngày hôm nay, @symbol@ tăng nhẹ @hiệu@ điểm (@tỉ lệ@%), lên @điểm@ điểm."};
		String[] TangNgay = {"Chốt phiên giao dịch ngày @date@, @symbol@ tăng @hiệu@ điểm (@tỉ lệ@%), đạt @điểm@ điểm."};
		String[] TangManhNgay = {"Đóng cửa với @mã tăng@ mã đi lên, @symbol@ tăng mạnh @hiệu@ điểm, dừng ở @điểm@ điểm với @volume@ triệu cổ phiếu giao dịch."};
		String[] TangLienTucNgay = {"Tiếp đà tăng của phiên giao dịch ngày hôm qua, @symbol@ tiếp tục đi lên @hiệu@ điểm(@tỉ lệ@%), đạt @điểm@ điểm trong ngày hôm nay (@date@).","Về cuối ngày với @mã tăng@ mã đi lên, chỉ số VN-Index tiếp tục tăng @tỉ lệ@%, đạt @điểm@ điểm với @volume@ triệu cổ phiếu giao dịch (tương đương @GTGD@ tỉ VND)."};
		
		String[] GiuNguyenTuan = {"Hai lần bằng điểm trong 2 tuần (!date tuần trước!) của @symbol@ tại @điểm@ điểm."};
		String[] TangNheTuan = {"Chỉ số VN-Index liên tục giảm ở các phiên đầu tuần, sau đó tăng lên và kết thúc ở @điểm@ điểm, xấp xỉ mức cuối tuần trước (!điểm tuần trước! điểm vào !date tuần trước!)."};
		String[] TangTuan = {"Sau ngày cuối tuần, @symbol@ được cải thiện khoảng !hiệu tuần trước! điểm so với thời điểm tuần trước chỉ với !điểm tuần trước! điểm (!date tuần trước!), lên @điểm@ điểm."};
		String[] TangManhTuan = {"Sự tăng trưởng của @symbol@ tuần này đã được dự báo từ trước, chạm mốc @điểm@ điểm, hơn !hiệu tuần trước! điểm so với tuần trước là !điểm tuần trước! điểm (!date tuần trước!)."};
		String[] TangLienTucTuan = {"Tiếp nối tín hiệu lạc quan của tuần trước (!date tuần trước!), @symbol@ cán mốc @điểm@ điểm khi kết phiên giao dịch cuối tuần này, tăng !hiệu tuần trước! điểm so với mốc !điểm tuần trước! điểm."};
		String[] GiamNheTuan = {"Kết thúc phiên giao dịch, @symbol@ đóng cửa ở mức @điểm@ điểm, giảm nhẹ !hiệu tuần trước! điểm (!tỉ lệ tuần trước!%) so với cuối tuần trước (!điểm tuần trước! điểm vào !date tuần trước!)."};
		String[] GiamTuan = {"Chỉ số @symbol@ kết thúc tuần tại @điểm@ điểm, thấp hơn cuối tuần trước (!điểm tuần trước! điểm vào !date tuần trước!) !hiệu tuần trước! điểm."};
		String[] GiamManhTuan = {"Kết thúc phiên giao dịch cuối tuấn, chỉ số chứng khoán @symbol@ giảm !hiệu tuần trước! điểm so với !điểm tuần trước! điểm vào cuối tuần trước (!date tuần trước!) còn @điểm@, tương đương gần !tỉ lệ tuần trước!%."};
		String[] GiamLienTucTuan = {"Hai tuần gần đây chứng kiến sự sụt giảm của @symbol@ từ !điểm tuần trước trước! điểm xuống còn @điểm@ điểm."};
		
		String[] TangThang = {"So với cùng thời điểm này tháng trước !date tháng trước!, @symbol@ đã tăng hơn !hiệu tháng trước! điểm so với mốc !điểm tháng trước! điểm lên @điểm@ điểm!"};
		String[] GiamThang = {"@symbol@ đi xuống !hiệu tháng trước! điểm kể từ cùng thời điểm tháng trước(!date tháng trước!), khi ấy đạt !điểm tháng trước!"};
		String[] GiuNguyenThang = {"Dù đã gần 30 ngày nhưng @symbol@ vẫn giữ được trọn vẹn @điểm@ điểm."};
		
		String[] TangQuy = {"Sau 3 tháng @symbol@ đã vươn lên @điểm@ điểm, tích lũy thêm !hiệu quý trước! điểm để thiết lập mốc !điểm quý trước! điểm (!date quý trước!)"};
		String[] GiamQuy = {"@symbol@ thiết lập một mốc sụt giảm mới khi mất !hiệu quý trước! điểm sau 3 tháng (từ !date quý trước!), từ !điểm quý trước! điểm xuống còn @điểm@ điểm."};
		String[] GiuNguyenQuy = {"Cùng một số điểm qua 3 tháng đầy biến động (@điểm@ điểm vào !date quý trước!) chứng tỏ sự ổn định của thị trường @symbol@ trong thời gian vừa qua."};
		
		String[] TangNam = {"@symbol@ tăng vọt !hiệu năm trước! điểm lên @điểm@ điểm so với mốc !điểm năm trước! điểm của năm ngoái (!date năm trước!). "};
		String[] GiamNam = {"Sau 365 ngày (!date năm trước!) thì @symbol@ đã tụt xuống @điểm@ điểm, thấp hơn mức !điểm năm trước! điểm của cùng thời điểm năm ngoài"};
		String[] GiuNguyenNam= {"Qua một năm đầy biến động thì @symbol@ vẫn giữ được số điểm của mình là @điểm@ từ !date năm trước!."};
		
		this.data = stock;
		this.GiuNguyen = new ArrayList<String[]>();
		this.GiamNhe = new ArrayList<String[]>();
		this.Giam = new ArrayList<String[]>();
		this.GiamManh = new ArrayList<String[]>();
		this.GiamLienTuc = new ArrayList<String[]>();
		this.TangNhe = new ArrayList<String[]>();
		this.Tang = new ArrayList<String[]>();
		this.TangManh = new ArrayList<String[]>();
		this.TangLienTuc = new ArrayList<String[]>();
		//Ngày
		GiuNguyen.add(GiuNguyenNgay);
		GiamNhe.add(GiamNheNgay);
		Giam.add(GiamNgay);
		GiamManh.add(GiamManhNgay);
		GiamLienTuc.add(GiamLienTucNgay);
		TangNhe.add(TangNheNgay);
		Tang.add(TangNgay);
		TangManh.add(TangManhNgay);
		TangLienTuc.add(TangLienTucNgay);
		//Tuần
		GiuNguyen.add(GiuNguyenTuan);
		GiamNhe.add(GiamNheTuan);
		Giam.add(GiamTuan);
		GiamManh.add(GiamManhTuan);
		GiamLienTuc.add(GiamLienTucTuan);
		TangNhe.add(TangNheTuan);
		Tang.add(TangTuan);
		TangManh.add(TangManhTuan);
		TangLienTuc.add(TangLienTucTuan);
		//Tháng
		Giam.add(GiamThang);
		Tang.add(TangThang);
		GiuNguyen.add(GiuNguyenThang);
		//Quý
		Giam.add(GiamQuy);
		Tang.add(TangQuy);
		GiuNguyen.add(GiuNguyenQuy);
		//Năm
		Giam.add(GiamNam);
		Tang.add(TangNam);
		GiuNguyen.add(GiuNguyenNam);
	}
	//Ngày
	public String sinhCau() {
		Random rand = new Random();
		double c = data.getGiaDongCua();
		double d = data.history(-1).getGiaDongCua();
		double e = data.history(-2).getGiaDongCua();
		if(c==d) {
			return locCauNgay(this.GiuNguyen.get(0)[rand.nextInt(this.GiuNguyen.get(0).length)]);
		}
		if(c>d) {
			if(d>e)
				return locCauNgay(this.TangLienTuc.get(0)[rand.nextInt(this.TangLienTuc.get(0).length)]);
			if(c-d>=5) 
				return locCauNgay(this.TangManh.get(0)[rand.nextInt(this.TangManh.get(0).length)]);
			if(c-d<=1)
				return locCauNgay(this.TangNhe.get(0)[rand.nextInt(this.TangNhe.get(0).length)]);
			return locCauNgay(this.Tang.get(0)[rand.nextInt(this.Tang.get(0).length)]);
		}
		if(c<d) {
			if(d<e) 
				return locCauNgay(this.GiamLienTuc.get(0)[rand.nextInt(this.GiamLienTuc.get(0).length)]);
			if(d-c>=5) 
				return locCauNgay(this.GiamManh.get(0)[rand.nextInt(this.GiamManh.get(0).length)]);
			if(d-c<=1) 
				return locCauNgay(this.GiamNhe.get(0)[rand.nextInt(this.GiamNhe.get(0).length)]);
			return locCauNgay(this.Giam.get(0)[rand.nextInt(this.Giam.get(0).length)]);
		}
		return "";
	}
	//Tuần
	public String sinhCauTuan() {
		Random rand = new Random();
		int thisWeek = 0;
		int lastWeek = thisWeek - 7;
		int preLastWeek = lastWeek - 7;
		double a = data.history(thisWeek).getGiaDongCua();
		double b = data.history(lastWeek).getGiaDongCua();
		double c = data.history(preLastWeek).getGiaDongCua();
		if(a>b) {
			if(b>c) 
				return locCauTuan(this.TangLienTuc.get(1)[rand.nextInt(this.TangLienTuc.get(1).length)]);
			if(a-b>=5) 
				return locCauTuan(this.TangManh.get(1)[rand.nextInt(this.TangManh.get(1).length)]);
			if(a-b<=1)
				return locCauTuan(this.TangNhe.get(1)[rand.nextInt(this.TangNhe.get(1).length)]);
			return locCauTuan(this.Tang.get(1)[rand.nextInt(this.Tang.get(1).length)]);
		}		
		if(a<b) {
			if(b<c)
				return locCauTuan(this.GiamLienTuc.get(1)[rand.nextInt(this.GiamLienTuc.get(1).length)]);
			if(b-a>=5)
				return locCauTuan(this.GiamManh.get(1)[rand.nextInt(this.GiamManh.get(1).length)]);
			if(b-a<=1)
				return locCauTuan(this.GiamNhe.get(1)[rand.nextInt(this.GiamNhe.get(1).length)]);
			return locCauTuan(this.Giam.get(1)[rand.nextInt(this.Giam.get(1).length)]);
		}
		return locCauTuan(this.GiuNguyen.get(1)[rand.nextInt(this.GiuNguyen.get(1).length)]);
	}
	//Tháng
	public String sinhCauThang() {
		Random rand = new Random();
		int thisMonth = 0;
		int lastMonth = thisMonth - 31;
		while(data.history(lastMonth)==null)
			lastMonth++;
		double a = data.history(thisMonth).getGiaDongCua();
		double b = data.history(lastMonth).getGiaDongCua();
		if(a>b)
			return locCauThang(this.Tang.get(2)[rand.nextInt(this.Tang.get(2).length)]);
		if(a<b)
			return locCauThang(this.Giam.get(2)[rand.nextInt(this.Giam.get(2).length)]);
		return locCauThang(this.GiuNguyen.get(2)[rand.nextInt(this.GiuNguyen.get(2).length)]);
	}
	//Quý
	public String sinhCauQuy() {
		Random rand = new Random();
		int thisQuarter = 0;
		int lastQuarter = thisQuarter - 92;
		while(data.history(lastQuarter)==null)
			lastQuarter++;
		double a = data.history(thisQuarter).getGiaDongCua();
		double b = data.history(lastQuarter).getGiaDongCua();
		if(a>b)
			return locCauQuy(this.Tang.get(3)[rand.nextInt(this.Tang.get(3).length)]);
		if(a<b)
			return locCauQuy(this.Giam.get(3)[rand.nextInt(this.Giam.get(3).length)]);
		return locCauQuy(this.GiuNguyen.get(3)[rand.nextInt(this.GiuNguyen.get(3).length)]);
	}
	//Năm
	public String sinhCauNam() {
		Random rand = new Random();
		int thisYear = 0;
		int lastYear = thisYear - 366;
		while(data.history(lastYear)==null)
			lastYear++;
		double a = data.history(thisYear).getGiaDongCua();
		double b = data.history(lastYear).getGiaDongCua();
		if(a>b)
			return locCauNam(this.Tang.get(4)[rand.nextInt(this.Tang.get(4).length)]);
		if(a<b)
			return locCauNam(this.Giam.get(4)[rand.nextInt(this.Giam.get(4).length)]);
		return locCauNam(this.GiuNguyen.get(4)[rand.nextInt(this.GiuNguyen.get(4).length)]);
	}
	//Tuần
	public String locCauTuan(String sample) {
		String cau = locCauNgay(sample);
		String[] e = cau.split("!");
		StringBuffer kq = new StringBuffer();
		List<String> list = new ArrayList<String>();
		for(String e1 : e) {
			list.add(e1);
		}
		int thisWeek = 0;
		int lastWeek = thisWeek - 7;
		int preLastWeek = lastWeek - 7;
		if(list.contains("date tuần trước")) {
			Calendar a = Calendar.getInstance();
			a.setTime(data.history(lastWeek).getDate());
			list.set(list.indexOf("date tuần trước"),a.get(Calendar.DATE)+"/"+(a.get(Calendar.MONTH)+1));
		}
		if(list.contains("điểm tuần trước"))
			list.set(list.indexOf("điểm tuần trước"), ""+data.history(lastWeek).getGiaDongCua());
		if(list.contains("điểm tuần trước trước"))
			list.set(list.indexOf("điểm tuần trước trước"), ""+data.history(preLastWeek).getGiaDongCua());
		if(list.contains("hiệu tuần trước"))
			list.set(list.indexOf("hiệu tuần trước"), String.format("%.3g", Math.abs(data.history(thisWeek).getGiaDongCua() - data.history(lastWeek).getGiaDongCua())));
		if(list.contains("tỉ lệ tuần trước")) {
			double c = data.history(thisWeek).getGiaDongCua();
			double b = data.history(lastWeek).getGiaDongCua();
			double d = Math.abs((c-b)/b*100);
			list.set(list.indexOf("tỉ lệ tuần trước"),String.format("%.3g", d));
		}
		for(String a : list) {
			kq.append(a);
		}
		return kq.toString();
	}
	//Tháng
	public String locCauThang(String sample) {
		String cau = locCauNgay(sample);
		String[] e = cau.split("!");
		StringBuffer kq = new StringBuffer();
		List<String> list = new ArrayList<String>();
		for(String e1 : e) {
			list.add(e1);
		}
		int thisMonth = 0;
		int lastMonth = thisMonth - 31;
		while(data.history(lastMonth)==null)
			lastMonth++;
		if(list.contains("date tháng trước")) {
			Calendar a = Calendar.getInstance();
			a.setTime(data.history(lastMonth).getDate());
			list.set(list.indexOf("date tháng trước"),a.get(Calendar.DATE)+"/"+(a.get(Calendar.MONTH)+1));
		}
		if(list.contains("điểm tháng trước"))
			list.set(list.indexOf("điểm tháng trước"), data.history(lastMonth).getGiaDongCua()+"");
		if(list.contains("hiệu tháng trước"))
			list.set(list.indexOf("hiệu tháng trước"), String.format("%.3g",Math.abs(data.history(thisMonth).getGiaDongCua()-data.history(lastMonth).getGiaDongCua())));
		for(String e1 : list)
			kq.append(e1);
		return kq.toString();
	}
	//Quý
	public String locCauQuy(String sample) {
		String cau = locCauNgay(sample);
		String[] e = cau.split("!");
		StringBuffer kq = new StringBuffer();
		List<String> list = new ArrayList<String>();
		for(String e1 : e) {
			list.add(e1);
		}
		int thisQuarter = 0;
		int lastQuarter = thisQuarter - 92;
		while(data.history(lastQuarter)==null)
			lastQuarter++;
		if(list.contains("date quý trước")) {
			Calendar a = Calendar.getInstance();
			a.setTime(data.history(lastQuarter).getDate());
			list.set(list.indexOf("date quý trước"),a.get(Calendar.DATE)+"/"+(a.get(Calendar.MONTH)+1));
		};
		if(list.contains("điểm quý trước"))
			list.set(list.indexOf("điểm quý trước"), data.history(lastQuarter).getGiaDongCua()+"");
		if(list.contains("hiệu quý trước"))
			list.set(list.indexOf("hiệu quý trước"), String.format("%.3g", Math.abs(data.history(thisQuarter).getGiaDongCua()-data.history(lastQuarter).getGiaDongCua())));
		for(String e1 : list)
			kq.append(e1);
		return kq.toString();
	}
	//Năm
	public String locCauNam(String sample) {
		String cau = locCauNgay(sample);
		String[] e = cau.split("!");
		StringBuffer kq = new StringBuffer();
		List<String> list = new ArrayList<String>();
		for(String e1 : e) {
			list.add(e1);
		}
		int thisYear = 0;
		int lastYear = thisYear - 366;
		while(data.history(lastYear)==null)
			lastYear++;
		if(list.contains("date năm trước")) {
			Calendar a = Calendar.getInstance();
			a.setTime(data.history(lastYear).getDate());
			list.set(list.indexOf("date năm trước"),a.get(Calendar.DATE)+"/"+(a.get(Calendar.MONTH)+1)+"/"+a.get(Calendar.YEAR));
		};
		if(list.contains("điểm năm trước"))
			list.set(list.indexOf("điểm năm trước"), data.history(lastYear).getGiaDongCua()+"");
		if(list.contains("hiệu năm trước"))
			list.set(list.indexOf("hiệu năm trước"), String.format("%.3g", Math.abs(data.history(thisYear).getGiaDongCua()-data.history(lastYear).getGiaDongCua())));
		for(String e1 : list)
			kq.append(e1);
		return kq.toString();
	}
	//Ngày
	public String locCauNgay(String cau) {
		String[] e = cau.split("@");
		StringBuffer kq = new StringBuffer();
		List<String> list = new ArrayList<String>();
		for(String sub : e) {
			list.add(sub);
		}
		if(list.contains("symbol"))
			list.set(list.indexOf("symbol"), data.getSymbol());
		if(list.contains("date")) {
			Calendar a = Calendar.getInstance();
			a.setTime(data.getDate());
			list.set(list.indexOf("date"),a.get(Calendar.DATE)+"/"+(a.get(Calendar.MONTH)+1));
		}
		if(list.contains("điểm"))
			list.set(list.indexOf("điểm"), ""+data.getGiaDongCua());
		if(list.contains("hiệu"))
			list.set(list.indexOf("hiệu"), String.format("%.3g", Math.abs(data.getGiaDongCua() - data.history(-1).getGiaDongCua())));
		if(list.contains("tỉ lệ")) {
			double c = data.getGiaDongCua();
			double b = data.history(-1).getGiaDongCua();
			double d = Math.abs((c-b)/b*100);
			list.set(list.indexOf("tỉ lệ"), String.format("%.3g", d));
		}
		if(list.contains("volume")) {
			list.set(list.indexOf("volume"), String.format("%.3g", data.getVolume()/Math.pow(10,6)));
		}
		if(list.contains("GTGD")) {
			list.set(list.indexOf("GTGD"), String.format("%.3g", data.getVolume()*1200/1000000000));
		}
		if(list.contains("mã tăng"))
			list.set(list.indexOf("mã tăng"), ""+this.stockExchange.timSoCoPhieuTangGia());
		if(list.contains("mã giảm"))
			list.set(list.indexOf("mã giảm"), ""+this.stockExchange.timSoCoPhieuGiamGia());
		for(String a : list) {
			kq.append(a);
		}
				
		return kq.toString();
	}

}
