import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.InputMethodListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputMethodEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import org.json.JSONException;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JComboBox;
import java.awt.Color;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.swing.JTable;

public class OnBuy extends JFrame implements ActionListener{
	private StockAccount stAcc;
	private String userId;
	private String transaction;
	private String stockId;
	private int qty;
	private JFrame frmBuyStock;
	private JTextField StockId;
	private JTextField textField;
	private JButton btnClear;
	private JButton btnConfirm;
	private JComboBox tradeType;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
//		OnBuy trade=new OnBuy("ID1");
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					OnBuy window = new OnBuy();
//					window.frmBuyStock.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
	}

	/**
	 * Create the application.
	 */
	public StockAccount getObj() {
		return stAcc;
	}

	public void setObj(StockAccount obj) {
		this.stAcc = obj;
	}
	
	public OnBuy(String userId) {
		initialize();
		this.userId=userId;
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmBuyStock = this;
		frmBuyStock.setTitle("Trade Stock");
		frmBuyStock.setBounds(100, 100, 800, 600);
		frmBuyStock.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmBuyStock.getContentPane().setLayout(null);
//		frmBuyStock.setVisible(true);
		
		StockId = new JTextField();
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
//		textField.addKeyListener(new KeyAdapter() {
//			@Override
//			public void keyTyped(KeyEvent e) {
//			}
//		});
		textField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField.setColumns(10);
		textField.setBounds(161, 175, 147, 36);
		frmBuyStock.getContentPane().add(textField);
		
		JLabel lblTransaction = new JLabel("Transaction");
		lblTransaction.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTransaction.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTransaction.setBounds(28, 72, 127, 33);
		frmBuyStock.getContentPane().add(lblTransaction);
		
		tradeType = new JComboBox();
		tradeType.setModel(new DefaultComboBoxModel(new String[] {"Buy", "Sell"}));
		tradeType.setFont(new Font("Tahoma", Font.PLAIN, 18));
		tradeType.setToolTipText("Buy");
		tradeType.setEditable(true);
		tradeType.setBackground(new Color(255, 255, 255));
		tradeType.setBounds(161, 71, 127, 34);
		frmBuyStock.getContentPane().add(tradeType);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Send confirmation message");
//		chckbxNewCheckBox.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent e) {
//			}
//		});
		chckbxNewCheckBox.setSelected(true);
		chckbxNewCheckBox.setFont(new Font("Tahoma", Font.PLAIN, 22));
		chckbxNewCheckBox.setBounds(130,231 , 346, 50);
		frmBuyStock.getContentPane().add(chckbxNewCheckBox);
		JLabel lblNewLabel_1 = new JLabel("Account Details");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(427, 20, 349, 190);
		frmBuyStock.getContentPane().add(lblNewLabel_1);
		
		JButton billButton = new JButton("Generate bill");
//		btnNewButton.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent e) {
//			}
//		});
		billButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		billButton.setBounds(116, 301, 171, 44);
		frmBuyStock.getContentPane().add(billButton);
		btnClear = new JButton("Clear");
//		btnClear.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent e) {
////				transaction=comboBox.getName();
//				
//			}
//		});
		btnClear.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnClear.setBounds(511, 301, 171, 44);
		frmBuyStock.getContentPane().add(btnClear);
		
		JTextArea billArea = new JTextArea();
		billArea.setEnabled(false);
		billArea.setEditable(false);
		billArea.setLineWrap(true);
		billArea.setFont(new Font("Monospaced", Font.PLAIN, 18));
		billArea.setText("Stock symbol:\r\nUser Id:\r\nAmount transacted:");
		billArea.setBounds(117, 402, 504, 135);
		frmBuyStock.getContentPane().add(billArea);
		
		btnConfirm = new JButton("Confirm");
		this.setVisible(true);
		btnConfirm.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnConfirm.setBounds(319, 301, 171, 44);
		frmBuyStock.getContentPane().add(btnConfirm);
		btnConfirm.addActionListener(this);
		btnClear.addActionListener(this);
		billButton.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==btnConfirm) {
			try {
				stAcc=new StockAccount(userId);
				System.out.println("Balance before transaction:"+stAcc.getBalance());
			} catch (JSONException | IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			transaction=tradeType.getSelectedItem().toString();
			stockId=StockId.getText();
//			qty=textField.getText();
			qty=Integer.parseInt(textField.getText());
			System.out.println(transaction);
			System.out.println(qty);
			System.out.println(stockId);
			if(transaction=="Buy") {
				try {
					stAcc.buyStock(stockId, qty);
					System.out.println("Balance after transaction:"+stAcc.getBalance());
				} catch (JSONException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			if(transaction=="Sell") {
				try {
					stAcc.sellStock(stockId, qty);
					System.out.println("Balance after transaction:"+stAcc.getBalance());
				} catch (JSONException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
		}
	}



