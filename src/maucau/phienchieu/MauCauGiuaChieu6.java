package maucau.phienchieu;

import stockmarket.BigStock;
import stockmarket.Stock;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import maucau.MauCauDuaTrenBigStock;
import maucau.iMauCau;

public class MauCauGiuaChieu6 extends MauCauDuaTrenBigStock implements iMauCau {
    private static List<Stock> listStock;

    public MauCauGiuaChieu6(BigStock stock) {
    	super(stock);
    }

    public String sinhCau() {
        String mauCau = null;
        StringBuffer sb = new StringBuffer();
        String symbol = stock.getSymbol();
        listStock = new ArrayList<Stock>();
        for (int i = 0; i < 7; i++) {
        	if (stock.history(-i) != null ) listStock.add(stock.history(-i));
        }
        double maxMoPhienChieu = listStock.get(0).getGiaGiuaPhienChieu();
        double minMoPhienChieu = listStock.get(0).getGiaDauPhienChieu();
        Date dateMax = listStock.get(0).getDate();
        Date dateMin = listStock.get(0).getDate();
        for (int i = 1; i < listStock.size(); i++) {
            if (listStock.get(i).getGiaGiuaPhienChieu() > maxMoPhienChieu) {
                maxMoPhienChieu = listStock.get(i).getGiaGiuaPhienChieu();
                dateMax = listStock.get(i).getDate();
            }
            if (listStock.get(i).getGiaGiuaPhienChieu() < minMoPhienChieu) {
                minMoPhienChieu = listStock.get(i).getGiaGiuaPhienChieu();
                dateMin = listStock.get(i).getDate();
            }
        }

        sb.append("Một tuần vừa qua, cùng thời điểm phiên giữa chiều, cổ phiếu ");
        sb.append(symbol);
        sb.append(" mở phiên giữa chiều với điểm cao nhất là ");
        sb.append(maxMoPhienChieu);
        sb.append(" đạt được vào ngày: ");
        sb.append(new SimpleDateFormat("dd/MM/yyyy").format(dateMax));
        sb.append(" và mở phiên chiều với điểm thấp nhất là: ");
        sb.append(minMoPhienChieu);
        sb.append(" đạt được vào ngày: ");
        sb.append(new SimpleDateFormat("dd/MM/yyyy").format(dateMin));

        mauCau = sb.toString();

        return mauCau;
    }
}
