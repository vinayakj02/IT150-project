import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
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
    }

    public static void main(String[] args) throws FileNotFoundException, JSONException {
        Account bukcy = new Account("ID2","loki","secretpassword",2001);
        LogIn l1 = new LogIn();
//        System.out.println(l1.AccountExists(bukcy));
        System.out.println(l1.SignIN(bukcy));
    }
}
