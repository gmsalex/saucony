package gmsalex;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class App {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://www.catfootwear.com/US/en/home");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        var titlebarElements = driver.findElements(By.cssSelector("button.ui-dialog-titlebar-close"));
        if (titlebarElements.size() > 0) {
            titlebarElements.get(0).click();
        }
        // set break point here and add some snickers to cart
        driver.findElement(By.cssSelector("a.mini-cart-link")).click();
        var emptyCart = driver.findElements(By.cssSelector("div#empty-cart-icon"));
        if (emptyCart.size() == 0) {
            var removeLinks = driver.findElements(By.cssSelector("a.mini-cart-product-remove"));
            while (removeLinks.size() > 0) {
                removeLinks.get(0).click();
                removeLinks = driver.findElements(By.cssSelector("a.mini-cart-product-remove"));
            }
        }
    }
}
