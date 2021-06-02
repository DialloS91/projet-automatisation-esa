package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class YourAddressPage {
    WebDriver driver;

    By saveSelector = By.id("submitAddress");
    By firstNameSelector = By.id("firstname");
    By lastNameSelector = By.id("lastname");
    By companySelector = By.id("company");
    By address1Selector = By.id("address1");
    By address2Selector = By.id("address2");
    By citySelector = By.id("city");
    By stateSelector = By.id("id_state");
    By postcodeSelector = By.id("postcode");
    By countrySelector = By.id("id_country");
    By phoneSelector = By.id("phone");
    By mobileSelector = By.id("phone_mobile");
    By addInfoSelector = By.id("other");
    By aliasSelector = By.id("alias");

    public YourAddressPage(WebDriver driver) {
        this.driver = driver;
    }

    public MyAddressPage save() {
        driver.findElement(saveSelector).click();
        return new MyAddressPage(driver);
    }

    public YourAddressPage enterFirstName(String keyword) {
        driver.findElement(firstNameSelector).clear();
        driver.findElement(firstNameSelector).sendKeys(keyword);
        return this;
    }

    public YourAddressPage enterLastName(String keyword) {
        driver.findElement(lastNameSelector).clear();
        driver.findElement(lastNameSelector).sendKeys(keyword);
        return this;
    }

    public YourAddressPage enterCompany(String keyword) {
        driver.findElement(companySelector).clear();
        driver.findElement(companySelector).sendKeys(keyword);
        return this;
    }

    public YourAddressPage enterFirstAddress(String keyword) {
        driver.findElement(address1Selector).clear();
        driver.findElement(address1Selector).sendKeys(keyword);
        return this;
    }

    public YourAddressPage enterSndAddress(String keyword) {
        driver.findElement(address2Selector).clear();
        driver.findElement(address2Selector).sendKeys(keyword);
        return this;
    }

    public YourAddressPage enterCity(String keyword) {
        driver.findElement(citySelector).clear();
        driver.findElement(citySelector).sendKeys(keyword);
        return this;
    }

    public YourAddressPage selectState(String keyword) {
        Select stateDropdown = new Select(driver.findElement(stateSelector));
        stateDropdown.selectByVisibleText(keyword);
        return this;
    }

    public YourAddressPage enterPostCode(String postcode)  {
        //TODO protect postcode
        driver.findElement(postcodeSelector).clear();
        driver.findElement(postcodeSelector).sendKeys(postcode);
        return this;
    }

    public YourAddressPage selectCountry(String country) {
        Select countryDropdown = new Select(driver.findElement(countrySelector));
        countryDropdown.selectByVisibleText(country);
        return this;
    }

    public YourAddressPage enterHomePhone(String num) {
        driver.findElement(phoneSelector).clear();
        driver.findElement(phoneSelector).sendKeys(num);
        return this;
    }

    public YourAddressPage enterMobilePhone(String num) {
        driver.findElement(mobileSelector).clear();
        driver.findElement(mobileSelector).sendKeys(num);
        return this;
    }

    public YourAddressPage enterAdditionalInfo(String info) {
        driver.findElement(addInfoSelector).clear();
        driver.findElement(addInfoSelector).sendKeys(info);
        return this;
    }

    public YourAddressPage enterAddressAlias(String alias) {
        driver.findElement(aliasSelector).clear();
        driver.findElement(aliasSelector).sendKeys(alias);
        return this;
    }

}
