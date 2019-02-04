package integrationtests;



import calculator.Calculator;
import httpclient.HttpClient;
import java.io.IOException;
import org.junit.Test;
import static org.junit.Assert.*;


public class WebCalculatorTest {
  
  HttpClient client = new HttpClient("http://localhost:7777/WebCalculator/calculator");
  
  
  public WebCalculatorTest() {
  }
  
  @Test
  public void testWebAdd() throws IOException{
    String res = client.makeHttpRequest("?operation=add&n1=2&n2=3");
    assertEquals("Result of: 2+3= 5", res);
    assert(false);
  }
  
  @Test
  public void testWebSub() throws IOException{
    String res = client.makeHttpRequest("?operation=sub&n1=6&n2=3");
    assertEquals("Result of: 6-3= 3", res);
    assert(false);
  }
  
  @Test
  public void testWebMul() throws IOException{
    String res = client.makeHttpRequest("?operation=mul&n1=6&n2=6");
    assertEquals("Result of: 6*6= 36", res);
    assert(false);
  }
  
  
}