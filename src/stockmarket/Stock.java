package stockmarket;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Stock {
	
	protected String symbol;
	protected Date date;
	protected double giaMoCua;
	protected double giaGiuaPhienSang;
	protected double giaChotPhienSang;
	protected double giaDauPhienChieu;
	protected double giaGiuaPhienChieu;
	protected double giaDongCua;
	protected double giaThapNhat;
	protected double giaCaoNhat;
	protected double volume;
	
	public Stock() {
		
	}
	
	public Stock(String symbol, Date date, double giaMoCua, double giaGiuaPhienSang, double giaChotPhienSang,
			double giaDauPhienChieu, double giaGiuaPhienChieu, double giaDongCua, double giaThapNhat, double giaCaoNhat,
			double volume) {
		this.symbol = symbol;
		this.date = date;
		this.giaMoCua = giaMoCua;
		this.giaGiuaPhienSang = giaGiuaPhienSang;
		this.giaChotPhienSang = giaChotPhienSang;
		this.giaDauPhienChieu = giaDauPhienChieu;
		this.giaGiuaPhienChieu = giaGiuaPhienChieu;
		this.giaDongCua = giaDongCua;
		this.giaThapNhat = giaThapNhat;
		this.giaCaoNhat = giaCaoNhat;
		this.volume = volume;
	}


	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public double getGiaMoCua() {
		return giaMoCua;
	}

	public void setGiaMoCua(double giaMoCua) {
		this.giaMoCua = giaMoCua;
	}

	public double getGiaGiuaPhienSang() {
		return giaGiuaPhienSang;
	}

	public void setGiaGiuaPhienSang(double giaGiuaPhienSang) {
		this.giaGiuaPhienSang = giaGiuaPhienSang;
	}

	public double getGiaChotPhienSang() {
		return giaChotPhienSang;
	}

	public void setGiaChotPhienSang(double giaChotPhienSang) {
		this.giaChotPhienSang = giaChotPhienSang;
	}

	public double getGiaDauPhienChieu() {
		return giaDauPhienChieu;
	}

	public void setGiaDauPhienChieu(double giaDauPhienChieu) {
		this.giaDauPhienChieu = giaDauPhienChieu;
	}

	public double getGiaGiuaPhienChieu() {
		return giaGiuaPhienChieu;
	}

	public void setGiaGiuaPhienChieu(double giaGiuaPhienChieu) {
		this.giaGiuaPhienChieu = giaGiuaPhienChieu;
	}

	public double getGiaDongCua() {
		return giaDongCua;
	}

	public void setGiaDongCua(double giaDongCua) {
		this.giaDongCua = giaDongCua;
	}
	
	
	public double getGiaThapNhat() {
		return giaThapNhat;
	}

	public void setGiaThapNhat(double giaThapNhat) {
		this.giaThapNhat = giaThapNhat;
	}

	public double getGiaCaoNhat() {
		return giaCaoNhat;
	}

	public void setGiaCaoNhat(double giaCaoNhat) {
		this.giaCaoNhat = giaCaoNhat;
	}

	public double getVolume() {
		return volume;
	}

	public void setVolumn(double volume) {
		this.volume = volume;
	}


	public void printStock() {
		System.out.printf("%s - %s, %s, %s, %s, %s, %s, %s, %s, %s, %s", symbol, new SimpleDateFormat("dd/MM/yyyy").format(date), 
			giaMoCua, giaGiuaPhienSang, giaChotPhienSang, giaDauPhienChieu, giaGiuaPhienChieu, giaDongCua, giaThapNhat, giaCaoNhat, volume);
		System.out.println();
	}
	
}
