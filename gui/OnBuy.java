import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JComboBox;
import java.awt.Color;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTable;

public class OnBuy {

	private JFrame frmBuyStock;
	private JTextField StockId;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OnBuy window = new OnBuy();
					window.frmBuyStock.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public OnBuy() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmBuyStock = new JFrame();
		frmBuyStock.setTitle("Trade Stock");
		frmBuyStock.setBounds(100, 100, 800, 600);
		frmBuyStock.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmBuyStock.getContentPane().setLayout(null);
		
		StockId = new JTextField();
		StockId.addInputMethodListener(new InputMethodListener() {
			public void caretPositionChanged(InputMethodEvent event) {
			}
			public void inputMethodTextChanged(InputMethodEvent event) {
			}
		});
		StockId.setFont(new Font("Tahoma", Font.PLAIN, 18));
		StockId.setBounds(161, 116, 147, 36);
		frmBuyStock.getContentPane().add(StockId);
		StockId.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Stock Id");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(28, 119, 127, 33);
		frmBuyStock.getContentPane().add(lblNewLabel);
		
		JLabel lblNoOfShares = new JLabel("No of shares");
		lblNoOfShares.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNoOfShares.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNoOfShares.setBounds(28, 177, 127, 33);
		frmBuyStock.getContentPane().add(lblNoOfShares);
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
			}
		});
		textField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField.setColumns(10);
		textField.setBounds(161, 175, 147, 36);
		frmBuyStock.getContentPane().add(textField);
		
		JLabel lblTransaction = new JLabel("Transaction");
		lblTransaction.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTransaction.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTransaction.setBounds(28, 72, 127, 33);
		frmBuyStock.getContentPane().add(lblTransaction);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Buy", "Sell"}));
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 18));
		comboBox.setToolTipText("Buy");
		comboBox.setEditable(true);
		comboBox.setBackground(new Color(255, 255, 255));
		comboBox.setBounds(161, 71, 127, 34);
		frmBuyStock.getContentPane().add(comboBox);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Send confirmation message");
		chckbxNewCheckBox.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		chckbxNewCheckBox.setSelected(true);
		chckbxNewCheckBox.setFont(new Font("Tahoma", Font.PLAIN, 22));
		chckbxNewCheckBox.setBounds(130,231 , 346, 50);
		frmBuyStock.getContentPane().add(chckbxNewCheckBox);
		
		JLabel lblNewLabel_1 = new JLabel("Account Details");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(427, 20, 349, 190);
		frmBuyStock.getContentPane().add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Generate bill");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(116, 301, 171, 44);
		frmBuyStock.getContentPane().add(btnNewButton);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		btnClear.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnClear.setBounds(511, 301, 171, 44);
		frmBuyStock.getContentPane().add(btnClear);
		
		JTextArea txtrStockSymbolUser = new JTextArea();
		txtrStockSymbolUser.setEnabled(false);
		txtrStockSymbolUser.setEditable(false);
		txtrStockSymbolUser.setLineWrap(true);
		txtrStockSymbolUser.setFont(new Font("Monospaced", Font.PLAIN, 18));
		txtrStockSymbolUser.setText("Stock symbol:\r\nUser Id:\r\nAmount transacted:");
		txtrStockSymbolUser.setBounds(58, 363, 504, 135);
		frmBuyStock.getContentPane().add(txtrStockSymbolUser);
	}
}
