import org.json.JSONException;
import org.json.JSONObject;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class StockAccount2 extends Account{
    JSONObject UserStockAccountData;
    JSONObject UserData;
    JSONObject data,data2;
    public StockAccount2(String userId) throws IOException, JSONException {
        super(userId);
        String s="";
        FileReader reader = new FileReader("UserAccountData.json");
        Scanner scan = new Scanner(reader);
        while(scan.hasNext()){
            s = s + scan.nextLine();
        }
        reader.close();
//        String s = "{\n" +
//                "  \"ID1\": {\n" +
//                "    \"MSFT\": {\n" +
//                "      \"12/02/2021\": {\n" +
//                "        \"Price\": \"69.43\",\n" +
//                "        \"Quantity\": \"200\"\n" +
//                "      },\n" +
//                "      \"totalQuantity\": \"1009\",\n" +
//                "      \"worthmoney\": \"2000000\"\n" +
//                "    }\n" +
//                "  }\n" +
//                "}";

//        System.out.println(s);

        data = new JSONObject(s);
        UserStockAccountData = data.getJSONObject(userId);
        System.out.println(UserStockAccountData);

//        String s2 = "{\"ID1\":{\"password\":\"secretpassword\",\"balance\":\"3000\",\"userName\":\"loki\"}}";
//        UserAccountData = new JSONObject(s2);
//        FileWriter file2 = new FileWriter("USERDATA.json");
//        file2.write(UserAccountData.toString());
//        file2.close();

        String s3 = "";
        FileReader readerx = new FileReader("USERDATA.json");
        Scanner scanx = new Scanner(readerx);
        while(scanx.hasNext()){
            s3  = s3 + scanx.nextLine();
        }
        readerx.close();
        data2 = new JSONObject(s3);
        UserData = data2.getJSONObject(userId);
        System.out.println(UserData.toString());


//        String s2="";
//        FileReader reader2 = new FileReader("USERDATA.json");
//        Scanner scan2 = new Scanner(reader);
//        while(scan2.hasNext()){
//            s2 = s2 + scan2.nextLine();
//        }
//        reader2.close();
//        UserAccountData = new JSONObject(s2).getJSONObject(userId);

//        System.out.println(UserAccountData.);

    }

    public String getUsername() throws JSONException {
        return UserData.getString("userName");
    }
    public double getBalance() throws JSONException {
        return Double.valueOf(UserData.getString("balance"));
    }
    public void updateData() throws IOException, JSONException {
        data.put(this.getUserId(),UserStockAccountData);
        data2.put(this.getUserId(),UserData);
        FileWriter file = new FileWriter("USERDATA.json");
        file.write(data2.toString());
        file.close();

        FileWriter file2 = new FileWriter("UserAccountData.json");
        file2.write(data.toString());
        file2.close();
    }

    public LinkedList <String> StocksList(){
        LinkedList<String> listOfStocks = new LinkedList<String>();
        Iterator it = UserStockAccountData.keys();
        while(it.hasNext()){
            listOfStocks.add(it.next().toString());
        }
        return listOfStocks;
    }

    public void addMoney(double amount) throws JSONException, IOException {
        double currentBalance = Double.valueOf(UserData.get("balance").toString()) ;
        UserData.put("balance",currentBalance + amount);
        this.updateData();
    }

    public void deductMoney(double amount) throws IOException, JSONException {
        double currentBalance = Double.valueOf(UserData.get("balance").toString());
        UserData.put("balance",currentBalance - amount);
        this.updateData();
    }



    public void buyStock(String symbol, int noOfShares) throws JSONException, IOException {
        Stock stock = new Stock(symbol);
        LinkedList<String> listOfStocks = new LinkedList<String>();
        boolean exists = false;
        for(int i=0;i<listOfStocks.size();i++){
            if(listOfStocks.get(i).equals(symbol))
                exists = true;
        }
        if(exists){
            UserStockAccountData.getJSONObject(symbol).put("totalQuantity",(int)UserStockAccountData.getJSONObject(symbol).get("totalQuantity") + noOfShares);
            UserStockAccountData.getJSONObject(symbol).put("worthmoney",(double)UserStockAccountData.getJSONObject(symbol).get("worthmoney") + noOfShares* stock.getClosePrice());

            JSONObject dateBought = new JSONObject();
            dateBought.put("Price",stock.getClosePrice());
            dateBought.put("Quantity",noOfShares);

            UserStockAccountData.getJSONObject(symbol).put(String.valueOf(LocalDateTime.now()).substring(0,10),dateBought);
        }
        else{
            JSONObject stockJsonObject = new JSONObject();
            stockJsonObject.put("totalQuantity",noOfShares);
            stockJsonObject.put("worthmoney",noOfShares*stock.getClosePrice());

            JSONObject dateBought = new JSONObject();
            dateBought.put("Price",stock.getClosePrice());
            dateBought.put("Quantity",noOfShares);

            stockJsonObject.accumulate(String.valueOf(LocalDateTime.now()).substring(0,10),dateBought);

            UserStockAccountData.put(symbol,stockJsonObject);
        }
        this.deductMoney(noOfShares* stock.getClosePrice());
        this.updateData();
    }

    public void sellStock(String symbol,int noOfShares) throws JSONException, IOException {
        Stock stock = new Stock(symbol);
        int q = (int)UserStockAccountData.getJSONObject(symbol).get("totalQuantity");
        double pr = (double)UserStockAccountData.getJSONObject(symbol).get("worthmoney");

        UserStockAccountData.getJSONObject(symbol).put("worthmoney",(q-noOfShares)*stock.getClosePrice());
        UserStockAccountData.getJSONObject(symbol).put("totalQuantity",q-noOfShares);
        this.addMoney(noOfShares*stock.getClosePrice());
        this.updateData();
    }
    public static void main(String[] args){

    }
}
