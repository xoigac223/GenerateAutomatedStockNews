package giaodien;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

public class ChartDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField txtOptionThmC;
	private JTextField textField_1;
	private static File file1,file2,file3;

	/**
	 * Launch the application.
	 */
	public void ChartOption() {
		try {
			this.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		ChartDialog dialog = new ChartDialog(new File(args[0]));
		dialog.ChartOption();
	}

	/**
	 * Create the dialog.
	 */
	public ChartDialog(File file) {
		file1 = file;
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setResizable(false);
		setBounds(100, 100, 458, 205);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(10, 11, 298, 20);
		contentPanel.add(textField);
		textField.setColumns(10);
		textField.setText(file1.getPath());
		
		txtOptionThmC = new JTextField();
		txtOptionThmC.setEditable(false);
		txtOptionThmC.setText("OPTION: THÊM CỔ PHIẾU ĐỂ SO SÁNH");
		txtOptionThmC.setColumns(10);
		txtOptionThmC.setBounds(10, 42, 298, 20);
		contentPanel.add(txtOptionThmC);
		
		JButton btnNewButton = new JButton("CHỌN FILE");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				file2 = FileChooser.browse();
				try {
					txtOptionThmC.setText(file2.getPath());
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBounds(318, 41, 103, 23);
		contentPanel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Tạo biểu đồ");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String[] args = new String[3];
				args[0] = file1.getPath();
				if(file2!=null)
					args[1] = file2.getPath();
				if(file3!=null)
					args[2] = file3.getPath();
				Chart.main(args);
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_1.setBounds(122, 114, 118, 23);
		contentPanel.add(btnNewButton_1);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setText("OPTION: THÊM CỔ PHIẾU ĐỂ SO SÁNH");
		textField_1.setColumns(10);
		textField_1.setBounds(10, 73, 298, 20);
		contentPanel.add(textField_1);
		
		JButton button = new JButton("CHỌN FILE");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				file3 = FileChooser.browse();
				try {
					textField_1.setText(file3.getPath());
				}catch(Exception e1) {
					e1.printStackTrace();
				}
				
			}
		});
		button.setForeground(Color.BLACK);
		button.setFont(new Font("Tahoma", Font.BOLD, 11));
		button.setBounds(318, 72, 103, 23);
		contentPanel.add(button);
	}
}
