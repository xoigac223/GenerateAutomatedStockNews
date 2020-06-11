package giaodien;

import java.io.File;

import javax.swing.JFrame;
import javax.swing.JTable;
import readfile.ReadFiles;
import java.awt.Color;
import javax.swing.JScrollPane;
import java.awt.Font;

public class ThongKe2 {

	private JFrame frame;
	private ReadFiles reader;
	private JTable table;
	private String[][] data;
	private String[] header;
	private String name,symbol;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		ThongKe2 tk = new ThongKe2("","",new File("C:/Users/Administrator/workspace/GenerateAutomatedStockNews-master/data/CafeF.HSX.CSV.04.06.2020.csv"));
		try {
			tk.show();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	/**
	 * Create the application.
	 */
	public ThongKe2() {
		initialize();
	}
	
	public ThongKe2(String name,String symbol,File file) {
		try {
			this.reader = new ReadFiles(file.getPath());
			String[] header = {"Mã","Date","Mở cửa","Giữa sáng","Chốt sáng","Đầu chiều","Giữa chiều","Chốt ngày","Cao nhất","Thấp nhất","Volume","Thay đổi"};
			data = reader.getArray();
			this.header = header;
			this.name = name;
			this.symbol = symbol;
			//this.initialize();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String getName() {
		return name;
	}

	public String getSymbol() {
		return symbol;
	}

	
	public void show() throws Exception{
		this.frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	/**
	 * 
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.setBounds(100, 100, 882, 419);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 866, 381);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable(data,header);
		table.setFont(new Font("Tahoma", Font.PLAIN, 12));
		table.setRowSelectionAllowed(false);
		table.setEnabled(false);
		scrollPane.setViewportView(table);
		table.setBackground(new Color(0, 50, 50));
		table.setForeground(Color.WHITE);
	}

	public String[][] getData() {
		return data;
	}

	public String[] getHeader() {
		return header;
	}
}
