package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyAddressPage {
    WebDriver driver;

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

}
