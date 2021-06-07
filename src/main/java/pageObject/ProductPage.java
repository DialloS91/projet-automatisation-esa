package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage {
    WebDriver driver;

    By titleProductSelector = By.cssSelector("[itemprop=\"name\"]");

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getProductTitle() {
        String title = driver.findElement(titleProductSelector).getText();
        System.out.println("Getting product title = " + title);
        return title;
    }
}
