
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
	
}
