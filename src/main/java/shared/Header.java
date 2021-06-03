package shared;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pageObject.AuthenticationPage;
import pageObject.SearchPage;

public class Header extends Safe {
    By signinButtonSelector = By.cssSelector(".header_user_info");
    By searchBar = By.id("search_query_top");
    By searchSubmit = By.cssSelector("[name = 'submit_search']");
    WebDriver driver;

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
}
