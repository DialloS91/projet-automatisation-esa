import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObject.HomePage;
import shared.Retry;

import java.util.concurrent.ThreadLocalRandom;

public class AddressTest {
    WebDriver driver;
    String url = "http://automationpractice.com";

    private static final String EMAIL = "andy@domain.com";
    private static final String PWD = "testo";

    @BeforeMethod
    public void openChrome() {
        driver = new ChromeDriver();
        driver.get(url);
    }

    @AfterMethod
    public void closeChrome() {
        driver.quit();
    }

    @Test(retryAnalyzer = Retry.class)
    public void createAddress() {
        // Arrange
        int randomNum = ThreadLocalRandom.current().nextInt(1, 5000 + 1);
        String faddress = "road company";
        String city = "paris";
        String state = "Texas"; // ou String texas = "#thenumber"
        String zip = "75000";
        String country = "United States";
        String phone = "06505050";
        String alias = "ADD3"+Integer.toString(randomNum);

        // Act
        var hp = new HomePage(driver);
        String expectedAlias = hp.openAuthentication()
                .logIn(EMAIL, PWD)
                .openAddressPage()
                .createAddress()
                .enterFirstAddress(faddress)
                .enterCity(city)
                .selectState(state)
                .selectCountry(country)
                .enterPostCode(zip)
                .enterMobilePhone(phone)
                .enterAddressAlias(alias)
                .save()
                .getLastAliasAddress();

        // Assert
        Assert.assertEquals(expectedAlias, alias, "Wrong address created, shown = "
                + expectedAlias
                + " and expected = "
                + alias);
    }

    @Test(retryAnalyzer = Retry.class)
    public void updateAddress() {
        // Arrange
        String company = "super company";
        String mobile = "06003231";
        String sndAddress = "second street";
        int addressIndex = 0;

        // Act
        var hp = new HomePage(driver);
        var addPage = hp.openAuthentication()
                .logIn(EMAIL, PWD)
                .openAddressPage()
                .updateAddress(addressIndex)
                .enterCompany(company)
                .enterMobilePhone(mobile)
                .enterSndAddress(sndAddress).save();

        String updatedCompany = addPage.getCompanyName(addressIndex);
        String updatedMobile = addPage.getMobile(addressIndex);
        String updatedSndAddress = addPage.getSndAddress(addressIndex);

        // Assert
        Assert.assertEquals(company, updatedCompany, "Wrong company update");
        Assert.assertEquals(mobile, updatedMobile, "Wrong mobile update");
        Assert.assertEquals(sndAddress, updatedSndAddress, "Wrong 2nd Address update");
    }

    @Test(retryAnalyzer = Retry.class)
    public void sameAddress() {
        // Arrange
        String email = "same@domain.com";
        String pwd = "tasta";
        String name = "john smith";
        String address = "road issy";
        String mobile = "06060606";
        String alias = "ADDRESS";
        String expectedCredential = name+address+mobile;

        // Act
        var hp = new HomePage(driver);
        String add = hp.openAuthentication()
                .logIn(email, pwd)
                .openAddressPage().getFullAddress(0);

        // Assert
        Assert.assertEquals(expectedCredential, add, "Not the same address: expected = "
                + expectedCredential
                + " got = "
                + add);
    }
}
