package httpclient;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class HttpClient {
  String uri=null;

  public HttpClient(String uri) {
    this.uri = uri;
  }
  
  
  public String makeHttpRequest(String params) throws MalformedURLException, IOException {
    URL url = new URL(uri+params);
    HttpURLConnection con = (HttpURLConnection) url.openConnection();
    con.setRequestMethod("GET");
    con.setRequestProperty("Accept", "text/plain;charset=UTF-8");
    //con.setRequestProperty("User-Agent", "server");
    String result;
    try (Scanner scan = new Scanner(con.getInputStream())) {
      result = null;
      if (scan.hasNext()) {
        result = scan.nextLine();
      }
    }
    return result;
  }
  
  public static void main(String[] args) throws IOException {
    HttpClient client = new HttpClient("https://accaroli.com/TDD-Day3-Webcalculator-1.0/calculator");
    String res = client.makeHttpRequest("?operation=add&n1=2&n2=3");
    System.out.println(res);
  }
}
