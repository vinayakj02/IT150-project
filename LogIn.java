import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;

import org.json.JSONException;
import org.json.JSONObject;

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
    public boolean accountExists(String enteredId) throws FileNotFoundException {
        Iterator it = userInfo.keys();
        while(it.hasNext()){
            String userID = it.next().toString();
            if(enteredId.equals(userID)){
                return true;
            }
        }
        return false;
    }
    public boolean SignIN(Account acc) throws JSONException {
        Iterator it = userInfo.keys();
        while(it.hasNext()){
            String userID = it.next().toString();
            if(acc.getUserId().equals(userID) && acc.getPassword().equals(userInfo.getJSONObject(userID).get("password"))){
                return  true;
            }
        }
        return false;
    }	
    
    public void SignUp(Account acc) throws JSONException {
    	JSONObject ID1 = new JSONObject();
	      //Inserting key-value pairs into the json object
	      ID1.put("userName", acc.getUserName());
	      ID1.put("password", acc.getPassword());
		  ID1.put("balance", String.valueOf(acc.getBalance()));
		  userInfo.accumulate(acc.getUserId(), ID1);
		  try {
		         FileWriter file = new FileWriter("USERDATA.json");
//		         file.write(jsonObject.toJSONString());
		         file.write(userInfo.toString());
		         file.close();
		      } catch (IOException e) {
		         // TODO Auto-generated catch block
		         e.printStackTrace();
		      }
//		      System.out.println("JSON file created: "+userInfo.toString(2));
	}

    public static void main(String[] args) {
    	// TODO Auto-generated method stub
//    	Account bucky=new Account("random", "secretPass", 2001);
    	
    	
    }
}
