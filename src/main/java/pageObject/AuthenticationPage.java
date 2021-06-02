package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AuthenticationPage {
    WebDriver driver;

    By emailBoxSelector = By.id("email");
    By pwdBoxSelector = By.id("passwd");
    By signinButton = By.id("SubmitLogin");
    By CreateAccountButtonSelector = By.id("SubmitCreate");
    By enterNewEmail = By.id("email_create");

    public AuthenticationPage(WebDriver driver) {
        this.driver = driver;
    }

    public MyAccountPage logIn(String email, String pwd) {
        driver.findElement(emailBoxSelector).sendKeys(email);
        driver.findElement(pwdBoxSelector).sendKeys(pwd);
        driver.findElement(signinButton).click();
        return new MyAccountPage(driver);
    }

    public CreateAccountPage createAccount(String newEmail) {
        System.out.println("Open Create my account Page");
        driver.findElement(enterNewEmail).sendKeys(newEmail);
        driver.findElement(CreateAccountButtonSelector).click();
        return new CreateAccountPage(driver);
    }
}
