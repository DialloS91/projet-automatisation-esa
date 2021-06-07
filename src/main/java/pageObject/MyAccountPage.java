package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import shared.Header;

import java.util.List;

public class MyAccountPage extends Header {
    WebDriver driver;

    By addressButtonSelector = By.cssSelector("[title=\"Addresses\"]");
    By errorMsgSelector = By.cssSelector(".alert li");
    By listAccountButtonSelector = By.cssSelector("#center_column li");
    By nameSelector = By.cssSelector("[title='View my customer account']");

    public MyAccountPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public MyAddressPage openAddressPage() {
        System.out.println("Open Address page");
        driver.findElement(addressButtonSelector).click();
        return new MyAddressPage(driver);
    }

    public String getErrorMsg() {
        return driver.findElement(errorMsgSelector).getText();
    }

    public List<WebElement> getButtonList() {
        return driver.findElements(listAccountButtonSelector);
    }

    public String getName() {
        return driver.findElement(nameSelector).getText();
    }
}


