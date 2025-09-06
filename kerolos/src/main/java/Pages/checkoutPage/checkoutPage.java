package Pages.checkoutPage;


import Utilities.TestData.Data;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static Utilities.Selenium.DriverFactory.driver;

public class checkoutPage {
    public static void check() throws InterruptedException {
        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Thread.sleep(7000);
        driver.findElement(By.xpath("/html/body/app-root/app-header/nav/div/div/ul/li[5]/a")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/app-root/div/app-checkout/aw-wizard/div/aw-wizard-step[1]/app-cart/div/div")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/app-root/div/app-checkout/aw-wizard/div/aw-wizard-step[2]/app-login/div/div/div/div")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/app-root/div/app-checkout/aw-wizard/div/aw-wizard-step[3]/app-address/div/div/div/div")).click();
        Thread.sleep(2000);
        // select payment way
        WebElement paymentDropdown = driver.findElement(By.id("payment-method"));

// Create a Select object
        Select selectPayment = new Select(paymentDropdown);

// Select by visible text
        selectPayment.selectByVisibleText("Cash on Delivery");

        driver.findElement(By.xpath("/html/body/app-root/div/app-checkout/aw-wizard/div/aw-wizard-completion-step/app-payment/div/div/div/div")).click();

        Thread.sleep(2000);
    }
}
