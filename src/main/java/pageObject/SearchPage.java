package pageObject;

import org.openqa.selenium.WebDriver;
import shared.Header;

public class SearchPage extends Header {

    WebDriver driver;

    public SearchPage(WebDriver driver){
        super(driver);
        this.driver = driver;
    }

}