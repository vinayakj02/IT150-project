import java.io.BufferedReader;
import java.io.IOException;
import java.net.URL;
import java.io.InputStreamReader;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;

public class jsonString {

    private static HttpURLConnection connection;

    public  String giveString(String lnk) {
        BufferedReader reader;
        String line;
        StringBuffer responceContent = new StringBuffer();
        try {
            URL url = new URL(lnk);
            connection = (HttpURLConnection) url.openConnection();
            int status = connection.getResponseCode();
            // System.out.println(status);
            if (status > 299) {
                reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
                while ((line = reader.readLine()) != null) {
                    responceContent.append(line);
                }
                reader.close();
            } else {
                reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                while ((line = reader.readLine()) != null) {
                    responceContent.append(line);
                }
                reader.close();
            }
            // System.out.println(responceContent.toString());
            String rawJsonData = responceContent.toString();
            return rawJsonData;
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return "Error";
        } catch (IOException e) {
            e.printStackTrace();
            return "Error";
        }
    }

    public static void main(String[] agrs){
        // lnk is the link to the json file from the web
        String lnk = "https://www.alphavantage.co/query?function=TIME_SERIES_DAILY_ADJUSTED&symbol=TSLA&apikey=https://www.alphavantage.co/";
        jsonString yo = new jsonString();
        String jsonData = yo.giveString(lnk);
        System.out.println(jsonData.substring(0,100));
    }
}
