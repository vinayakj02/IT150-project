import java.io.FileWriter;
import java.io.IOException;

import org.json.JSONException;
import org.json.JSONObject;

public class JsonTrial {

	public static void main(String[] args) throws JSONException {
		// TODO Auto-generated method stub
		String s="{}";
		JSONObject userdata = new JSONObject(s);
		  
	      JSONObject jsonObject = new JSONObject();
	      //Inserting key-value pairs into the json object
	      jsonObject.put("userId", "1");
	      jsonObject.put("userName", "Abc");
	      jsonObject.put("password", "secret1");
	      jsonObject.put("balance", "2000");
	      JSONObject jsonObject2 = new JSONObject();
	      jsonObject2.put("userId", "2");
	      jsonObject2.put("userName", "Bcd");
	      jsonObject2.put("password", "secret2");
	      jsonObject2.put("balance", "3000");
//	      userdata.ac
//	      array.add(jsonObject);
//	      array.add(jsonObject2);
	      userdata.accumulate("abc", jsonObject2);
	      userdata.accumulate("bcd", jsonObject);
//	      Account acc=new Account("3", "Cde", "sec3", 0);
//	      array.add(acc);
	      try {
	         FileWriter file = new FileWriter("Simulate2.json");
//	         file.write(jsonObject.toJSONString());
	         file.write(userdata.toString());
	         file.close();
	      } catch (IOException e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	      }
	      System.out.println("JSON file created: "+jsonObject);
	      System.out.println(userdata.getJSONObject("abc").get("password"));
	}

}
