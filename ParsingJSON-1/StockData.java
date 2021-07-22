import org.json.JSONException;
import org.json.JSONObject;

public class StockData {
    JSONObject js;
    StockData(String Symbol) throws JSONException {
        String link = "https://www.alphavantage.co/query?function=TIME_SERIES_DAILY&symbol="+Symbol+"&apikey=NRL37I6KXAOR68AS";
        ParsingJSON ps = new ParsingJSON(link);
        String thisStockData = ps.giveString();
        try {
            js = new JSONObject(thisStockData);
        } catch (JSONException e) {
            js = new JSONObject("GetInfo");
        }
    }

    public String getOpenPrice() throws JSONException {
        return js.getJSONObject("Time Series (Daily)").getJSONObject("2021-07-19").getString("1. open");
    }
    public String getClosePrice() throws  JSONException{
        return js.getJSONObject("Time Series (Daily)").getJSONObject("2021-07-19").getString("4. close");
    }
    public String getInfo() throws JSONException {
        return js.getJSONObject("Meta Data").getString("1. Information");
    }
}
