package IT17061612;
import java.io.InputStreamReader;
import java.net.URL;
import java.io.BufferedReader;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SeedGenerator
{
	
	public double currencyConvert(String baseCurrency,String termCurrency)
	{
                    String temp = "http://free.currencyconverterapi.com/api/v5/convert?q="+baseCurrency+"_"+termCurrency+"&compact=y";

                    URLConnection urlConn = null;
                    InputStreamReader in = null;
                    StringBuilder sb = new StringBuilder();
           
                    
                    URL url;
            try {
                url = new URL(temp);
            
                    urlConn = url.openConnection();
                    in = new InputStreamReader(urlConn.getInputStream(),Charset.defaultCharset());
                    BufferedReader bufferedReader = new BufferedReader(in);
                    
                            int cp;
                            while ((cp = bufferedReader.read()) != -1) {
                                    sb.append((char) cp);
                            }
                        
                     String temp2 = "";
                     sb.replace(0, 18, temp2);
                   temp = sb.toString();
                   temp = temp.replaceAll("}", "");
                             // Reader reader = new InputStreamReader(url.openStream(), charset);
	   // Result result = new Gson().fromJson(reader, Result.class);

	    // Get the value without the term currency.
	  //  String amount = result.getRhs();
            } catch (Exception ex) {
                Logger.getLogger(SeedGenerator.class.getName()).log(Level.SEVERE, null, ex);
            }
	
            return Double.parseDouble(temp);
            
        }
}
