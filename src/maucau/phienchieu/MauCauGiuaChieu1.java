package maucau.phienchieu;

import maucau.MauCauDuaTrenBigStock;
import maucau.iMauCau;
import stockmarket.BigStock;

public class MauCauGiuaChieu1 extends MauCauDuaTrenBigStock implements iMauCau {

    public MauCauGiuaChieu1(BigStock stock) {
        super(stock);
    }

    public String sinhCau() {
        String MauCauGiuaChieu = null;
        StringBuffer sb = new StringBuffer();
        String symbol = stock.getSymbol();
        double mocKhangCu = 400.0d;
        double giaMoCuaGiuaChieu = stock.getGiaMoCua();
        double giaSauMoCuaGiuaChieu = stock.getGiaGiuaPhienChieu();
        float chenhLech = (float) (giaSauMoCuaGiuaChieu - giaMoCuaGiuaChieu);

        if ((giaMoCuaGiuaChieu > mocKhangCu) && (chenhLech < 0)) {
            sb.append("Chiều nay, mặc dù kháng cự ở mức ");
            sb.append(mocKhangCu);
            sb.append(" điểm, nhưng ");
            sb.append(symbol);
            sb.append(" đã mất ");
            sb.append(Math.abs(chenhLech));
            sb.append(" về ");
            sb.append(giaSauMoCuaGiuaChieu);
        } else if ((giaMoCuaGiuaChieu < mocKhangCu) && (chenhLech > 0)) {
            sb.append("chiều nay,");
            sb.append(symbol);
            sb.append(" vẫn trên mức an toàn ");
            sb.append(mocKhangCu);
            sb.append(" đến cuối giữa phiên chiều vẫn đạt ");
            sb.append(giaSauMoCuaGiuaChieu);
            sb.append(" điểm, tăng ");
            sb.append(chenhLech);
            sb.append(" điểm so với phiên chiều.");
        }
        MauCauGiuaChieu = sb.toString();
        return MauCauGiuaChieu;
    }
}
