import org.json.JSONException;

import java.io.IOException;

public class Account {
	
	private final String userId;
	private String userName;
	private String password;
	private double balance;
	public String generateId() {
		final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
		String s="";
		for(int i=0;i<4;i++) {
			int num=(int)(Math.random()*62);
			char ch=AB.charAt(num);
			s+=ch;
		}
		return "ID" + s;
	}
	public String getPassword() {
		return password;
	}
	public Account(String userName,String password,double balance) {
		this.userId=generateId();
		this.userName=userName;
		this.password=password;
		this.balance=balance;
	}
	public Account(String userId,String password) {
		this.userId=userId;
		this.userName="";
		this.password=password;
		this.balance=0;
	}
	public Account(String userId,String userName,String password,double balance) {
		this.userId=userId;
		this.userName=userName;
		this.password=password;
		this.balance=balance;
	}
	public Account(String userId){
		this.userId = userId;
	}
	public String getUserId() {
		return this.userId;
	}
	public String getUserName() {
		return this.userName;
	}
	public double getBalance() throws JSONException {
		return this.balance;
	}
	//This method adds sales amount to user bank account 
//public void addMoney(double amt) throws JSONException, IOException {
//	balance+=amt;
//	System.out.println("Transaction Successful");
//	System.out.println(String.format("%.2f",amt)+"credited to your account");
//}
// This method deducts purchase amount from user bank account after ensuring enough bank balance
//public boolean deductMoney(double amt)
//{
//	if(amt<=balance)
//	{
//		balance-=amt;
//		System.out.println("Transaction Successful");
//		System.out.println(String.format("%.2f",amt)+"debited from your account");
//		return true;
//	}
//	else
//	{
//		System.out.println("Transaction Unsuccessful due to shortage of money in your account");
//		return false;
//	}
//}
}
