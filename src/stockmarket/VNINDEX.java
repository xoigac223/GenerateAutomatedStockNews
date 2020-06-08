package stockmarket;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import readfile.*;

public class VNINDEX  extends Stock{
	public VNINDEX(ReadFiles f) {
		super();
		String[][] s = f.getArray();
		this.symbol = "VNINDEX";
		Date date = null;
		try {
			date = (Date) new SimpleDateFormat("yyyyMMdd").parse(s[0][1]);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		double openingPrice = Double.parseDouble(s[0][2]);
		double highestPrice = Double.parseDouble(s[0][3]);
		double lowestPrice = Double.parseDouble(s[0][4]);
		double closingPrice = Double.parseDouble(s[0][5]);
		double volumn = Double.parseDouble(s[0][6]);
		this.date = date;
		this.openingPrice = openingPrice;
		this.highestPrice = highestPrice;
		this.lowestPrice = lowestPrice;
		this.closingPrice = closingPrice;
		this.volumn = volumn;
	
	}
	

}
