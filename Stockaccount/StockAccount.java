import java.time.LocalDateTime;
import java.util.*;
import org.json.*;
import java.io.*;
import java.time.LocalDateTime;

public class StockAccount  {
	private String userID;
	private Account acc;
	public StockAccount(String userID,Account acc)
	{
		this.userID=userID;
		this.acc=acc;
		
	}
	/*
	public void buyStocks(Stock obj,int no)
	{
		Scanner ob=new Scanner(System.in);
		boolean check;
			check=acc.deductMoney(no*obj.getClosePrice());
			if(!check)
			{
				System.out.println("Sorry!!You dont have enough money for purchasing "+no+obj.getName()+"shares. ");
				int pos=(acc.getBalance()/obj.getClosePrice());
				System.out.println("You can buy only "+pos+"shares of the company.Enter Y for rechoosing no of shares of this company you want to purchase,N for cancelling this share's purchase");
				char choice=ob.next().charAt(0);
				int re_no;
				if((choice=='Y')||(choice=='y'))
				{
				
					System.out.println("Re-Enter the no of shares of "+obj.getName()+"you want to buy");
					re_no=ob.nextInt();
					if(re_no<=pos)
					{
						acc.deductMoney(re_no*obj.getClosePrice());
					}
			}
		}
	}
	*/
	public void buyStock(Stock obj, int no) throws Exception{
		Scanner sc=new Scanner(System.in);
		String symbol= obj.getSymbol();
		String s="";
		FileReader read = new FileReader("data222.json");
		Scanner scan = new Scanner(read);
		while(scan.hasNext()){
			s = s + scan.nextLine();
		}
		boolean check;
		check=acc.deductMoney(no*obj.getClosePrice());
		if(!check) {
			System.out.println("Sorry!!You dont have enough money for purchasing " + no + obj.getSymbol() + "shares. ");
			double pos = (acc.getBalance() / obj.getClosePrice());
			System.out.println("You can buy only " + pos + "shares of the company.Enter Y for rechoosing no of shares of this company you want to purchase,N for cancelling this share's purchase");
			char choice = sc.next().charAt(0);
			int re_no;
			if ((choice == 'Y') || (choice == 'y')) {

				System.out.println("Re-Enter the no of shares of " + obj.getSymbol() + "you want to buy");
				re_no = sc.nextInt();
				if (re_no <= pos) {
					acc.deductMoney(re_no * obj.getClosePrice());
				}
			}
		}
		else {


			JSONObject outerMost = new JSONObject(s);
			if (!outerMost.has(userID)) {
				JSONObject id3 = new JSONObject();
				outerMost.accumulate(userID, id3);
				JSONObject StockSym = new JSONObject();
				id3.accumulate(symbol, StockSym);
				LocalDateTime date = LocalDateTime.now().minusDays((long) 1.0);
				String d = date.toString().substring(0, 10);
				JSONObject currentdate = new JSONObject();
				StockSym.accumulate(d, currentdate);
				currentdate.put("Price", obj.getClosePrice());
				currentdate.put("Quantity", no);
				id3.getJSONObject(symbol).put("totalQuantity", String.valueOf(no));
				id3.getJSONObject(symbol).put("WorthMoney", no * obj.getClosePrice());
//			id3.accumulate(symbol, StockSym);

				try {
					FileWriter file = new FileWriter("data222.json");
//	         file.write(jsonObject.toJSONString());
					file.write(outerMost.toString());
					file.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
//			acc.deductMoney(no*obj.getClosePrice());
//			System.out.println("PurchaseSuccessfull");
//			System.out.println(acc.getBalance());
			} else {
				JSONObject idExist = outerMost.getJSONObject(userID);
				outerMost.put(userID, idExist);
//			outerMost.accumulate(userID,idExist);
				if (!idExist.has(symbol)) {
					JSONObject stockBuying = idExist.getJSONObject(symbol);
//				idExist.accumulate(symbol,stockBuying);
					LocalDateTime date = LocalDateTime.now().minusDays((long) 1.0);
					String d1 = date.toString().substring(0, 10);
//				JSONObject dateToday =new JSONObject();
					JSONObject dateToday = stockBuying.getJSONObject(d1);
					stockBuying.put("totalQuantity", 78);
					stockBuying.put("WorthMoney", 7654);
					dateToday.put("Quantity", no);
					dateToday.put("worthMoney", no * obj.getClosePrice());
					stockBuying.put(d1, dateToday);
					idExist.put(symbol, stockBuying);
					outerMost.put(userID, idExist);
					try {
						FileWriter file = new FileWriter("data222.json");
//	         file.write(jsonObject.toJSONString());
						file.write(outerMost.toString());
						file.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} else {
//				JSONObject stockBuying = new JSONObject();
					JSONObject stockBuying = idExist.getJSONObject(symbol);
					LocalDateTime date = LocalDateTime.now().minusDays((long) 1.0);
					String d1 = date.toString().substring(0, 10);
//				JSONObject dateToday =new JSONObject();
					JSONObject dateToday = stockBuying.getJSONObject(d1);
					dateToday.put("Quantity", no);
					dateToday.put("worthMoney", no * obj.getClosePrice());
					stockBuying.put(d1, dateToday);
					idExist.put(symbol, stockBuying);
					outerMost.put(userID, idExist);
					try {
						FileWriter file = new FileWriter("data222.json");
//	         file.write(jsonObject.toJSONString());
						file.write(outerMost.toString());
						file.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}


	}


	public void sellStock(Stock obj,int no)throws Exception
	{
		Scanner ob=new Scanner(System.in);
		String symb=obj.getSymbol();
//		boolean check;
		String s="";
        FileReader reader = new FileReader("data222.json");
        Scanner scan = new Scanner(reader);
        while(scan.hasNext()){
            s = s + scan.nextLine();
        }
		
		JSONObject jo=new JSONObject(s);
		if(!jo.has(userID))
		{
			System.out.println("No Stocks owned by you");
			return;
		}
		JSONObject jid=jo.getJSONObject(userID);
		if(!jid.has(symb))
		{
			System.out.println("No stock of "+symb+" found in our portfolio!!!!");
			return;
		}
		JSONObject jstock=jid.getJSONObject(symb);
		int quant=Integer.parseInt(jstock.getString("totalQuantity"));
		if(Integer.parseInt(jstock.getString("totalQuantity"))<no)
		{
			System.out.println("You have only "+quant+"shares of the company.Enter Y for rechoosing no of shares of this company you want to sell,N for cancelling this share's sales");
			char choice=ob.next().charAt(0);
			int re_no;
			if((choice=='Y')||(choice=='y'))
			{
				System.out.println("Re-Enter the no of shares of "+symb+"you want to sell");
				re_no=ob.nextInt();
				if(re_no<=quant)
				{
					acc.addMoney(re_no*obj.getClosePrice());
					//tax and brokerage calculations to be dealt later
					System.out.println(re_no+" shares of "+symb+"sold...");
					System.out.println("Current holding of "+symb+" = "+(quant-re_no));
					jstock.put("totalQuantity",String.format("%d", quant-re_no));
					// display invoice.....
					return ;
					
				}
				else
				{
					System.out.println("You have again entered invalid no of shares to sell. So cancelling this sale");
					return;
				}
			
		}
		}
		else
		{
			acc.addMoney(no*obj.getClosePrice());
			//tax and brokerage calculations to be dealt later
			System.out.println(no+" shares of "+symb+"sold...");
			System.out.println("Current holding of "+symb+" = "+(quant-no));
			jstock.put("totalQuantity",String.format("%d", quant-no));
			// display invoice.....
			return ;

		}
		jid.put(symb,jstock);
		jo.put(userID, jid);
		 try {
	         FileWriter file = new FileWriter("data222.json");
//	         file.write(jsonObject.toJSONString());
	         file.write(jo.toString());
	         file.close();
	      } catch (IOException e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	      }
		
	}
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Account a=new Account("id1","jhgfc",5000.0);
		StockAccount s=new StockAccount("id4",a);
		Stock sto = null;
		try {
			sto = new Stock("MSFT");
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			s.buyStock(sto,2);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	

	}

}

