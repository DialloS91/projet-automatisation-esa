import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObject.HomePage;

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

    @Test
    public void createAddress() {
        // Arrange
        int randomNum = ThreadLocalRandom.current().nextInt(1, 50 + 1);
        String faddress = "road company";
        String city = "paris";
        String state = "Texas";
        String zip = "75000";
        String country = "United States";
        String phone = "06505050";
        String alias = "ADD3"+Integer.toString(randomNum);

        // Act
        var hp = new HomePage(driver);
        hp.openAuthentication()
                .logIn(EMAIL, PWD)
                .openAddressPage()
                .createAddress()
                .enterFirstAddress(faddress)
                .enterCity(city)
                .selectState(state)
                .selectCountry(country)
                .enterPostCode(zip)
                .enterMobilePhone(phone)
                .enterAddressAlias(alias).save();

        By aliasSelector = By.cssSelector(".bloc_adresses div h3");
        var addressList = driver.findElements(aliasSelector);
        var expectedAlias = addressList.get(addressList.size()-1).getText();


        // Assert
        Assert.assertEquals(expectedAlias, alias, "Wrong address created, shown = "
                + expectedAlias
                + " and expected = "
                + alias);
    }

    @Test
    public void updateAddress() {
        // Arrange
        String company = "super company";
        String mobile = "06003231";
        String sndAddress = "second street";
        int addressIndex = 0;

        // Act
        var hp = new HomePage(driver);
        hp.openAuthentication()
                .logIn(EMAIL, PWD)
                .openAddressPage()
                .updateAddress(addressIndex)
                .enterCompany(company)
                .enterMobilePhone(mobile)
                .enterSndAddress(sndAddress).save();

        By addressSelector = By.cssSelector(".bloc_adresses div");
        var addressList = driver.findElements(addressSelector);
        var updatedAddress = addressList.get(addressIndex);
        String updatedCompany = driver.findElement(By.cssSelector(".address_company")).getText();
        String updatedMobile = driver.findElement(By.cssSelector(".address_phone_mobile")).getText();
        String updatedSndAddress = driver.findElement(By.cssSelector(".address_address2")).getText();

        // Assert
        Assert.assertEquals(company, updatedCompany, "Wrong company update");
        Assert.assertEquals(mobile, updatedMobile, "Wrong mobile update");
        Assert.assertEquals(sndAddress, updatedSndAddress, "Wrong 2nd Address update");
    }

    @Test
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
                .openAddressPage().getAddress(0);

        // Assert
        Assert.assertEquals(expectedCredential, add, "Not the same address: expected = "
                + expectedCredential
                + " got = "
                + add);
    }
}
