package shared;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Safe {
    private static final long TIME = 10;

    public void safeClick(WebDriver driver, By by) {
        WebDriverWait wait = new WebDriverWait(driver, TIME);
        wait.until(ExpectedConditions.elementToBeClickable(by)).click();
    }

    public void safeSendKeys(WebDriver driver, By by, String keys) {
        WebDriverWait wait = new WebDriverWait(driver, TIME);
        wait.until(ExpectedConditions.elementToBeClickable(by)).sendKeys(keys);
    }

    public String safeGetText(WebDriver driver, By by) {
        WebDriverWait wait = new WebDriverWait(driver, TIME);
        return wait.until(ExpectedConditions.elementToBeClickable(by)).getText();
    }
}
