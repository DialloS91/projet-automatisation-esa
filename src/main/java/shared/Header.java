package shared;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObject.AuthenticationPage;
import pageObject.ProductPage;
import pageObject.SearchPage;

import java.util.List;

public class Header extends Safe {
    WebDriver driver;
    List<WebElement> suggestions;

    By signinButtonSelector = By.cssSelector(".login");
    By searchBar = By.id("search_query_top");
    By searchSubmit = By.cssSelector("[name = 'submit_search']");
    By suggestDropDownSelector = By.cssSelector(".ac_results");
    By suggestionSelector = By.cssSelector(".ac_results ul li");
    By searchSelector = By.id("search_query_top");


    // Wait for suggestion to pop up, no constructor
    public Header(WebDriver driver) {
        this.driver = driver;
    }

    public AuthenticationPage openAuthentication() {
        System.out.println("Open Authentication page");
        safeClick(driver, signinButtonSelector);
        return new AuthenticationPage(driver);
    }

    public SearchPage searchBarArticle(String article) {
        System.out.println("Search an Article and submit");
        driver.findElement(searchBar).sendKeys(article);
        safeClick(driver, searchSubmit);
        return new SearchPage(driver);
    }

    public WebElement getSearchBox() {
        return driver.findElement(By.id("searchbox"));
    }

    public Header partialSearch(String keyword) {
        safeSendKeys(driver, searchSelector, keyword);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(suggestDropDownSelector));
        suggestions = driver.findElements(suggestionSelector);
        return this;
    }

    public String getSuggestionTitle(int index) {
        System.out.println("suggestions = " + suggestions);

        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.elementToBeClickable(suggestions.get(index)));
        var selection = suggestions.get(index);
        //TODO weak
        return selection.getText().split("> ")[1];
    }

    public boolean isSuggestDropDownDisplayed() {
        return driver.findElement(suggestDropDownSelector).isDisplayed();
    }

    public ProductPage openSuggestion(int index) {
        var selection = suggestions.get(index);
        selection.click();
        return new ProductPage(driver);
    }
}
