import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Dimension;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class OnLogin extends JFrame implements ActionListener{

	private JFrame frmStockAccount;

	JButton Trade_Button, My_Stocks_Button , Portfolio_Button;
	JButton Market_Performance_Button, Wishlist_Button, My_Account_Button;

	String UserID;
	public OnLogin(String UserID) {
		initialize();
		this.UserID = UserID;

	}

	/**
	 * Initialize the contents of the frame.
	 */
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
		My_Stocks_Button.setPreferredSize(new Dimension(91, 21));
		
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
		
		JLabel lblNewLabel = new JLabel("Welcome!");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel.setPreferredSize(new Dimension(90, 93));
		GroupLayout groupLayout = new GroupLayout(frmStockAccount.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(143)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(Trade_Button, GroupLayout.PREFERRED_SIZE, 173, GroupLayout.PREFERRED_SIZE)
						.addComponent(Wishlist_Button, GroupLayout.PREFERRED_SIZE, 173, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(12)
							.addComponent(My_Account_Button, GroupLayout.PREFERRED_SIZE, 184, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 186, GroupLayout.PREFERRED_SIZE)
							.addComponent(My_Stocks_Button, GroupLayout.PREFERRED_SIZE, 173, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(Portfolio_Button, GroupLayout.PREFERRED_SIZE, 173, GroupLayout.PREFERRED_SIZE)
						.addComponent(Market_Performance_Button, GroupLayout.PREFERRED_SIZE, 231, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(21, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(72)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
					.addGap(137)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(Trade_Button, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addComponent(My_Stocks_Button, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addComponent(Portfolio_Button, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
					.addGap(59)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(Wishlist_Button, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(My_Account_Button, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
							.addComponent(Market_Performance_Button, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(107, Short.MAX_VALUE))
		);
		frmStockAccount.getContentPane().setLayout(groupLayout);

//		this.add(Trade_Button);
//		this.add(My_Stocks_Button);
//		this.add(Market_Performance_Button);
//		this.add(Portfolio_Button);
//		this.add(My_Account_Button);
//		this.add(Wishlist_Button);
//		this.add(lblNewLabel);
		Trade_Button.addActionListener(this);
		My_Account_Button.addActionListener(this);
		Market_Performance_Button.addActionListener(this);
		Portfolio_Button.addActionListener(this);
		My_Account_Button.addActionListener(this);
		Wishlist_Button.addActionListener(this);

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
	}
	if(e.getSource()==Market_Performance_Button){
		// market performance
		System.out.println("Market performance");
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
