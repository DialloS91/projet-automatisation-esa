package pageObject;

import org.apache.commons.exec.util.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Arrays;

public class MyAddressPage {
    WebDriver driver;

    By AddressSelector = By.cssSelector(".bloc_adresses ul");
    By nameAddressSelector = By.cssSelector(".bloc_adresses ul li .address_name");
    By mobileAddressSelector = By.cssSelector(".bloc_adresses ul li .address_phone_mobile");
    By firstAddressSelector = By.cssSelector(".bloc_adresses ul li .address_address1");
    By createAddressSelector = By.cssSelector("[title=\"Add an address\"]");
    By updateAddressSelector = By.cssSelector(".bloc_adresses ul [title=\"Update\"]");

    public MyAddressPage(WebDriver driver) {
        this.driver = driver;
    }

    public YourAddressPage createAddress() {
        driver.findElement(createAddressSelector).click();

        return new YourAddressPage(driver);
    }

    public YourAddressPage updateAddress(int index) {
        var addressList = driver.findElements(updateAddressSelector);
        addressList.get(index).click();

        return new YourAddressPage(driver);
    }

    public String getAddress(int index) {
        var addresses = driver.findElements(AddressSelector).get(index);
        var nameList = addresses.findElements(nameAddressSelector);
        var fstadd = addresses.findElement(firstAddressSelector).getText();
        var mobile = addresses.findElement(mobileAddressSelector).getText();
        String result = "";

        result = result.concat(nameList.get(0).getText()+" "+nameList.get(1).getText());
        result = result+fstadd+mobile;

        return result;
    }

}
