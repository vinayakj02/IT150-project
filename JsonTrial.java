import java.io.FileWriter;
import java.io.IOException;

import org.json.JSONException;
import org.json.JSONObject;

public class JsonTrial {
	public static void main(String[] args) throws JSONException {
		String s="{}";
		JSONObject userdata = new JSONObject(s);
		  
	      JSONObject ID1 = new JSONObject();
	      //Inserting key-value pairs into the json object
	      ID1.put("userName", "David");
	      ID1.put("password", "secret1");
		  ID1.put("balance", "2000");
	      JSONObject ID2 = new JSONObject();
		  ID2.put("userName", "loki");
		  ID2.put("password", "secretpassword");
		  ID2.put("balance", "3000");
	      userdata.accumulate("ID1", ID1);
	      userdata.accumulate("ID2", ID2);

	      try {
	         FileWriter file = new FileWriter("USERDATA.json");
	         file.write(userdata.toString());
	         file.close();
	      } catch (IOException e) {
	         e.printStackTrace();
	      }
	      System.out.println("JSON file created: "+userdata.toString(2));
	}

}
