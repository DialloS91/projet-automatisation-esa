package shared;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Safe {
    private static final long TIME = 5;

    public void safeClick(WebDriver driver, WebElement we) {
        WebDriverWait wait = new WebDriverWait(driver, TIME);
        wait.until(ExpectedConditions.elementToBeClickable(we)).click();
    }

    public void safeSendKeys(WebDriver driver, WebElement we, String keys) {
        WebDriverWait wait = new WebDriverWait(driver, TIME);
        wait.until(ExpectedConditions.elementToBeClickable(we)).sendKeys(keys);
    }
}
