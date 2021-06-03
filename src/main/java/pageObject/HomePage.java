package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    WebDriver driver;
    By signinButtonSelector = By.cssSelector(".header_user_info");


    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public AuthenticationPage openAuthentication() {
        System.out.println("Open Authentication page");
        driver.findElement(signinButtonSelector).click();
        return new AuthenticationPage(driver);
    }


}
