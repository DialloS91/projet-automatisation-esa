package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageComponent.Header;

public class AuthenticationPage {
    WebDriver driver;
    Header header;

    By headerSelector = By.tagName("header");
    By emailBoxSelector = By.id("email");
    By pwdBoxSelector = By.id("passwd");
    By signinButton = By.id("SubmitLogin");

    public AuthenticationPage(WebDriver driver) {
        this.driver = driver;

        WebElement headerContainer = driver.findElement(headerSelector);
        header = new Header(headerContainer);
    }

    public AuthenticationPage enterEmail(String email) {
        driver.findElement(emailBoxSelector).sendKeys(email);
        return this;
    }

    public AuthenticationPage enterPassword(String pwd) {
        driver.findElement(pwdBoxSelector).sendKeys(pwd);
        return this;
    }

    public MyAccountPage openMyAccountPage() {
        driver.findElement(signinButton).click();
        return new MyAccountPage(driver);
    }

}
