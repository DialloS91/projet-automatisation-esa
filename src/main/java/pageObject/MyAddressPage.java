package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyAddressPage {
    WebDriver driver;

    By AddressSelector = By.cssSelector(".bloc_adresses ul");
    By nameAddressSelector = By.cssSelector(".bloc_adresses ul li .address_name");
    By mobileAddressSelector = By.cssSelector(".bloc_adresses ul li .address_phone_mobile");
    By firstAddressSelector = By.cssSelector(".bloc_adresses ul li .address_address1");
    By createAddressSelector = By.cssSelector("[title=\"Add an address\"]");
    By updateAddressSelector = By.cssSelector(".bloc_adresses ul [title=\"Update\"]");
    By aliasSelector = By.cssSelector(".bloc_adresses div h3");
    By companySelector = By.cssSelector(".bloc_adresses div .address_company");
    By sndAddressSelector = By.cssSelector(".bloc_adresses div .address_address2");
    By mobileSelector = By.cssSelector(".bloc_adresses div .address_phone_mobile");

    public MyAddressPage(WebDriver driver) {
        this.driver = driver;
    }

    public YourAddressPage createAddress() {
        System.out.println("Create Address");
        driver.findElement(createAddressSelector).click();
        return new YourAddressPage(driver);
    }

    public YourAddressPage updateAddress(int index) {
        System.out.println("Update Address");
        var addressList = driver.findElements(updateAddressSelector);
        addressList.get(index).click();
        return new YourAddressPage(driver);
    }

    public String getFullAddress(int index) {
        var addresses = driver.findElements(AddressSelector).get(index);
        String result = "";

        var nameList = addresses.findElements(nameAddressSelector);
        var name = nameList.get(0).getText()+" "+nameList.get(1).getText();
        var fstadd = addresses.findElement(firstAddressSelector).getText();

        WebDriverWait wait = new WebDriverWait(driver, 5);
        var mobile = wait.until(ExpectedConditions.elementToBeClickable(mobileAddressSelector)).getText();

        System.out.println("Get text address: " + "name: " + name + " address: " + fstadd + " mobile: " + mobile);

        result = result+name+fstadd+mobile;

        return result;
    }

    //TODO make it generic
    public String getLastAliasAddress() {
        var addressList = driver.findElements(aliasSelector);
        return addressList.get(addressList.size()-1).getText();
    }

    public String getCompanyName(int index) {
        return driver.findElement(companySelector).getText();
    }

    public String getMobile(int index) {
        return driver.findElement(mobileSelector).getText();
    }

    public String getSndAddress(int index) {
        return driver.findElement(sndAddressSelector).getText();
    }
}
