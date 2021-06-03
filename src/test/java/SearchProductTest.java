import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObject.HomePage;
import shared.Safe;

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

    @Test
    public void SearchArticleTest(){


        String article = "Dress";
        By products = By.cssSelector("[itemprop='name']");

        // Act
        HomePage siteHP = new HomePage(driver);
        siteHP.searchBarArticle(article);



        // Assert
        String articleText1 = driver.findElements(products).get(1).getText();
        Assert.assertTrue(articleText1.contains(article));
        String articleText2 = driver.findElements(products).get(2).getText();
        Assert.assertTrue(articleText2.contains(article));
        String articleText3 = driver.findElements(products).get(3).getText();
        Assert.assertTrue(articleText3.contains(article));
    }

    @Test
    public void searchArticleAutocomplete() {
        // Arrange
        String incomplete = "dre";

        // Act
        By autoBlockSelector = By.cssSelector(".ac_results");
        By firstChoiceSelector = By.cssSelector(".ac_results ul li:first-child");
        By searchSelector = By.id("search_query_top");
        By titleProductSelector = By.cssSelector("#product [itemprop=\"name\"]");
        safeSendKeys(driver, searchSelector, incomplete);
        String expectedTitleProduct = safeGetText(driver, firstChoiceSelector).split("> ")[1];

        // Assert
        Assert.assertTrue(driver.findElement(autoBlockSelector).isDisplayed());
        safeClick(driver, firstChoiceSelector);
        Assert.assertEquals(safeGetText(driver, titleProductSelector), expectedTitleProduct);
    }

    @Test
    public void searchBarInsideHeader() {
        // Arrange

        // Act
        WebElement header = driver.findElement(By.tagName("header"));

        // Assert
        Assert.assertTrue(header.findElement(By.id("searchbox")).isDisplayed());
    }
}
