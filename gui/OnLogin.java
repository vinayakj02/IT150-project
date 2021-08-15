import java.awt.EventQueue;

import javax.swing.*;
import java.awt.BorderLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Dimension;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class OnLogin extends JFrame implements ActionListener{

	private JFrame frmStockAccount;

	JButton Trade_Button, My_Stocks_Button , Portfolio_Button;
	JButton Market_Performance_Button, Wishlist_Button, My_Account_Button;
	private Portfolio port;
	private JTable table;

	String UserID;
	public OnLogin(String UserID) {
		this.UserID = UserID;
		try {
			port=new Portfolio(UserID);
		} catch (Exception e) {
			e.printStackTrace();
		}
		initialize();

	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void displayStocks() throws JSONException, IOException {
		StockAccount acc=new StockAccount(UserID);
		LinkedList<String> list=new LinkedList<>();
		list=acc.StockList();
		String rows[][]=new String[list.size()][4];
		String columns[]= {"S.No","Stock Id","Current holding","Stock price"};
		for(int i=0;i<list.size();i++) {
			Stock stock=new Stock(list.get(i));
			String sym=stock.getSymbol();
			String qty=String.valueOf(port.getStockHolding(stock));
			String price=String.valueOf(stock.getClosePrice());
			String row[]= {String.valueOf(i+1),sym,qty,price};
			rows[i]=row;
		}

		table=new JTable(rows, columns);

		JFrame f=new JFrame();
		table.setBounds(30,40,600,300);          
        	JScrollPane sp=new JScrollPane(table);    
        	f.add(sp);          
        	f.setSize(600,400);    
        	f.setVisible(true);
	}	

	public void overridebuttonslol(){
		Trade_Button.setBounds(100,200,120,25);
		Trade_Button.addActionListener(this);
		Trade_Button.setBackground(new Color(23,23,23));
		Trade_Button.setFont(new Font("Comic Sans",Font.ITALIC,15));
		Trade_Button.setForeground(Color.WHITE);
		Trade_Button.setBorder(BorderFactory.createEtchedBorder());
		Trade_Button.setFocusable(false);

		My_Stocks_Button.setBounds(100+120+5,200,120,25);
		My_Stocks_Button.addActionListener(this);
		My_Stocks_Button.setBackground(new Color(23,23,23));
		My_Stocks_Button.setFont(new Font("Comic Sans",Font.ITALIC,15));
		My_Stocks_Button.setForeground(Color.WHITE);
		My_Stocks_Button.setBorder(BorderFactory.createEtchedBorder());
		My_Stocks_Button.setFocusable(false);

		Portfolio_Button.setBounds(100+120+5+120+5,200,120,25);
		Portfolio_Button.addActionListener(this);
		Portfolio_Button.setBackground(new Color(23,23,23));
		Portfolio_Button.setFont(new Font("Comic Sans",Font.ITALIC,15));
		Portfolio_Button.setForeground(Color.WHITE);
		Portfolio_Button.setBorder(BorderFactory.createEtchedBorder());
		Portfolio_Button.setFocusable(false);

		Wishlist_Button.setBounds(100,200+30,120,25);
		Wishlist_Button.addActionListener(this);
		Wishlist_Button.setBackground(new Color(23,23,23));
		Wishlist_Button.setFont(new Font("Comic Sans",Font.ITALIC,15));
		Wishlist_Button.setForeground(Color.WHITE);
		Wishlist_Button.setBorder(BorderFactory.createEtchedBorder());
		Wishlist_Button.setFocusable(false);

		My_Account_Button.setBounds(100+120+5,200+30,120,25);
		My_Account_Button.addActionListener(this);
		My_Account_Button.setBackground(new Color(23,23,23));
		My_Account_Button.setFont(new Font("Comic Sans",Font.ITALIC,15));
		My_Account_Button.setForeground(Color.WHITE);
		My_Account_Button.setBorder(BorderFactory.createEtchedBorder());
		My_Account_Button.setFocusable(false);

		Market_Performance_Button.setBounds(100+120+5+120+5,200+30,120,25);
		Market_Performance_Button.addActionListener(this);
		Market_Performance_Button.setBackground(new Color(23,23,23));
		Market_Performance_Button.setFont(new Font("Comic Sans",Font.ITALIC,15));
		Market_Performance_Button.setForeground(Color.WHITE);
		Market_Performance_Button.setBorder(BorderFactory.createEtchedBorder());
		Market_Performance_Button.setFocusable(false);


		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1000,500);
		this.setLayout(null);
		this.getContentPane().setBackground(new Color(133,205,202));
		this.setVisible(true);

	}
	private void initialize() {

		frmStockAccount = this;
		frmStockAccount.getContentPane().setForeground(Color.DARK_GRAY);
		frmStockAccount.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 18));
		frmStockAccount.getContentPane().setName("Buy Stock");
		frmStockAccount.setTitle("Stock Account");
		frmStockAccount.setBounds(100, 100, 800, 600);
		frmStockAccount.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmStockAccount.setVisible(true);
		
		My_Stocks_Button = new JButton("My Stocks");
		My_Stocks_Button.setFont(new Font("Tahoma", Font.PLAIN, 18));
		My_Stocks_Button.setPreferredSize(new Dimension(200, 25));
		
		Portfolio_Button = new JButton("Portfolio");
		Portfolio_Button.setPreferredSize(new Dimension(91, 21));
		Portfolio_Button.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		My_Account_Button = new JButton("My Account");
		My_Account_Button.setPreferredSize(new Dimension(91, 21));
		My_Account_Button.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		Wishlist_Button = new JButton("Wishlist");
		Wishlist_Button.setForeground(Color.BLACK);
		Wishlist_Button.setPreferredSize(new Dimension(91, 21));
		Wishlist_Button.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		Market_Performance_Button = new JButton("Market Performance");
		Market_Performance_Button.setPreferredSize(new Dimension(91, 21));
		Market_Performance_Button.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		Trade_Button = new JButton("Trade");
		Trade_Button.setPreferredSize(new Dimension(91, 21));
		Trade_Button.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JLabel WelcomeUserLabel = new JLabel("Welcome");
		WelcomeUserLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		WelcomeUserLabel.setPreferredSize(new Dimension(100, 100));
		WelcomeUserLabel.setBounds(250,50,200,50);
		WelcomeUserLabel.setForeground(Color.black);

		this.add(Trade_Button);
		this.add(My_Stocks_Button);
		this.add(Market_Performance_Button);
		this.add(Portfolio_Button);
		this.add(My_Account_Button);
		this.add(Wishlist_Button);
//		Trade_Button.addActionListener(this);
//		My_Account_Button.addActionListener(this);
//		Market_Performance_Button.addActionListener(this);
//		Portfolio_Button.addActionListener(this);
//		My_Stocks_Button.addActionListener(this);
//		Wishlist_Button.addActionListener(this);
		this.overridebuttonslol();
		this.add(WelcomeUserLabel);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
	if(e.getSource()==Trade_Button){
		//trade here
		System.out.println("Trading ! ");
	}
	if(e.getSource()==My_Stocks_Button){
		// my stocks
		System.out.println("My Stocks ! ");
		try {
			displayStocks();
		} catch (JSONException | IOException e2) {
			e2.printStackTrace();
		}
	}
	if(e.getSource()==Market_Performance_Button){
		// market performance
		System.out.println("Market performance !");
	}
	if(e.getSource()==My_Account_Button){
		// My account
		System.out.println("My Account ! ");
	}
	if(e.getSource()==Portfolio_Button){
		//portfolio
		System.out.println("Portfolio ! ");

	}
	if(e.getSource()==Wishlist_Button){
		//wishlist
		System.out.println("Wishlist ! ");
	}

	}
}
