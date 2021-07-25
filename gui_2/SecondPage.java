import org.json.JSONException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

public class SecondPage extends JFrame implements ActionListener {
    JButton submit_button;
    JTextField passwordTextField;

    int choice;
    SecondPage(int choice) throws FileNotFoundException, JSONException {
        this.choice = choice;
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(500,600);

        submit_button = new JButton("Submit ");
        submit_button.setBounds(100,250,120,25);
        submit_button.addActionListener(this);
        submit_button.setBorder(BorderFactory.createEtchedBorder());
        submit_button.setFocusable(false);

        passwordTextField = new JTextField();
        passwordTextField.setBounds(100,150,120,25);



        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(30,150,120,25);

        this.setSize(500,600);
        this.add(submit_button);

        this.add(passwordLabel);
        this.add(passwordTextField);
        this.getContentPane().setBackground(Color.GRAY);
        this.setVisible(true);
        if(choice==1){
            this.logsin();
        }
        else if(choice==2){
            this.createAc();
        }

    }
    JTextField UserID_TextField;
    JLabel UserID_JLabel;
    public void logsin(){

        UserID_JLabel = new JLabel("User Id");
        UserID_JLabel.setBounds(30,120,120,25);

        UserID_TextField = new JTextField();
        UserID_TextField.setBounds(100,120,120,25);
        UserID_TextField.setPreferredSize(new Dimension(120,25));

        JLabel H_LogIn_Jlabel = new JLabel("Log In");
        H_LogIn_Jlabel.setBounds(10,10,120,25);
        this.add(H_LogIn_Jlabel);
        this.add(UserID_TextField);
        this.add(UserID_JLabel);

    }
    JTextField Username_TextField, Balance_TextField;
    public void createAc(){
        JLabel H_CreateAccount_JLabel = new JLabel("Create Account ");
        H_CreateAccount_JLabel.setBounds(10,10,120,25);

        JLabel userNameLabel = new JLabel("Username");
        userNameLabel.setBounds(30,120,120,25);

        Username_TextField = new JTextField();
        Username_TextField.setBounds(100,120,120,25);
        Username_TextField.setPreferredSize(new Dimension(120,25));

        Balance_TextField = new JTextField();
        Balance_TextField.setBounds(100,180,120,25);
        Balance_TextField.setPreferredSize(new Dimension(120,25));

        JLabel userBalance_JLabel = new JLabel("Balance");
        userBalance_JLabel.setBounds(30,180,120,25);

        this.add(userNameLabel);
        this.add(H_CreateAccount_JLabel);
        this.add(userBalance_JLabel);
        this.add(Username_TextField);
        this.add(Balance_TextField);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        LogIn log= null;
        try {
            log = new LogIn();
        } catch (JSONException jsonException) {
            jsonException.printStackTrace();
        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        }
        String password_entered = passwordTextField.getText();
        if(e.getSource()==submit_button){
        if (choice ==1){

                String userID_entered = UserID_TextField.getText();
                Account acc = new Account(userID_entered,password_entered);
                boolean check= false;
                try {
                    check = log.SignIN(acc);
                } catch (JSONException jsonException) {
                    jsonException.printStackTrace();
                }
                if(check) {
                    System.out.println("welcome");
                    // on login do other stuff here
                }
                else {
                    System.out.println("Incorrect password");

                }
        }
        else if(choice ==2){

            String UserName_entered = Username_TextField.getText();
            double balance_entered = Double.parseDouble(Balance_TextField.getText());
            Account acc=new Account(UserName_entered, password_entered,balance_entered);
            LogIn log2= null;
            try {
                log2 = new LogIn();
            } catch (JSONException jsonException) {
                jsonException.printStackTrace();
            } catch (FileNotFoundException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
            }
            try {
                log2.SignUp(acc);
            } catch (JSONException jsonException) {
                jsonException.printStackTrace();
            }
            System.out.println("Your UserId is "+acc.getUserId());
            // after sign up, you're logged in , do other stuff here
        }

    }
}}
