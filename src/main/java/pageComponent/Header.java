package pageComponent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Header {
    WebElement container;

    By signinButtonSelector = By.cssSelector(".header_user_info");

    public Header(WebElement container) {
        this.container = container;
    }

    public void openAuthentication() {
        System.out.println("Open Authentication page");
        container.findElement(signinButtonSelector).click();
    }

}
