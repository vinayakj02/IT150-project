import org.json.JSONException;

public class Main {

    public static void main(String[] args) throws JSONException {
	// write your code here
    StockData TSLA = new StockData("FB");
        System.out.println(TSLA.getOpenPrice());
    }
}
