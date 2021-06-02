import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObject.HomePage;

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

    @Test
    public void testLogIn() {
        // Arrange
        String email = "andy@domain.com";
        String pwd = "testo";

        // Act
        HomePage siteHP = new HomePage(driver);
        siteHP
                .openAuthentication()
                .enterEmail(email)
                .enterPassword(pwd)
                .openMyAccountPage();

        By listAccountButtonSelector = By.cssSelector("#center_column li");
        var listAccountButton = driver.findElements(listAccountButtonSelector);

        // Assert
        listAccountButton.forEach(button -> Assert.assertTrue(button.isDisplayed()));
    }

    @Test
    public void testLogInFalsePwd() {
        // Arrange
        String email = "andy@domain.com";
        String falsePwd = "123456";
        String expectedMsg = "Authentication failed.";
        // Act
        HomePage siteHP = new HomePage(driver);
        siteHP
                .openAuthentication()
                .enterEmail(email)
                .enterPassword(falsePwd)
                .openMyAccountPage();

        By errorMsgSelector = By.cssSelector(".alert li");

        // Assert
        Assert.assertTrue(driver.findElement(errorMsgSelector)
                .getText().equals(expectedMsg));
    }
}
