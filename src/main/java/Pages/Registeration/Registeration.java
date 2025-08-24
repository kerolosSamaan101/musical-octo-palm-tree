package Pages.Registeration;

import Utilities.Selenium.DriverFactory;
import Utilities.TestData.Data;
import Utilities.TestData.TestData;
import org.openqa.selenium.By;

import static Utilities.Selenium.DriverFactory.driver;

public class Registeration {

    public static void RegisterWithValidUser() throws InterruptedException {
        driver = DriverFactory.getDriver();
        driver.get("https://practicesoftwaretesting.com/auth/register");
        driver.findElement(By.id("first_name")).sendKeys("Mohamed");
        driver.findElement(By.id("last_name")).sendKeys("Ehab");
        driver.findElement(By.id("dob")).sendKeys("2006-11-11");
        driver.findElement(By.id("street")).sendKeys("NasrRoad");
        driver.findElement(By.id("postal_code")).sendKeys("332255");
        driver.findElement(By.id("city")).sendKeys("Cairo");
        driver.findElement(By.id("state")).sendKeys("Giza");
        driver.findElement(By.id("country")).sendKeys("Egypt");
        driver.findElement(By.id("phone")).sendKeys("1019658871");
        String email = TestData.fakeAccount;
        Data.email_new = email;
        driver.findElement(By.id("email")).sendKeys(email);
        String password = TestData.fakePassword;
        Data.password_new = password;
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.xpath("/html/body/app-root/div/app-register/div/div/div/form/div/button")).click();
        Thread.sleep(3000);
    }
}
