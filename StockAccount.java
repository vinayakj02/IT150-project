import java.util.*;
import org.json.*;
import java.io.*;


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
	public void sellStock(Stock obj,int no)throws Exception
	{
		Scanner ob=new Scanner(System.in);
		String symb=obj.getSymbol();
		boolean check;
		String s="";
        FileReader reader = new FileReader("data222.json");
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
		JSONObject jstock=jid.getJSONObject(symb);
		int quant=Integer.parseInt(jstock.getString("CurrentHolding"));
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
					jstock.put("CurrentHolding",String.format("%d", quant-re_no));
					jid.put("OverallCurrentHolding",String.format("%d", Integer.parseInt(jid.getString("OverallCurrentHolding"))-re_no));
					jid.put("OverallSales",String.format("%f",Float.parseFloat(jid.getString("OverallSales"))+(Float.parseFloat(String.format("%.2f", re_no*obj.getClosePrice()) ))));
					
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
			jstock.put("CurrentHolding",String.format("%d", quant-no));
			jid.put("OverallCurrentHolding",String.format("%d", Integer.parseInt(jid.getString("OverallCurrentHolding"))-no));
			jid.put("OverallSales",String.format("%f",Float.parseFloat(jid.getString("OverallSales"))+(Float.parseFloat(String.format("%.2f", (no*obj.getClosePrice()) )))));
			// display invoice.....
			
		}
			// To update the StockAccount file
			jid.put(symb,jstock);
			jo.put(userID, jid);
			 try {
		         FileWriter file = new FileWriter("data222.json");
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
		Account a=new Account();
		StockAccount s=new StockAccount("id1",a);
		Stock sto = null;
		try {
			sto = new Stock("IBM");
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			s.sellStock(sto, 210);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	

	}

}

