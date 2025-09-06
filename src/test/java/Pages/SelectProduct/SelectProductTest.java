package Pages.SelectProduct;

import Pages.Registeration.Registeration;
import Utilities.Selenium.DriverFactory;
import org.testng.Assert;
import org.testng.annotations.*;
import static Utilities.Selenium.DriverFactory.driver;



public class SelectProductTest {

    final SelectProduct sel = new SelectProduct();

    @org.testng.annotations.Test(priority = 1)
    public void RegisterWithUser() throws InterruptedException {
        sel.Selection("Combination Pliers");
    }
}

