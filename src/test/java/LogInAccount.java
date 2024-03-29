import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObject.HomePage;
import shared.Retry;

import java.util.concurrent.ThreadLocalRandom;

public class LogInAccount {
    WebDriver driver;
    String url = "http://automationpractice.com";

    @BeforeMethod
    public void openChrome() {
        driver = new ChromeDriver();
        driver.get(url);
    }

    @AfterMethod
    public void closeChrome() {
        driver.quit();
    }


    @Test
    public void testOpenAuthenticationPage() {
        HomePage siteHP = new HomePage(driver);
        siteHP.openAuthentication();
    }
//TODO Refactor the tests (drivers and selector should not be here)
    @Test
    public void testLogIn() {
        // Arrange
        String email = "andy@domain.com";
        String pwd = "testo";

        // Act
        HomePage siteHP = new HomePage(driver);
        siteHP.openAuthentication().logIn(email, pwd);

        By listAccountButtonSelector = By.cssSelector("#center_column li");
        var listAccountButton = driver.findElements(listAccountButtonSelector);

        // Assert
        listAccountButton.forEach(button -> Assert.assertTrue(button.isDisplayed()));
    }

    @Test(retryAnalyzer = Retry.class)
    public void testLogInFalsePwd() {
        // Arrange
        String email = "andy@domain.com";
        String falsePwd = "123456";
        String expectedMsg = "Authentication failed.";

        // Act
        HomePage siteHP = new HomePage(driver);
        String errorMsg = siteHP
                .openAuthentication()
                .logIn(email, falsePwd)
                .getErrorMsg();

        // Assert
        Assert.assertEquals(errorMsg, expectedMsg);
    }

    @Test
    public void testCreateAccount() {

        // Arrange
        int randomNum = ThreadLocalRandom.current().nextInt(1, 5000 + 1);
        String newEmail = randomNum + "Elhadj@dggmaill.com";
        String firstName = "Elhadj";
        String lastName = "Tiam";
        String password = "password";
        String dayBirth = "1";
        String monthBirth = "1";
        String year = "2021";
        String mobilePhone = "777777777";
        String homePhone = "6666666666";
        String otherInfo = "autres infos";
        String country = "Country";
        String postCode = "91300";
        String city = "France";
        String state = "State";
        String adress2 = "Adresse2";
        String adress = "Adresse";
        String company = "company";
        String AdressFirstName = "elhadj";
        String AdressLastName = "tiam";


        HomePage siteHP = new HomePage(driver);

        String ExpectedResult = "Elhadj Tiam";


        // Act


        siteHP.openAuthentication().
                createAccount(newEmail).EnterPersonalInformation(mobilePhone, homePhone, otherInfo, country, postCode, city, state, adress2, adress, company, AdressFirstName, AdressLastName, firstName, lastName, password, dayBirth, monthBirth, year)
                .Submit();


        // Assert
        By name = By.cssSelector("[title='View my customer account']");
        Assert.assertTrue(driver.findElement(name).getText().equals(ExpectedResult), "Le nom affiche [" + name + "] n'est pas celui de l'utilisateur' [" + ExpectedResult + "].");

    }
}
