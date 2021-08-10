import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Iterator;
import java.util.Scanner;

import org.json.*;

public class Portfolio implements Portfolio_Interface {
private String userId;
private JSONObject jo,jid; 
public int getStockHolding(Stock s) throws JSONException
{
	JSONObject jstock=jid.getJSONObject(s.getSymbol());
	return (Integer.parseInt(jstock.getString("CurrentHolding")));
	}
public double getStockValue(Stock s) throws NumberFormatException, JSONException
{
	JSONObject jstock=jid.getJSONObject(s.getSymbol());
	int n=Integer.parseInt(jstock.getString("CurrentHolding"));
	return (n*s.getClosePrice());
}
public double getStockInvestment(Stock s) throws JSONException
{
	JSONObject jstock=jid.getJSONObject(s.getSymbol());
	JSONObject jpurch=jstock.getJSONObject("Purchases");
	Iterator it =jpurch.keys();
	String date="";
	double invest=0.0;
	while(it.hasNext())
	{
	date=it.next().toString();
	invest+=(s.getClosePrice(date)*Double.parseDouble(jpurch.getString(date)));
	}
	return invest;
}
public double getStockSales(Stock s) throws JSONException
{
	JSONObject jstock=jid.getJSONObject(s.getSymbol());
	JSONObject jsale=jstock.getJSONObject("Sales");
	Iterator it =jsale.keys();
	String date="";
	double sale=0.0;
	while(it.hasNext())
	{
	date=it.next().toString();
	sale+=(s.getClosePrice(date)*Double.parseDouble(jsale.getString(date)));
	}
	return sale;
}
public double getStockProfit(Stock s) throws NumberFormatException, JSONException
{
	double profit=this.getStockSales(s)+this.getStockValue(s)-this.getStockInvestment(s);
	return profit;
}
public int getOverallHolding() throws JSONException
{
	Iterator it=jid.keys();
	int tot_hold=0;
while(it.hasNext())
{
	String symbol=it.next().toString();
	Stock st=new Stock(symbol);
	tot_hold+=this.getStockHolding(st);
}
return tot_hold;
}
public Portfolio(String userId) throws Exception
{
	this.userId=userId;
	FileReader reader = new FileReader("StockData.json");
	String s="";
    Scanner scan = new Scanner(reader);
    while(scan.hasNext()){
        s = s + scan.nextLine();
    }
    reader.close();
	
	 jo=new JSONObject(s);
	 jid=jo.getJSONObject(userId);
}
public double getOverallValue() throws JSONException
{
	Iterator it=jid.keys();
	double tot_val=0.0;
while(it.hasNext())
{
	String symbol=it.next().toString();
	Stock st=new Stock(symbol);
	tot_val+=this.getStockValue(st);
}
return tot_val;

}
public double getOverallInvestment() throws JSONException
{
	Iterator it=jid.keys();
	double tot_invest=0.0;
while(it.hasNext())
{
	String symbol=it.next().toString();
	Stock st=new Stock(symbol);
	tot_invest+=this.getStockInvestment(st);
}
return tot_invest;

}
public double getOverallSales() throws JSONException
{
	Iterator it=jid.keys();
	double tot_sale=0.0;
while(it.hasNext())
{
	String symbol=it.next().toString();
	Stock st=new Stock(symbol);
	tot_sale+=this.getStockSales(st);
}
return tot_sale;

}
public double getOverallProfit() throws NumberFormatException, JSONException
{
	double tot_profit=this.getOverallSales()+this.getOverallValue()-this.getOverallInvestment();
	return tot_profit;
}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Portfolio p =new Portfolio("id2");
		Stock aapl = new Stock("MSFT");
		System.out.println(p.getStockHolding(aapl));
		
		System.out.println(p.getStockInvestment(aapl));
		
		System.out.println(p.getStockProfit(aapl));
		System.out.println(p.getStockSales(aapl));
		System.out.println(p.getStockValue(aapl));
		
		
		Portfolio q=new Portfolio("id1");
		System.out.println(q.getOverallHolding());
		System.out.println(q.getOverallInvestment());
		System.out.println(q.getOverallValue());
		
	

	}

}
