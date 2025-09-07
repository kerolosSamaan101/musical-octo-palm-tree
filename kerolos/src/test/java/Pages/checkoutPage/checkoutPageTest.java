package Pages.checkoutPage;


import java.util.HashMap;
import java.util.Map;

public class checkoutPageTest {
    final checkoutPage chk = new checkoutPage();

    @org.testng.annotations.Test(priority = 1)
    public void RegisterWithUser() throws InterruptedException {
        String payWay = "Bank Transfer";
        String[] data =  new String[]{"Cairo Bank","kero" ,"123456"};
        chk.check(payWay,data);
    }
}
