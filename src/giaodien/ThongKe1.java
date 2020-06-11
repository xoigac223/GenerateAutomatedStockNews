package giaodien;

import java.io.File;

import javax.swing.JFrame;
import javax.swing.JTable;

import readfile.ReadFiles;
import stockmarket.BigStock;

import java.awt.Color;
import javax.swing.JScrollPane;
import java.awt.Font;

public class ThongKe1 {

	JFrame frame;
	private ReadFiles reader;
	private JTable table;
	private String[][] data;
	private String[] header;
	private BigStock stock;
	private String name;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		ThongKe1 tk = new ThongKe1(new File("C:/Users/Administrator/workspace/GenerateAutomatedStockNews-master/data/input.csv"));
		try {
			tk.show();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Create the application.
	 * @wbp.parser.entryPoint
	 */
	public ThongKe1() {
		initialize();
	}
	
	public ThongKe1(File file) {
		try {
			this.reader = new ReadFiles(file.getPath());
			String[] header = {"Mã","Date","Mở cửa","Giữa sáng","Chốt sáng","Đầu chiều","Giữa chiều","Chốt ngày","Cao nhất","Thấp nhất","Volume"};
			this.header = header;
			data = reader.getArray();
			this.stock = new BigStock(new ReadFiles(file.getPath()));
			this.name = this.stock.getSymbol();
			//this.initialize();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public String getName() {
		return name;
	}

	public JTable getTable() {
		return this.table;
	}
	
	public void show() throws Exception{
		this.frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
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
