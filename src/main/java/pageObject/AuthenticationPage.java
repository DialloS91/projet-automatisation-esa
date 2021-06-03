package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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
        System.out.println("LogIn with : " + email + " password: " + pwd);
        driver.findElement(emailBoxSelector).sendKeys(email);
        driver.findElement(pwdBoxSelector).sendKeys(pwd);
        driver.findElement(signinButton).click();
        return new MyAccountPage(driver);
    }

    public CreateAccountPage createAccount(String newEmail) {
        System.out.println("Create my account with : " + newEmail);
        driver.findElement(enterNewEmail).sendKeys(newEmail);
        driver.findElement(CreateAccountButtonSelector).click();
        return new CreateAccountPage(driver);
    }
}
