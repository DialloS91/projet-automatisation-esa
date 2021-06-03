package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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
        System.out.println("Save Address");
        driver.findElement(saveSelector).click();
        return new MyAddressPage(driver);
    }

    public YourAddressPage enterFirstName(String keyword) {
        System.out.println("Enter first name = " + keyword);
        driver.findElement(firstNameSelector).clear();
        driver.findElement(firstNameSelector).sendKeys(keyword);
        return this;
    }

    public YourAddressPage enterLastName(String keyword) {
        System.out.println("enter last name = " + keyword);
        driver.findElement(lastNameSelector).clear();
        driver.findElement(lastNameSelector).sendKeys(keyword);
        return this;
    }

    public YourAddressPage enterCompany(String keyword) {
        System.out.println("enter company = " + keyword);
        driver.findElement(companySelector).clear();
        driver.findElement(companySelector).sendKeys(keyword);
        return this;
    }

    public YourAddressPage enterFirstAddress(String keyword) {
        System.out.println("enter first address = " + keyword);
        driver.findElement(address1Selector).clear();
        driver.findElement(address1Selector).sendKeys(keyword);
        return this;
    }

    public YourAddressPage enterSndAddress(String keyword) {
        System.out.println("enter second address = " + keyword);
        driver.findElement(address2Selector).clear();
        driver.findElement(address2Selector).sendKeys(keyword);
        return this;
    }

    public YourAddressPage enterCity(String keyword) {
        System.out.println("enter city = " + keyword);
        driver.findElement(citySelector).clear();
        driver.findElement(citySelector).sendKeys(keyword);
        return this;
    }

    public YourAddressPage selectState(String keyword) {
        System.out.println("select state = " + keyword);
        Select stateDropdown = new Select(driver.findElement(stateSelector));
        stateDropdown.selectByVisibleText(keyword);
        return this;
    }

    public YourAddressPage enterPostCode(String postcode)  {
        //TODO protect postcode
        System.out.println("enter postcode = " + postcode);
        driver.findElement(postcodeSelector).clear();
        driver.findElement(postcodeSelector).sendKeys(postcode);
        return this;
    }

    public YourAddressPage selectCountry(String country) {
        System.out.println("select country = " + country);
        Select countryDropdown = new Select(driver.findElement(countrySelector));
        countryDropdown.selectByVisibleText(country);
        return this;
    }

    public YourAddressPage enterHomePhone(String num) {
        System.out.println("enter homephone num = " + num);
        driver.findElement(phoneSelector).clear();
        driver.findElement(phoneSelector).sendKeys(num);
        return this;
    }

    public YourAddressPage enterMobilePhone(String num) {
        System.out.println("enter mobilephone num = " + num);
        driver.findElement(mobileSelector).clear();
        driver.findElement(mobileSelector).sendKeys(num);
        return this;
    }

    public YourAddressPage enterAdditionalInfo(String info) {
        System.out.println("enter additional info = " + info);
        driver.findElement(addInfoSelector).clear();
        driver.findElement(addInfoSelector).sendKeys(info);
        return this;
    }

    public YourAddressPage enterAddressAlias(String alias) {
        System.out.println("enter address alias = " + alias);
        driver.findElement(aliasSelector).clear();
        driver.findElement(aliasSelector).sendKeys(alias);
        return this;
    }

}
