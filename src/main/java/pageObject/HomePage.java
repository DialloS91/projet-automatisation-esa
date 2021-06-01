package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageComponent.Header;

public class HomePage {
    WebDriver driver;
    Header header;

    By headerSelector = By.tagName("header");

    public HomePage(WebDriver driver) {
        this.driver = driver;

        WebElement headerContainer = driver.findElement(headerSelector);
        header = new Header(headerContainer);
    }

    public AuthenticationPage openAuthentication() {
        header.openAuthentication();
        return new AuthenticationPage(driver);
    }
}
