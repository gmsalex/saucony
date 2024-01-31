package gmsalex;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class App {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://www.saucony.com/en/home");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        var titlebarElements = driver.findElements(
            By.cssSelector("button.ui-dialog-titlebar-close"));
        if (!titlebarElements.isEmpty()) {
            titlebarElements.get(0).click();
        }
        // set break point here and add some snickers to cart
        String itemsInTheCart = driver.findElement(
            By.xpath("//span[contains(@class, \"mini-cart-quantity-bag\")]")).getText();
        if (!itemsInTheCart.equals("0")) {
            driver.findElement(By.xpath("//a[contains(@class,\"mini-cart-link\")]")).click();
            var removeLinks = driver.findElements(By.cssSelector("a.mini-cart-product-remove"));
            while (!removeLinks.isEmpty()) {
                removeLinks.get(0).click();
                removeLinks = driver.findElements(By.cssSelector("a.mini-cart-product-remove"));
            }
        }
    }
}
