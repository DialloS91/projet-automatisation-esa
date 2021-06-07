package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import shared.Header;

public class SearchPage extends Header {
    WebDriver driver;

    By productsSelector = By.cssSelector("[itemprop='name']");


    public SearchPage(WebDriver driver){
        super(driver);
        this.driver = driver;
    }

    public String getProductTitle(int index) {
        return driver.findElements(productsSelector).get(1).getText();
    }


}