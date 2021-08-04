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
....to be filled by Pranav
	*/
	// To sell 'no' quantity of Share/Stock obj
	public void sellStock(String symb,int no)throws Exception
	{
		Scanner ob=new Scanner(System.in);
		boolean check;
		String s="";
        FileReader reader = new FileReader("StockData.json");
        Scanner scan = new Scanner(reader);
        while(scan.hasNext()){
            s = s + scan.nextLine();
        }
        reader.close();
		
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
		LocalDateTime date = LocalDateTime.now().minusDays((long)1.0);
        String d = date.toString().substring(0,10);
        String day = date.getDayOfWeek().toString();
        String LatestDay ;
        if(day.equals("SUNDAY")){
            LatestDay = date.minusDays((long) 2.0).toString().substring(0,10);
        }
        else if(day.equals("SATURDAY")){
            LatestDay = date.minusDays((long) 1.0).toString().substring(0,10);
        }
        else{
            LatestDay = d;
        }
		JSONObject jstock=jid.getJSONObject(symb);
		Stock obj=new Stock(symb);
		int quant=Integer.parseInt(jstock.getString("CurrentHolding"));
		JSONObject jsale =jstock.getJSONObject("Sales");
		//To check if user has required quantity of that particular stock to be sold
		if(Integer.parseInt(jstock.getString("CurrentHolding"))<no)
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
					System.out.println("Your current balance = "+acc.getBalance())	;				//tax and brokerage calculations to be dealt later
					System.out.println(re_no+" shares of "+symb+"sold...");
					System.out.println("Current holding of "+symb+" = "+(quant-re_no));
					
					jsale.put(LatestDay,String.format("%d", re_no));
					jstock.put("CurrentHolding",String.format("%d", quant-re_no));
					
					// display invoice.....
					
					
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
			System.out.println("Your current balance = "+acc.getBalance())	;
			//tax and brokerage calculations to be dealt later
			System.out.println(no+" shares of "+symb+"sold...");
			System.out.println("Current holding of "+symb+" = "+(quant-no));
			jsale.put(LatestDay,String.format("%d", no));
			jstock.put("CurrentHolding",String.format("%d", quant-no));
			// display invoice.....
			
		}
			// To update the StockAccount file
		jstock.put("Sales", jsale);
			jid.put(symb,jstock);
			jo.put(userID, jid);
			 try {
		         FileWriter file = new FileWriter("StockData.json");
//		         file.write(jsonObject.toJSONString());
		         file.write(jo.toString());
		         file.close();
		      } catch (IOException e) {
		         // TODO Auto-generated catch block
		         e.printStackTrace();
		      }
			 
		
		return;
		
		
	}
	//....some methods to be added after discussion 
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Account a=new Account("id2","abc");
		StockAccount s=new StockAccount("id2",a);
		Stock sto = null;
		try {
			sto = new Stock("MSFT");
		} catch (JSONException e) {
			// TODO Auto-generat)ed catch block
			e.printStackTrace();
		}
		try {
			s.sellStock("MSFT", 210);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	

	}

}

