import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;

public class LogIn {
    JSONObject userInfo;
    LogIn() throws JSONException, FileNotFoundException {
        String s = "";
        FileReader reader = new FileReader("USERDATA.json");
        Scanner scan = new Scanner(reader);
        while(scan.hasNext()){
            s = s + scan.nextLine();
        }
        userInfo = new JSONObject(s);
    }
    public boolean AccountExists(Account acc) throws FileNotFoundException {
        Iterator it = userInfo.keys();
        while(it.hasNext()){
            String userID = it.next().toString();
            if(acc.getUserId().equals(userID)){
                return true;
            }
        }
        return false;
    }
    public boolean SignIN(Account acc) throws JSONException {
        Iterator it = userInfo.keys();
        while(it.hasNext()){
            String userID = it.next().toString();
            if(acc.getUserId().equals(userID) && acc.getUserName().equals(userInfo.getJSONObject(userID).get("userName")) && acc.getPassword().equals(userInfo.getJSONObject(userID).get("password"))){
                return  true;
            }
        }
        return false;
//        String.valueOf(0)
    }
    
    public void SignUp(Account acc) throws JSONException {
    	JSONObject ID1 = new JSONObject();
	      //Inserting key-value pairs into the json object
	      ID1.put("userName", acc.getUserName());
	      ID1.put("password", acc.getPassword());
		  ID1.put("balance", String.valueOf(acc.getBalance()));
		  userInfo.accumulate("abc12", ID1);
		  try {
		         FileWriter file = new FileWriter("USERDATA.json");
//		         file.write(jsonObject.toJSONString());
		         file.write(userInfo.toString());
		         file.close();
		      } catch (IOException e) {
		         // TODO Auto-generated catch block
		         e.printStackTrace();
		      }
		      System.out.println("JSON file created: "+userInfo.toString(2));
	}

    public static void main(String[] args) throws FileNotFoundException, JSONException {
        Account bukcy = new Account("ID3","random","secretpassword",2001);
        LogIn l1 = new LogIn();
//        System.out.println(l1.AccountExists(bukcy));
//        System.out.println(l1.SignIN(bukcy));
        l1.SignUp(bukcy);
    }
}
