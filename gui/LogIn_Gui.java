import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LogIn_Gui {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame f=new JFrame("Login");//creating instance of JFrame  
	    JLabel l1,l2;  
	    l1=new JLabel("Username");  //Create label Username
	    l1.setBounds(30,15, 100,30); //x axis, y axis, width, height 
	     
	    l2=new JLabel("Password");  //Create label Password
	    l2.setBounds(30,50, 100,30);    
	     
	    JTextField F_user = new JTextField(); //Create text field for username
	    F_user.setBounds(110, 15, 200, 30);
	         
	    JPasswordField F_pass=new JPasswordField(); //Create text field for password
	    F_pass.setBounds(110, 50, 200, 30);
	       
	    JButton login_but=new JButton("Login");//creating instance of JButton for Login Button
	    login_but.setBounds(130,90,80,25);
	    f.add(F_pass); //add password
	    f.add(login_but);//adding button in JFrame  
	    f.add(F_user);  //add user
	    f.add(l1);  // add label1 i.e. for username
	    f.add(l2); // add label2 i.e. for password
	     
	    f.setSize(400,180);//400 width and 500 height  
	    f.setLayout(null);//using no layout managers  
	    Color color=new Color(100,100,100);
	    f.getContentPane().setBackground(color);
	    f.setVisible(true);//making the frame visible 
	    f.setLocationRelativeTo(null);
	}

}
