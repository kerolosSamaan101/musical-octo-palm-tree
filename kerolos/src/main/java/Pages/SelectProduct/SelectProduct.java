package Pages.SelectProduct;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static Utilities.Selenium.DriverFactory.driver;

public class SelectProduct {
    public static void Selection(String productName) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Navigate to Categorize -> Hand Tools
        driver.findElement(By.linkText("Categories")).click();
        driver.findElement(By.linkText("Hand Tools")).click();

        WebElement product = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//a[@data-test and contains(., '" + productName + "')]")
                )
        );
        product.click();

        // Wait for Add to Cart button
        WebElement addToCartBtn = wait.until(
                ExpectedConditions.elementToBeClickable(By.id("btn-add-to-cart"))
        );

        // Click Add to Cart
        addToCartBtn.click();

        Thread.sleep(2000);
    }
}
