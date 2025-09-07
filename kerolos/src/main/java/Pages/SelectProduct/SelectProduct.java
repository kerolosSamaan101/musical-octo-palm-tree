package Pages.SelectProduct;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static Utilities.Selenium.DriverFactory.driver;

public class SelectProduct {
    public static void Selection(String productName,int numberOfClicks) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.findElement(By.linkText("Categories")).click();
        driver.findElement(By.linkText("Hand Tools")).click();

        WebElement product = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//a[@data-test and contains(., '" + productName + "')]")
                )
        );
        product.click();



        WebElement increaseQuantityBtn = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.cssSelector("button[aria-label='Increase quantity']")
                )
        );

        for (int i = 0; i < numberOfClicks-1; i++) {
            increaseQuantityBtn.click();
            Thread.sleep(500);
        }



        WebElement addToCartBtn = wait.until(
                ExpectedConditions.elementToBeClickable(By.id("btn-add-to-cart"))
        );


        addToCartBtn.click();

        WebElement successAlert = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.cssSelector("div.toast-success")
                )
        );

        System.out.println("Success Alert: " + successAlert.getText());



        Thread.sleep(2000);
    }
}
