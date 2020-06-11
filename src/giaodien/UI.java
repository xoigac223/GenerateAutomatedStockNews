package giaodien;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import org.eclipse.wb.swing.FocusTraversalOnArray;

import app.News;
import app.Tag;
import maucau.iMauCau;
import maucau.chotngay.MaCoPhieuBienDongManh;
import maucau.chotngay.MauCauChotNgay;
import maucau.chotngay.MauCauCoPhieuLon;
import maucau.chotngay.MauCauMucThapNhat;
import maucau.chotngay.MauCauPhanTichCoPhieuDauKhi;
import maucau.chotngay.MauCauPhanTichCoPhieuNganHang;
import maucau.chotngay.MauCauPhanTichCoPhieuTrongNgay;
import maucau.phienchieu.LienKetSang_Chieu;
import maucau.phienchieu.*;
import maucau.phienchieu.MauCauGiuaChieu7;
import maucau.phiensang.*;
import maucau.phiensang.LoiKhuyenGiuaPhienSang;
import readfile.ReadFiles;
import stockmarket.BigStock;
import stockmarket.StockExchange;

import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.SwingConstants;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.ImageIcon;
import java.awt.Toolkit;


public class UI extends Thread{

	private JFrame frmUi;
	private JTextField txtChnFileS;
	private JTextField txtChnFileS_1;
	private JTextPane textPane;
	private File file1,file2;
	private ThongKe1 thongKe1;
	private ThongKe2 thongKe2;
	private JTable table_1;
	private JTable table_2;
	private JTabbedPane tabbedPane;
	private JRadioButton rdbtnNewRadioButton,rdbtnTun,rdbtnThng,rdbtnQu,rdbtnNm,rdbtnNewRadioButton_1,rdbtnStock,
	rdbtnCcMC,rdbtnCPhiuLn,rdbtnGiaPhinSng,rdbtnChtPhinSng,rdbtnDuKh,rdbtnNgnHng,rdbtnGiaChiu,rdbtnuPhinChiu,rdbtnSelectAll,rdbtnDefault;
	private boolean[] tagChecked;
	private String baiViet;
	private boolean exit,sinhBai;
	
	/**
	 * Launch the application.
	 */
	@Override
	public void run() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmUi.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public UI() {
		initialize();
		tagChecked = new boolean[15];
		this.refreshTag();
		this.exit = false;
		this.sinhBai = false;
		this.rdbtnDefault.doClick();
		this.selectDefault(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmUi = new JFrame();
		frmUi.setTitle("Nhóm 5 - OOP");
		frmUi.setIconImage(Toolkit.getDefaultToolkit().getImage(UI.class.getResource("/picture/purepng.com-stocks-icon-ios-7symbolsiconsapple-iosiosios-7-iconsios-7-721522596667usvyp (1).png")));
		frmUi.setResizable(false);
		frmUi.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmUi.setForeground(new Color(0, 0, 0));
		frmUi.getContentPane().setBackground(Color.DARK_GRAY);
		frmUi.setBounds(100, 100, 987, 605);
		frmUi.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(-11, -31, 218, 598);
		frmUi.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(UI.class.getResource("/picture/icon.png")));
		lblNewLabel.setFont(new Font("Vinhan", Font.BOLD, 40));
		lblNewLabel.setForeground(new Color(0, 0, 51));
		lblNewLabel.setBounds(65, 31, 115, 118);
		panel.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("SINH BÀI VIẾT");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				sinhBai = true;
				generate();
				try {
					Thread.sleep(000);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				sinhBai = false;
				if(!textPane.getText().equals("")) {
					JTextPane textPane = new JTextPane();
					textPane.setFont(new Font("Tahoma", Font.PLAIN, 15));
					textPane.setForeground(Color.WHITE);
					textPane.setBackground(Color.DARK_GRAY);
					tabbedPane.addTab("Bài viết", null, textPane, null);
					textPane.setText(baiViet);
				}
				else
					textPane.setText(baiViet);
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(Color.DARK_GRAY);
		btnNewButton.setBounds(10, 149, 208, 49);
		panel.add(btnNewButton);
		
		JButton btnBiu = new JButton("BIỂU ĐỒ");
		btnBiu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String[] args = {file1.getPath()};
				ChartDialog.main(args);
			}
		});
		btnBiu.setForeground(Color.WHITE);
		btnBiu.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnBiu.setBackground(Color.DARK_GRAY);
		btnBiu.setBounds(10, 401, 208, 49);
		panel.add(btnBiu);
		
		JButton btnThngK_1 = new JButton("MÃ CỔ PHIẾU");
		btnThngK_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					int i = thongKe1.getData().length;
					String[][] data = new String[i+1][11];
					String[] header = thongKe1.getHeader();
					for(int j = i; j > 0 ; j--) {
						data[j] = thongKe1.getData()[j-1];
					}
					data[0] = header;
					table_1 = new JTable(data,header);
					table_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
					table_1.setRowSelectionAllowed(false);
					table_1.setEnabled(false);
					table_1.setBackground(new Color(0, 50, 50));
					table_1.setForeground(Color.WHITE);
					tabbedPane.addTab(thongKe1.getName(), null, table_1, null);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnThngK_1.setForeground(Color.WHITE);
		btnThngK_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnThngK_1.setBackground(Color.DARK_GRAY);
		btnThngK_1.setBounds(10, 448, 208, 49);
		panel.add(btnThngK_1);
		
		JButton btnThngK = new JButton("SÀN GIAO DỊCH");
		btnThngK.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					int i = thongKe2.getData().length;
					String[][] data = new String[i+1][12];
					String[] header = thongKe2.getHeader();
					for(int j = i; j > 0 ; j--) {
						data[j] = thongKe2.getData()[j-1];
					}
					data[0] = header;
					table_2 = new JTable(data,header);
					table_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
					table_2.setRowSelectionAllowed(false);
					table_2.setEnabled(false);
					table_2.setBackground(new Color(0, 50, 50));
					table_2.setForeground(Color.WHITE);
					tabbedPane.addTab(thongKe2.getSymbol(), null, table_2, null);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnThngK.setForeground(Color.WHITE);
		btnThngK.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnThngK.setBackground(Color.DARK_GRAY);
		btnThngK.setBounds(10, 494, 208, 49);
		panel.add(btnThngK);
		
		rdbtnNewRadioButton = new JRadioButton("NGÀY");
		rdbtnNewRadioButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				tagChecked[7] = rdbtnNewRadioButton.isSelected();
			}
		});
		rdbtnNewRadioButton.setBounds(10, 198, 53, 23);
		panel.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.setForeground(Color.WHITE);
		rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 11));
		rdbtnNewRadioButton.setBackground(Color.DARK_GRAY);

		rdbtnTun = new JRadioButton("TUẦN");
		rdbtnTun.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tagChecked[11] = rdbtnTun.isSelected();
			
			}
		});
		rdbtnTun.setBounds(65, 198, 53, 23);
		panel.add(rdbtnTun);
		rdbtnTun.setForeground(Color.WHITE);
		rdbtnTun.setBackground(Color.DARK_GRAY);
		
		rdbtnThng = new JRadioButton("THÁNG");
		rdbtnThng.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tagChecked[8] = rdbtnThng.isSelected();
			}
		});
		rdbtnThng.setBounds(120, 198, 81, 23);
		panel.add(rdbtnThng);
		rdbtnThng.setForeground(Color.WHITE);
		rdbtnThng.setBackground(Color.DARK_GRAY);
		
		rdbtnQu = new JRadioButton("QUÝ");
		rdbtnQu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tagChecked[9]= rdbtnQu.isSelected();
			}
		});
		rdbtnQu.setBounds(10, 224, 53, 23);
		panel.add(rdbtnQu);
		rdbtnQu.setForeground(Color.WHITE);
		rdbtnQu.setBackground(Color.DARK_GRAY);
		
		rdbtnNm = new JRadioButton("NĂM");
		rdbtnNm.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tagChecked[10] = rdbtnNm.isSelected();
			}
		});
		rdbtnNm.setBounds(65, 225, 53, 23);
		panel.add(rdbtnNm);
		rdbtnNm.setForeground(Color.WHITE);
		rdbtnNm.setBackground(Color.DARK_GRAY);
		
		rdbtnNewRadioButton_1 = new JRadioButton("MỞ CỬA");
		rdbtnNewRadioButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tagChecked[2] = rdbtnNewRadioButton_1.isSelected();
			}
		});
		rdbtnNewRadioButton_1.setForeground(Color.WHITE);
		rdbtnNewRadioButton_1.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnNewRadioButton_1.setBackground(Color.DARK_GRAY);
		rdbtnNewRadioButton_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		rdbtnNewRadioButton_1.setBounds(6, 302, 81, 23);
		panel.add(rdbtnNewRadioButton_1);
		
		rdbtnStock = new JRadioButton("STOCK");
		rdbtnStock.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tagChecked[12] = rdbtnStock.isSelected();
			}
		});
		rdbtnStock.setHorizontalAlignment(SwingConstants.LEFT);
		rdbtnStock.setForeground(Color.WHITE);
		rdbtnStock.setFont(new Font("Tahoma", Font.PLAIN, 11));
		rdbtnStock.setBackground(Color.DARK_GRAY);
		rdbtnStock.setBounds(120, 225, 81, 23);
		panel.add(rdbtnStock);
		
		rdbtnCcMC = new JRadioButton("CÁC MÃ CỔ PHIẾU");
		rdbtnCcMC.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tagChecked[0] = rdbtnCcMC.isSelected();
			}
		});
		rdbtnCcMC.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnCcMC.setForeground(Color.WHITE);
		rdbtnCcMC.setFont(new Font("Tahoma", Font.PLAIN, 11));
		rdbtnCcMC.setBackground(Color.DARK_GRAY);
		rdbtnCcMC.setBounds(6, 250, 125, 23);
		panel.add(rdbtnCcMC);
		
		rdbtnCPhiuLn = new JRadioButton("CỔ PHIẾU LỚN");
		rdbtnCPhiuLn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tagChecked[1] = rdbtnCPhiuLn.isSelected();
			}
		});
		rdbtnCPhiuLn.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnCPhiuLn.setForeground(Color.WHITE);
		rdbtnCPhiuLn.setFont(new Font("Tahoma", Font.PLAIN, 11));
		rdbtnCPhiuLn.setBackground(Color.DARK_GRAY);
		rdbtnCPhiuLn.setBounds(6, 276, 108, 23);
		panel.add(rdbtnCPhiuLn);
		
		rdbtnGiaPhinSng = new JRadioButton("GIỮA PHIÊN SÁNG");
		rdbtnGiaPhinSng.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tagChecked[3] = rdbtnGiaPhinSng.isSelected();
			}
		});
		rdbtnGiaPhinSng.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnGiaPhinSng.setForeground(Color.WHITE);
		rdbtnGiaPhinSng.setFont(new Font("Tahoma", Font.PLAIN, 11));
		rdbtnGiaPhinSng.setBackground(Color.DARK_GRAY);
		rdbtnGiaPhinSng.setBounds(89, 302, 125, 23);
		panel.add(rdbtnGiaPhinSng);
		
		rdbtnChtPhinSng = new JRadioButton("CHỐT PHIÊN SÁNG");
		rdbtnChtPhinSng.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tagChecked[4] = rdbtnChtPhinSng.isSelected();
			}
		});
		rdbtnChtPhinSng.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnChtPhinSng.setForeground(Color.WHITE);
		rdbtnChtPhinSng.setFont(new Font("Tahoma", Font.PLAIN, 11));
		rdbtnChtPhinSng.setBackground(Color.DARK_GRAY);
		rdbtnChtPhinSng.setBounds(10, 329, 125, 23);
		panel.add(rdbtnChtPhinSng);
		
		rdbtnDuKh = new JRadioButton("DẦU KHÍ");
		rdbtnDuKh.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tagChecked[13] = rdbtnDuKh.isSelected();
			}
		});
		rdbtnDuKh.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnDuKh.setForeground(Color.WHITE);
		rdbtnDuKh.setFont(new Font("Tahoma", Font.PLAIN, 11));
		rdbtnDuKh.setBackground(Color.DARK_GRAY);
		rdbtnDuKh.setBounds(120, 251, 81, 23);
		panel.add(rdbtnDuKh);
		
		rdbtnNgnHng = new JRadioButton("NGÂN HÀNG");
		rdbtnNgnHng.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tagChecked[14] = rdbtnNgnHng.isSelected();
			}
		});
		rdbtnNgnHng.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnNgnHng.setForeground(Color.WHITE);
		rdbtnNgnHng.setFont(new Font("Tahoma", Font.PLAIN, 11));
		rdbtnNgnHng.setBackground(Color.DARK_GRAY);
		rdbtnNgnHng.setBounds(110, 276, 108, 23);
		panel.add(rdbtnNgnHng);
		
		rdbtnGiaChiu = new JRadioButton("GIỮA CHIỀU");
		rdbtnGiaChiu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tagChecked[6] = rdbtnGiaChiu.isSelected();
			}
		});
		rdbtnGiaChiu.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnGiaChiu.setForeground(Color.WHITE);
		rdbtnGiaChiu.setFont(new Font("Tahoma", Font.PLAIN, 11));
		rdbtnGiaChiu.setBackground(Color.DARK_GRAY);
		rdbtnGiaChiu.setBounds(120, 355, 98, 23);
		panel.add(rdbtnGiaChiu);
		
		rdbtnuPhinChiu = new JRadioButton("ĐẦU PHIÊN CHIỀU");
		rdbtnuPhinChiu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tagChecked[5] = rdbtnuPhinChiu.isSelected();
			}
		});
		rdbtnuPhinChiu.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnuPhinChiu.setForeground(Color.WHITE);
		rdbtnuPhinChiu.setFont(new Font("Tahoma", Font.PLAIN, 11));
		rdbtnuPhinChiu.setBackground(Color.DARK_GRAY);
		rdbtnuPhinChiu.setBounds(10, 355, 115, 23);
		panel.add(rdbtnuPhinChiu);
		
		rdbtnSelectAll = new JRadioButton("SELECT ALL");
		rdbtnSelectAll.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				selectAll(rdbtnSelectAll.isSelected());
			}
		});
		rdbtnSelectAll.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnSelectAll.setForeground(Color.WHITE);
		rdbtnSelectAll.setFont(new Font("Tahoma", Font.PLAIN, 11));
		rdbtnSelectAll.setBackground(Color.DARK_GRAY);
		rdbtnSelectAll.setBounds(93, 381, 81, 23);
		panel.add(rdbtnSelectAll);
		
		rdbtnDefault = new JRadioButton("DEFAULT");
		rdbtnDefault.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				selectDefault(rdbtnDefault.isSelected());
			}
		});
		rdbtnDefault.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnDefault.setForeground(Color.WHITE);
		rdbtnDefault.setFont(new Font("Tahoma", Font.PLAIN, 11));
		rdbtnDefault.setBackground(Color.DARK_GRAY);
		rdbtnDefault.setBounds(10, 381, 81, 23);
		panel.add(rdbtnDefault);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.DARK_GRAY);
		panel_1.setBounds(188, 0, 807, 84);
		frmUi.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnNewButton_1 = new JButton("CHỌN FILE");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				file1 = FileChooser.browse();
				txtChnFileS.setText(file1.getPath());
				thongKe1 = new ThongKe1(file1);
			}
		});
		btnNewButton_1.setBackground(Color.DARK_GRAY);
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setBounds(507, 13, 109, 23);
		panel_1.add(btnNewButton_1);
		
		txtChnFileS = new JTextField();
		txtChnFileS.setEditable(false);
		txtChnFileS.setHorizontalAlignment(SwingConstants.LEFT);
		txtChnFileS.setText("CHỌN FILE SỐ LIỆU MÃ CỐ PHIẾU VÀO ĐÂY");
		txtChnFileS.setBounds(21, 11, 417, 26);
		panel_1.add(txtChnFileS);
		txtChnFileS.setColumns(10);
		
		txtChnFileS_1 = new JTextField();
		txtChnFileS_1.setEditable(false);
		txtChnFileS_1.setHorizontalAlignment(SwingConstants.LEFT);
		txtChnFileS_1.setText("CHỌN FILE SỐ LIỆU SÀN GIAO DỊCH VÀO ĐÂY");
		txtChnFileS_1.setColumns(10);
		txtChnFileS_1.setBounds(21, 48, 417, 26);
		panel_1.add(txtChnFileS_1);
		
		JButton btnChnFile = new JButton("CHỌN FILE");
		btnChnFile.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				file2 = FileChooser.browse();
				txtChnFileS_1.setText(file2.getPath());
				String name = JOptionPane.showInputDialog("Nhập tên sàn giao dịch");
				String symbol = JOptionPane.showInputDialog("Nhập kí hiệu sàn giao dịch");
				thongKe2 = new ThongKe2(name,symbol,file2);
			}
		});
		btnChnFile.setForeground(Color.WHITE);
		btnChnFile.setBackground(Color.DARK_GRAY);
		btnChnFile.setBounds(507, 50, 109, 23);
		panel_1.add(btnChnFile);
		
		JButton btnNewButton_2 = new JButton("LƯU BÀI VIẾT");
		btnNewButton_2.setForeground(Color.WHITE);
		btnNewButton_2.setBackground(Color.DARK_GRAY);
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				int i = 0;
				for(Component c : tabbedPane.getComponents()) {
					if(c instanceof JTextPane) {
						JTextPane temp = (JTextPane) c;
						String data = temp.getText();
						String name = "Báo cáo chứng khoán" +(i++)+".txt";
						FileSaver.save(new File(name), data);
					}
				}
				
				
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_2.setBounds(819, 530, 114, 26);
		frmUi.getContentPane().add(btnNewButton_2);
		
		JButton btnXaTab = new JButton("XÓA TAB");
		btnXaTab.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int i = tabbedPane.getTabCount();
				if(i!=1) {
					tabbedPane.remove(i-1);
				}
			}
		});
		btnXaTab.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnXaTab.setBackground(Color.DARK_GRAY);
		btnXaTab.setForeground(Color.WHITE);
		btnXaTab.setBounds(840, 88, 109, 23);
		frmUi.getContentPane().add(btnXaTab);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(207, 117, 774, 393);
		frmUi.getContentPane().add(scrollPane);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		tabbedPane.setBorder(null);
		tabbedPane.setBackground(Color.WHITE);
		tabbedPane.setForeground(Color.DARK_GRAY);
		scrollPane.setViewportView(tabbedPane);
		tabbedPane.setVisible(true);
		
		textPane = new JTextPane();
		textPane.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textPane.setForeground(Color.WHITE);
		textPane.setBackground(Color.DARK_GRAY);
		tabbedPane.addTab("Bài viết", null, textPane, null);
		
		JButton btnNewButton_3 = new JButton("REFRESH");
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				refreshTag();
				baiViet = null;
				textPane.setText(null);
			}
		});
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_3.setForeground(Color.WHITE);
		btnNewButton_3.setBackground(Color.DARK_GRAY);
		btnNewButton_3.setBounds(693, 88, 109, 23);
		frmUi.getContentPane().add(btnNewButton_3);
		frmUi.getContentPane().setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{panel}));
	}
	
	public boolean[] getCheckedTag() {
		return this.tagChecked;
	}
	public void selectAll(boolean clicked) {
		for(int i = 0 ; i < 15 ; i++)
			tagChecked[i] = clicked;
		rdbtnNewRadioButton.setSelected(clicked);
		rdbtnTun.setSelected(clicked);
		rdbtnThng.setSelected(clicked);
		rdbtnQu.setSelected(clicked);
		rdbtnNm.setSelected(clicked);
		rdbtnNewRadioButton_1.setSelected(clicked);
		rdbtnStock.setSelected(clicked);
		rdbtnCcMC.setSelected(clicked);
		rdbtnCPhiuLn.setSelected(clicked);
		rdbtnGiaPhinSng.setSelected(clicked);
		rdbtnChtPhinSng.setSelected(clicked);
		rdbtnDuKh.setSelected(clicked);
		rdbtnNgnHng.setSelected(clicked);
		rdbtnGiaChiu.setSelected(clicked);
		rdbtnuPhinChiu.setSelected(clicked);
		
	}
	public void selectDefault(boolean clicked) {
		tagChecked[0] = clicked;
		tagChecked[1] = clicked;
		tagChecked[12] = clicked;
		rdbtnStock.setSelected(clicked);
		rdbtnCcMC.setSelected(clicked);
		rdbtnCPhiuLn.setSelected(clicked);
		
		
	}
	public void refreshTag() {
		for(int i = 0; i < 15; i++)
			tagChecked[i] = false;
		rdbtnNewRadioButton.setSelected(false);
		rdbtnTun.setSelected(false);
		rdbtnThng.setSelected(false);
		rdbtnQu.setSelected(false);
		rdbtnNm.setSelected(false);
		rdbtnNewRadioButton_1.setSelected(false);
		rdbtnStock.setSelected(false);
		rdbtnCcMC.setSelected(false);
		rdbtnCPhiuLn.setSelected(false);
		rdbtnGiaPhinSng.setSelected(false);
		rdbtnChtPhinSng.setSelected(false);
		rdbtnDuKh.setSelected(false);
		rdbtnNgnHng.setSelected(false);
		rdbtnGiaChiu.setSelected(false);
		rdbtnuPhinChiu.setSelected(false);
		rdbtnSelectAll.setSelected(false);
		rdbtnDefault.setSelected(false);
	}
    public void setBai(String baiViet) {
		this.baiViet = baiViet;
	}
    
    public File getBigStockFile() {
		return file1;
	}

	public File getStockExchangeFile() {
		return file2;
	}

	public boolean isExit() {
		return exit;
	}

	public boolean isSinhBai() {
		return sinhBai;
	}
	//Khởi tạo
	public void generate() {
		String path1 = this.getBigStockFile().getPath();
		String path2 = this.getStockExchangeFile().getPath();
		/*
		Phần khởi tạo*/
		
		ReadFiles file1 = new ReadFiles(path1);
		ReadFiles file2 = new ReadFiles(path2);
		
		BigStock bigStock = new BigStock(file1);
		StockExchange stockExchange = new StockExchange(file2, "abc", "bcd");
		
		iMauCau mauCauGiuaPhienSang = new GiuaPhienSang(bigStock);
		iMauCau mauCauLoiKhuyenGiuaPhienSang = new LoiKhuyenGiuaPhienSang(bigStock);
		iMauCau mauCauMaCPGiamManhNhatGiuaPhienSang = new MaCPGiamManhNhatGiuaPhienSang(stockExchange);
		iMauCau mauCauMaCPTangManhNhatGiuaPhienSang = new MaCPTangManhNhatGiuaPhienSang(stockExchange);
		iMauCau mauCauChotSang1 = new MauCauChotSang1(bigStock);
		iMauCau mauCauChotSang2 = new MauCauChotSang2(stockExchange);
		iMauCau mauCauMoCua = new MauCauMoCua(bigStock);
		iMauCau mauCauMoCuaNhanXet = new MoCuaNhanXet(bigStock);
		iMauCau mauCauMoCuaSoCoPhieu = new MoCuaSoCoPhieu(bigStock, stockExchange);
		iMauCau mauCauMoCuaSoCoPhieu2 = new MoCuaSoCoPhieu2(bigStock, stockExchange);
		iMauCau mauCauSoCPTangGiamGiuaPhienSang = new SoCPTangGiamGiuaPhienSang(bigStock, stockExchange);
		iMauCau mauCauTangGiamCaoNhatGiuaPhienSang = new TangGiamCaoNhatGiuaPhienSang(bigStock);
		iMauCau mauCauDauPhienChieu = new LienKetSang_Chieu(bigStock);
		iMauCau mauCauGiuaChieu1 = new MauCauGiuaChieu1(bigStock);
		iMauCau mauCauGiuaChieu2 = new MauCauGiuaChieu2(bigStock);
		iMauCau mauCauGiuaChieu3 = new MauCauGiuaChieu3(bigStock);
		iMauCau mauCauGiuaChieu4 = new MauCauGiuaChieu4(bigStock);
		iMauCau mauCauGiuaChieu5 = new MauCauGiuaChieu5(bigStock);
		iMauCau mauCauGiuaChieu6 = new MauCauGiuaChieu6(bigStock);
		iMauCau mauCauGiuaChieu7 = new MauCauGiuaChieu7(bigStock);
		iMauCau mauCauMaCoPhieuBienDongManh = new MaCoPhieuBienDongManh(stockExchange);
		iMauCau mauCauChotNgay1 = new MauCauChotNgay(bigStock, stockExchange , "Ngày");
		iMauCau mauCauChotNgay2 = new MauCauChotNgay(bigStock, stockExchange , "Tuần");
		iMauCau mauCauChotNgay3 = new MauCauChotNgay(bigStock, stockExchange , "Quý");
		iMauCau mauCauChotNgay4 = new MauCauChotNgay(bigStock, stockExchange , "Tháng");
		iMauCau mauCauChotNgay5 = new MauCauChotNgay(bigStock, stockExchange , "Năm");
		iMauCau mauCauCoPhieuLon = new MauCauCoPhieuLon(stockExchange);
		iMauCau mauCauMucThapNhat = new MauCauMucThapNhat(bigStock);
		iMauCau mauCauPhanTichCoPhieuDauKhi = new MauCauPhanTichCoPhieuDauKhi(stockExchange);
		iMauCau mauCauPhanTichCoPhieuNganHang = new MauCauPhanTichCoPhieuNganHang(stockExchange);
		iMauCau mauCauPhanTichCoPhieuTrongNgay = new MauCauPhanTichCoPhieuTrongNgay("VIC", stockExchange);
		
		Tag cacMaCoPhieu = new Tag("Các mã cổ phiếu", 5);
		Tag coPhieuLon = new Tag("Cổ phiếu lớn", 3);
		Tag moCua = new Tag("Mở cửa", 2);
		Tag giuaPhienSang = new Tag("Giữa phiên Sáng", 2);
		Tag chotPhienSang = new Tag("Chốt phiên sáng", 1);
		Tag dauPhienChieu = new Tag("Đầu phiên chiều",0);
		Tag giuaChieu = new Tag("Giữa chiều",2);
		Tag ngay = new Tag("Ngày",2);
		Tag thang = new Tag("Tháng",0);
		Tag quy = new Tag("Quý",0);
		Tag nam = new Tag("Năm",0);
		Tag tuan = new Tag("Tuần",2);
		Tag stock = new Tag("Stock",0);
		Tag dauKhi = new Tag("Dầu khí",0);
		Tag nganHang = new Tag("Ngân hàng",0);
		
		cacMaCoPhieu.add(mauCauMoCuaSoCoPhieu); cacMaCoPhieu.add(mauCauMaCPTangManhNhatGiuaPhienSang); cacMaCoPhieu.add(mauCauMaCPGiamManhNhatGiuaPhienSang);
		cacMaCoPhieu.add(mauCauChotSang2); cacMaCoPhieu.add(mauCauCoPhieuLon); cacMaCoPhieu.add(mauCauPhanTichCoPhieuDauKhi); 
		cacMaCoPhieu.add(mauCauPhanTichCoPhieuNganHang); cacMaCoPhieu.add(mauCauPhanTichCoPhieuTrongNgay); cacMaCoPhieu.add(mauCauMaCoPhieuBienDongManh); 
		coPhieuLon.add(mauCauCoPhieuLon); coPhieuLon.add(mauCauPhanTichCoPhieuNganHang); coPhieuLon.add(mauCauPhanTichCoPhieuDauKhi);
		coPhieuLon.add(mauCauPhanTichCoPhieuTrongNgay);
		moCua.add(mauCauMoCua); moCua.add(mauCauMoCuaNhanXet); moCua.add(mauCauMoCuaSoCoPhieu); moCua.add(mauCauMoCuaSoCoPhieu2);
		giuaPhienSang.add(mauCauGiuaPhienSang); giuaPhienSang.add(mauCauLoiKhuyenGiuaPhienSang); giuaPhienSang.add(mauCauMaCPTangManhNhatGiuaPhienSang);
		giuaPhienSang.add(mauCauMaCPGiamManhNhatGiuaPhienSang); giuaPhienSang.add(mauCauSoCPTangGiamGiuaPhienSang); giuaPhienSang.add(mauCauTangGiamCaoNhatGiuaPhienSang);
		chotPhienSang.add(mauCauChotSang1); chotPhienSang.add(mauCauChotSang2);
		dauPhienChieu.add(mauCauDauPhienChieu);
		giuaChieu.add(mauCauGiuaChieu1); giuaChieu.add(mauCauGiuaChieu2); giuaChieu.add(mauCauGiuaChieu3); giuaChieu.add(mauCauGiuaChieu4); giuaChieu.add(mauCauGiuaChieu5); 
		giuaChieu.add(mauCauGiuaChieu6); giuaChieu.add(mauCauGiuaChieu7); 
		ngay.add(mauCauChotNgay1); ngay.add(mauCauChotNgay2); ngay.add(mauCauChotNgay3); ngay.add(mauCauChotNgay4); ngay.add(mauCauChotNgay5); 
		ngay.add(mauCauMucThapNhat);
		thang.add(mauCauChotNgay4);
		quy.add(mauCauChotNgay3);
		nam.add(mauCauChotNgay5); nam.add(mauCauMucThapNhat);
		tuan.add(mauCauChotNgay2); tuan.add(mauCauMoCuaNhanXet); tuan.add(mauCauGiuaChieu7); tuan.add(mauCauGiuaChieu6);
		stock.add(mauCauMoCua); stock.add(mauCauLoiKhuyenGiuaPhienSang); stock.add(mauCauChotSang2); stock.add(mauCauDauPhienChieu);
		stock.add(mauCauGiuaChieu4); stock.add(mauCauChotNgay5);
		dauKhi.add(mauCauPhanTichCoPhieuDauKhi);
		nganHang.add(mauCauPhanTichCoPhieuNganHang);
		
		News news = new News();
		news.add(cacMaCoPhieu); news.add(coPhieuLon);news.add(moCua);news.add(giuaPhienSang);news.add(chotPhienSang);
		news.add(dauPhienChieu); news.add(giuaChieu); news.add(ngay); news.add(thang); news.add(quy);
		news.add(nam); news.add(tuan); news.add(stock); news.add(dauKhi); news.add(nganHang);
		
		List<Boolean> listCheckTag = new ArrayList<Boolean>();
		boolean[] checkTag = this.getCheckedTag();
		for (int i = 0; i < checkTag.length; i++) {
			listCheckTag.add(checkTag[i]);
		}
		String baiViet = news.sinhBai(listCheckTag);
		this.setBai(baiViet);
	}

}
