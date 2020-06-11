package giaodien;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;

public class FileSaver {
	
	public static void save(File file,String data) {
		JFileChooser saver = new JFileChooser("C:\\Users\\daonv\\OneDrive\\Documents\\Java\\BaiTapLon\\data");
		saver.setSelectedFile(file);
		FileWriter writer = null;
		if(saver.showSaveDialog(null)!=JFileChooser.APPROVE_OPTION)
			return;
		try {
			writer = new FileWriter(new File(saver.getCurrentDirectory().toString()+"/"+saver.getSelectedFile().getName()));
			writer.write(data);
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				writer.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		FileSaver.save(new File("new.txt"),"fsfsdf");
	}
}
	
