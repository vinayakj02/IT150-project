import java.io.FileNotFoundException;
import java.util.Scanner;

import org.json.JSONException;

public class PossibleMain {
	static Scanner scan;
	public static int openingPage() {
		scan=new Scanner(System.in);
		System.out.println("1.Create new account\n2.Log-in\n3.Exit\nPlease choose one of the above options");
		int choice=scan.nextInt();
		return choice;
	}
	public static void createAccount() throws FileNotFoundException, JSONException {
		scan=new Scanner(System.in);
		System.out.println("Enter username: ");
		String username=scan.next();
		System.out.println("Enter password: ");
		String password=scan.next();
		System.out.println("Enter the amount you would like to start with ");
		double balance=scan.nextDouble();
		Account acc=new Account(username, password,balance);
//		LogIn log=new LogIn();
		LogIn log=new LogIn();
		log.SignUp(acc);
		System.out.println("Your UserId is "+acc.getUserId());
		onLogin();
	}
	public static void LogIn() throws FileNotFoundException, JSONException {
		scan=new Scanner(System.in);
		System.out.println("Enter your userID ");
		String userId=scan.next();
		LogIn log=new LogIn();
		if(log.accountExists(userId)) {
			System.out.println("Enter your password ");
			String password=scan.next();
			Account acc=new Account(userId, password);
			boolean check=log.SignIN(acc);
			if(check) {
				onLogin();
			}
			else {
				System.out.println("Incorrect password");
				int ch=openingPage();
				manipulateChoice(ch);
			}
		}
		else {
			System.out.println("Invalid user Id entered.");
			int ch=openingPage();
			manipulateChoice(ch);
		}
	}
	public static void exit() {
		System.out.println("Thank you");
	}
	public static void manipulateChoice(int choice) throws FileNotFoundException, JSONException {
		scan=new Scanner(System.in);
		if(choice==1) {
			createAccount();
		}
		else if(choice==2) {
			LogIn();
		}
		else if(choice==3) {
			exit();
		}
		else {
			System.out.println("Invalid choice");
			int ch=openingPage();
			manipulateChoice(ch);
		}
	}
	public static void onLogin() {
		System.out.println("Welcome!");
		//...to be filled in
	}
	public static void main(String[] args) throws FileNotFoundException, JSONException {
		// TODO Auto-generated method stub
		scan=new Scanner(System.in);
		int choice=openingPage();
		manipulateChoice(choice);
	}

}
