import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObject.HomePage;
import shared.Header;
import shared.Retry;
import shared.Safe;

import java.util.ArrayList;

public class SearchProductTest extends Safe {
    WebDriver driver;
    String url = "http://automationpractice.com";

    @BeforeMethod
    public void openChrome() {
        driver = new ChromeDriver();
        driver.get(url);
    }

    @AfterMethod
    public void closeChrome() {
        driver.quit();
    }

    @Test(retryAnalyzer = Retry.class)
    public void SearchArticleTest(){
        // Arrange
        String article = "Dress";
        int numberOfProduct = 3;

        // Act
        HomePage siteHP = new HomePage(driver);
        var searchPage = siteHP.searchBarArticle(article);
        var titleList = new ArrayList<String>();
        for (int i = 0; i < numberOfProduct; i++) {
            titleList.add(searchPage.getProductTitle(i));
        }

        // Assert
        titleList.forEach(title -> Assert.assertTrue(title.contains(article),
                "Product title: ["+ title +
                "] does not contain: [" + article +"]"));
    }

    @Test(retryAnalyzer = Retry.class)
    public void searchArticleAutocomplete() {
        // Arrange
        String dress = "dre";
        int firstChoice = 0;

        // Act
        Header header = new Header(driver);
        var suggest = header.partialSearch(dress);
        String expectedTitleProduct = suggest.getSuggestionTitle(firstChoice);

        // Assert
        Assert.assertTrue(suggest.isSuggestDropDownDisplayed());

        String productTitle = suggest
                .openSuggestion(firstChoice)
                .getProductTitle();
        Assert.assertEquals(productTitle, expectedTitleProduct);
    }

    @Test(retryAnalyzer = Retry.class)
    public void searchBarInsideHeader() {
        // Arrange

        // Act
        Header header = new Header(driver);

        // Assert
        Assert.assertTrue(header.getSearchBox().isDisplayed());
    }
}
