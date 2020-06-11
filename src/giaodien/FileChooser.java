package giaodien;

import java.io.File;

import javax.swing.JFileChooser;

public class FileChooser {
	public static File browse(){
		JFileChooser j = new JFileChooser("C:\\Users\\daonv\\OneDrive\\Documents\\Java\\BaiTapLon\\data");//nối tên vào mở cho tiện
		j.showOpenDialog(null);
		return j.getSelectedFile();
	}

}
