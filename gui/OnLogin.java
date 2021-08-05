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

public class OnLogin {

	private JFrame frmStockAccount;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OnLogin window = new OnLogin();
					window.frmStockAccount.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public OnLogin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmStockAccount = new JFrame();
		frmStockAccount.getContentPane().setForeground(Color.DARK_GRAY);
		frmStockAccount.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 18));
		frmStockAccount.getContentPane().setName("Buy Stock");
		frmStockAccount.setTitle("Stock Account");
		frmStockAccount.setBounds(100, 100, 800, 600);
		frmStockAccount.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btnNewButton_1 = new JButton("My Stocks");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton_1.setPreferredSize(new Dimension(91, 21));
		
		JButton btnNewButton_1_1 = new JButton("Portfolio");
		btnNewButton_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		btnNewButton_1_1.setPreferredSize(new Dimension(91, 21));
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JButton btnNewButton_1_2 = new JButton("My Account");
		btnNewButton_1_2.setPreferredSize(new Dimension(91, 21));
		btnNewButton_1_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JButton btnNewButton_1_2_1 = new JButton("Wishlist");
		btnNewButton_1_2_1.setForeground(Color.BLACK);
		btnNewButton_1_2_1.setPreferredSize(new Dimension(91, 21));
		btnNewButton_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JButton btnNewButton_1_2_2 = new JButton("Market Performance");
		btnNewButton_1_2_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1_2_2.setPreferredSize(new Dimension(91, 21));
		btnNewButton_1_2_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JButton btnNewButton_1_2_3 = new JButton("Trade");
		btnNewButton_1_2_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1_2_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		btnNewButton_1_2_3.setPreferredSize(new Dimension(91, 21));
		btnNewButton_1_2_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JLabel lblNewLabel = new JLabel("Welcome!");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel.setPreferredSize(new Dimension(90, 93));
		GroupLayout groupLayout = new GroupLayout(frmStockAccount.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(143)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnNewButton_1_2_3, GroupLayout.PREFERRED_SIZE, 173, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton_1_2_1, GroupLayout.PREFERRED_SIZE, 173, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(12)
							.addComponent(btnNewButton_1_2, GroupLayout.PREFERRED_SIZE, 184, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 186, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 173, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNewButton_1_1, GroupLayout.PREFERRED_SIZE, 173, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton_1_2_2, GroupLayout.PREFERRED_SIZE, 231, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(21, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(72)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
					.addGap(137)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton_1_2_3, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton_1_1, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
					.addGap(59)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNewButton_1_2_1, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnNewButton_1_2, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnNewButton_1_2_2, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(107, Short.MAX_VALUE))
		);
		frmStockAccount.getContentPane().setLayout(groupLayout);
	}
}
