package pageObject;

import org.openqa.selenium.WebDriver;
import shared.Header;

public class HomePage extends Header {
    WebDriver driver;

    public HomePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
}
