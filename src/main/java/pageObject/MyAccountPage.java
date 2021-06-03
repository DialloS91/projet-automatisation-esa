package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import shared.Header;

public class MyAccountPage extends Header {
    WebDriver driver;

    By addressButtonSelector = By.cssSelector("[title=\"Addresses\"]");

    public MyAccountPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public MyAddressPage openAddressPage() {
        System.out.println("Open Address page");
        driver.findElement(addressButtonSelector).click();
        return new MyAddressPage(driver);
    }
}


