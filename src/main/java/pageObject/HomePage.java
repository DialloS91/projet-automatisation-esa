package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    WebDriver driver;
    By signinButtonSelector = By.cssSelector(".header_user_info");
    By searchBar = By.id("search_query_top");
    By searchSubmit = By.cssSelector("[name = 'submit_search']");


    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public AuthenticationPage openAuthentication() {
        System.out.println("Open Authentication page");
        driver.findElement(signinButtonSelector).click();
        return new AuthenticationPage(driver);
    }

    public SearchPage searchBarArticle(String article) {
        System.out.println("Search an Article and submit");
        driver.findElement(searchBar).sendKeys(article);
        driver.findElement(searchSubmit).click();
        return new SearchPage(driver);
    }


}
