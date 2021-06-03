package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import shared.Safe;

public class AuthenticationPage extends Safe {
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
        safeSendKeys(driver, emailBoxSelector, email);
        safeSendKeys(driver, pwdBoxSelector, pwd);
        safeClick(driver, signinButton);
        return new MyAccountPage(driver);
    }

    public CreateAccountPage createAccount(String newEmail) {
        System.out.println("Create my account with : " + newEmail);
        safeSendKeys(driver, enterNewEmail, newEmail);
        safeClick(driver, CreateAccountButtonSelector);
        return new CreateAccountPage(driver);
    }
}
