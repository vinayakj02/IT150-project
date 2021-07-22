
public class Account {
	private final String userId;
	private String userName;
	private String password;
	private double balance;
	public Account() {
		this.userId="";
		this.userName="";
		this.password="";
		this.balance=0.0;
	}
	public Account(String userId,String userName,String password,double balance) {
		this.userId=userId;
		this.userName=userName;
		this.password=password;
		this.balance=balance;
	}
	public String getUserId() {
		return this.userId;
	}
	public String getUserName() {
		return this.userName;
	}
	public double getBalance() {
		return this.balance;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	//This method adds sales amount to user bank account 
public void addMoney(double amt)
{
	balance+=amt;
	System.out.println("Transaction Successful");
	System.out.println(String.format("%.2f",amt)+"credited to your account");
}
// This method deducts purchase amount from user bank account after ensuring enough bank balance
public boolean deductMoney(double amt)
{
	if(amt<=balance)
	{
		balance-=amt;
		System.out.println("Transaction Successful");
		System.out.println(String.format("%.2f",amt)+"debited from your account");
		return true;
	}
	else
	{
		System.out.println("Transaction Unsuccessful due to shortage of money in your account");
		return false;
	}
}
	
}
