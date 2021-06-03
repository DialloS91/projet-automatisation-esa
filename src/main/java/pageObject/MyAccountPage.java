package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyAccountPage {
    WebDriver driver;

    By addressButtonSelector = By.cssSelector("[title=\"Addresses\"]");

    public MyAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    public MyAddressPage openAddressPage() {
        driver.findElement(addressButtonSelector).click();
        return new MyAddressPage(driver);
    }
}


