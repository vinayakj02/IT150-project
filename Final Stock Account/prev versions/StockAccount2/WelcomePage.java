import org.json.JSONException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class WelcomePage extends JFrame implements ActionListener {

    StockAccount2 stockAccount;
    WelcomePage(String userId) throws JSONException, IOException {
        stockAccount = new StockAccount2(userId);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(500,600);
        this.getContentPane().setBackground(new Color(64,179,162));
        this.setVisible(true);

        JLabel usernameJlabel = new JLabel("USERNAME ");
        usernameJlabel.setBounds(30,120,240,50);
        usernameJlabel.setForeground(Color.WHITE);

        JLabel usernameValueJlabel = new JLabel(stockAccount.getUsername());
        usernameValueJlabel.setBounds(120,120,240,50);
        usernameValueJlabel.setForeground(Color.WHITE);

        JLabel userIdLabel3 = new JLabel("USER ID ");
        userIdLabel3.setBounds(30,120+30,240,50);
        userIdLabel3.setForeground(Color.WHITE);

        JLabel userIdValueJLabel3 = new JLabel(userId);
        userIdValueJLabel3.setBounds(120,120+30,240,50);
        userIdValueJLabel3.setForeground(Color.WHITE);

        JLabel userAccBalance = new JLabel("BALANCE ");
        userAccBalance.setBounds(30,120+60,240,50);
        userAccBalance.setForeground(Color.WHITE);

        JLabel userAccBalanceValue = new JLabel(String.format("%f",stockAccount.getBalance()));
        userAccBalanceValue.setBounds(120,120+60,240,50);
        userAccBalanceValue.setForeground(Color.WHITE);

        this.add(usernameJlabel);
        this.add(usernameValueJlabel);
        this.add(userIdLabel3);
        this.add(userIdValueJLabel3);
        this.add(userAccBalance);
        this.add(userAccBalanceValue);


    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
