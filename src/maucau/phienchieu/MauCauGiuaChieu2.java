package maucau.phienchieu;

import stockmarket.BigStock;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import maucau.MauCauDuaTrenBigStock;
import maucau.iMauCau;

public class MauCauGiuaChieu2 extends MauCauDuaTrenBigStock implements iMauCau {
    private static List<String> dauCauChieu;


    public MauCauGiuaChieu2 (BigStock stock){
    	super(stock);
        dauCauChieu = new ArrayList<String>();
        dauCauChieu.add("Chiều nay, Sau 10 phút giao dịch, ");
        dauCauChieu.add("Chiều nay, Sau 15 phút giao dịch, ");
        dauCauChieu.add("Chiều nay, Sau 20 phút giao dịch, ");
    }

    public String sinhCau(){
        String mauCauGiuaChieu = null;
        StringBuffer sb = new StringBuffer();
        String dauCau = dauCauChieu.get(new Random().nextInt(dauCauChieu.size()));;
        String symbol =stock.getSymbol();
        double giaMoCuaChieu = stock.getGiaDauPhienChieu();
        double giaGiuaPhienChieu = stock.getGiaGiuaPhienChieu();
        float chenhLech =(float) (giaGiuaPhienChieu - giaMoCuaChieu);
        sb.append(dauCau);
        sb.append(symbol);

        if (chenhLech < 0){
            sb.append(" giảm ");
            sb.append(Math.abs(chenhLech));
            sb.append(" điểm, bất chấp những khởi sắc trong những phứt đầu giao dịch.");
        }else {
            sb.append(" tăng ");
            sb.append(chenhLech);
            sb.append("cho thấy sự khởi sắc tốt trong buổi chiều hôm nay.");
        }
        mauCauGiuaChieu = sb.toString();
        return mauCauGiuaChieu;
    }
}
