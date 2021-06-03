package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateAccountPage {

    WebDriver driver;

    public CreateAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    By genderMrs = By.id("id_gender2");
    By genderMr = By.id("id_gender1");
    By enterFirstName = By.id("customer_firstname");
    By enterLastName = By.id("customer_lastname");
    By enterPassword = By.id("passwd");
    By selectDayBirth = By.id("days");
    By selectMonthBirth = By.id("months");
    By selectYearBirth = By.cssSelector("#years");
    By selectNewsletter = By.id("newsletter");
    By selectOffers = By.id("optin");
    By enterAdressFirstName = By.id("firstname");
    By enterAdressLastName = By.id("lastname");
    By enterCompany = By.id("company");
    By enterAdress = By.id("address1");
    By enterAdress2 = By.id("address2");
    By enterCity = By.id("city");
    By enterState = By.id("id_state");
    By enterPostCode = By.id("postcode");
    By enterCountry = By.id("id_country");
    By enterOtherInfo = By.id("other");
    By enterHomePhone = By.id("phone");
    By enterMobilePhone = By.id("phone_mobile");
    By enterAllias = By.id("alias");
    By submitbutton = By.id("submitAccount");


    public CreateAccountPage selectGender() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.elementToBeClickable(genderMr));
        driver.findElement(genderMr).click();
        return this;
    }


    public CreateAccountPage selectOffers() {
        System.out.println("Selecting Offers");
        driver.findElement(selectOffers).click();
        return this;
    }

    public CreateAccountPage selectNewsletter() {
        System.out.println("Selecting Newsletter");
        driver.findElement(selectNewsletter).click();
        return this;
    }


    public CreateAccountPage enterAllias(String alias) {
        System.out.println("entering alias");
        driver.findElement(enterAllias).sendKeys(alias);
        return this;
    }


    public CreateAccountPage selectMobilePhone(String mobilePhone) {
        System.out.println("entering mobile Phone number");
        driver.findElement(enterMobilePhone).sendKeys(mobilePhone);
        return this;
    }


    public CreateAccountPage selectHomePhone(String homePhone) {
        System.out.println("entering Home Phone number");
        driver.findElement(enterHomePhone).sendKeys(homePhone);
        return this;
    }

    public CreateAccountPage selectOtherInfo(String otherInfo) {
        System.out.println("entering additional informations");
        driver.findElement(enterOtherInfo).sendKeys(otherInfo);
        return this;
    }


    public CreateAccountPage selectCountry(String country) {
        System.out.println("entering Country name");
        driver.findElement(enterCountry).sendKeys(country);
        return this;
    }


    public CreateAccountPage selectPostCode(String postCode) {
        System.out.println("entering post code");
        driver.findElement(enterPostCode).sendKeys(postCode);
        return this;
    }


    public CreateAccountPage selectCity(String city) {
        System.out.println("entering City");
        driver.findElement(enterCity).sendKeys(city);
        return this;
    }


    public CreateAccountPage selectState(String state) {
        System.out.println("entering State");
        driver.findElement(enterState).sendKeys(state);
        return this;
    }


    public CreateAccountPage selectAdress2(String adress2) {
        System.out.println("entering Adress 2");
        driver.findElement(enterAdress2).sendKeys(adress2);
        return this;
    }


    public CreateAccountPage selectAdress(String adress) {
        System.out.println("entering Adress");
        driver.findElement(enterAdress).sendKeys(adress);
        return this;
    }

    public CreateAccountPage selectCompany(String company) {
        System.out.println("entering Company");
        driver.findElement(enterCompany).sendKeys(company);
        return this;
    }

    public CreateAccountPage selectAdressLastName(String AdressLastName) {
        System.out.println("entering Adresse Last Name");
        driver.findElement(enterAdressLastName).sendKeys(AdressLastName);
        return this;
    }

    public CreateAccountPage selectAdressFirstNAme(String AdressFirstName) {
        System.out.println("entering Adresse First Name");
        driver.findElement(enterAdressFirstName).sendKeys(AdressFirstName);
        return this;
    }


    public CreateAccountPage selectDay(String dayBirth) {
        System.out.println("selecting Day");
        Select dayDropDown = new Select(driver.findElement(selectDayBirth));
        dayDropDown.selectByValue(dayBirth);
        return this;
    }


    public CreateAccountPage selectMonth(String monthBirth) {
        System.out.println("Selecting Month");
        Select monthDropDown = new Select(driver.findElement(selectMonthBirth));
        monthDropDown.selectByValue(monthBirth);
        return this;
    }

    public CreateAccountPage selectFirstName(String firstName) {
        System.out.println("entering First Name");
        WebDriverWait wait = new WebDriverWait(driver, 2);
        wait.until(ExpectedConditions.elementToBeClickable(enterFirstName));
        driver.findElement(enterFirstName).sendKeys(firstName);


        return this;
    }

    public CreateAccountPage selectLastName(String lastName) {
        System.out.println("entering Last Name");
        driver.findElement(enterLastName).sendKeys(lastName);
        return this;
    }

    public CreateAccountPage selectPassword(String password) {
        System.out.println("entering Password");
        driver.findElement(enterPassword).sendKeys(password);
        return this;
    }

    public CreateAccountPage selectYear(String year) {

        System.out.println("selecting year");
        Select yearDropDown = new Select(driver.findElement(selectYearBirth));
        yearDropDown.selectByValue(year);
        return this;
    }


    public CreateAccountPage EnterPersonalInformation(String mobilePhone, String homePhone, String otherInfo, String country, String postCode, String city, String state, String adress2, String adress, String company, String AdressFirstName, String AdressLastName, String firstName, String lastName, String password, String dayBirth, String monthBirth, String year) {



        selectGender();
        selectFirstName(firstName);
        selectLastName(lastName);
        selectPassword(password);
        selectYear(year);
        selectDay(dayBirth);
        selectMonth(monthBirth);
        selectOffers();
        selectNewsletter();
        selectAdressFirstNAme(AdressFirstName);
        selectAdressLastName(AdressLastName);
        selectCompany(company);
        selectAdress(adress);
        selectAdress2(adress2);
        selectState(state);
        selectCity(city);
        selectPostCode(postCode);
        selectCountry(country);
        selectOtherInfo(otherInfo);
        selectHomePhone(homePhone);
        selectMobilePhone(mobilePhone);
        return this;
    }

    public CreateAccountPage Submit() {
        System.out.println("Submit");
        driver.findElement(submitbutton).click();
        return this;
    }


}
