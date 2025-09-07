package Pages.checkoutPage;


import Utilities.TestData.Data;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static Utilities.Selenium.DriverFactory.driver;

public class checkoutPage {
    public static void check( String payWay , String[] data) throws InterruptedException {


        Thread.sleep(5000);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));


        //  Cart Page
        driver.findElement(By.xpath("/html/body/app-root/app-header/nav/div/div/ul/li[5]/a")).click();
        Thread.sleep(2000);
        // Sign up
        driver.findElement(By.xpath("/html/body/app-root/div/app-checkout/aw-wizard/div/aw-wizard-step[1]/app-cart/div/div")).click();
        Thread.sleep(5000);

        // Billing Address


        driver.findElement(By.xpath("/html/body/app-root/div/app-checkout/aw-wizard/div/aw-wizard-step[2]/app-login/div/div/div/div")).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/app-root/div/app-checkout/aw-wizard/div/aw-wizard-step[3]/app-address/div/div/div/div")).click();
        Thread.sleep(2000);
        // select payment way
        WebElement paymentDropdown = driver.findElement(By.id("payment-method"));
        Select selectPayment = new Select(paymentDropdown);
        selectPayment.selectByVisibleText(payWay);

        WebElement paymentForm = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("/html/body/app-root/div/app-checkout/aw-wizard/div/aw-wizard-completion-step/app-payment/div/div/div/form")   // غيّر الـ selector حسب ال DOM
        ));

        if (!selectPayment.equals("Cash on Delivery")) {

            java.util.List<WebElement> inputs = paymentForm.findElements(By.tagName("input"));


            int i = 0;
            for (WebElement input : inputs) {
                String value = data[i];
                input.sendKeys(value);
                i++;
            }
        }



        driver.findElement(By.xpath("/html/body/app-root/div/app-checkout/aw-wizard/div/aw-wizard-completion-step/app-payment/div/div/div/div")).click();



        WebElement successMessage = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.cssSelector("[data-test='payment-success-message']")
                )
        );

        String messageText = successMessage.getText();
        System.out.println("Success message: " + messageText);

        if (messageText.contains("Payment was successful")) {
            System.out.println("Order confirmation is displayed. ");
        } else {
            System.out.println("Order confirmation is not displayed. ");
        }



        Thread.sleep(2000);
    }
}
