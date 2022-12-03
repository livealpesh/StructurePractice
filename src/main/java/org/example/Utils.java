package org.example;
//Importing org.openqa.selenium.By package
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
//Importing org.openqa.selenium.support.ui.ExpectedConditions package
import org.openqa.selenium.support.ui.ExpectedConditions;
//Importing org.openqa.selenium.support.ui.Select package
import org.openqa.selenium.support.ui.Select;
//Importing org.openqa.selenium.support.ui.WebDriverWait package
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
//Importing java.text.SimpleDateFormat package
import java.text.SimpleDateFormat;
//Importing java.time.Duration package
import java.time.Duration;


//Utils class inheriting the properties of BasePage
public class Utils extends BasePage{
    //Reusable method clickOnElement() for clicking on element
    public static void clickOnElement(By by) {
        //To 'findElement' with object(driver) of its class and to perform click action
        driver.findElement(by).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }


    //Reusable method typeText() for entering the text in string format
    public static void typeText(By by, String text) {
//To 'findElement' with object(driver) of its class and to perform senKeys action to enter text
        driver.findElement(by).sendKeys(text);
    }
    //Reusable method getTextFromElement() for getting the text from element
    public static String getTextFromElement(By by) {
        //To 'findElement' with object(driver) of its class and to perform getText action to get the string value
        return driver.findElement(by).getText();
    }

    //Reusable method getTimeStamp() for time stamp
    public static String getTimeStamp()
    {
        //storing current year month  date hour minute and seconds in variable timeStamp
        return  new SimpleDateFormat("yyyyMMddHHmmss").format(new java.util.Date());

    }

//  after selenium 4 version wait method calling by below syntax
    //Reusable method waitForElementToBeClickable() for driver to wait for until particular element is clicked

    public static void waitForElementToBeClickable(By by, int timeOfSecond) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOfSecond));
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }
    //Reusable method waitForElementToBeVisible() for driver to wait for until particular element is visible

    public static void waitForElementToBeVisible(By by, int timeOfSecond) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOfSecond));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }
    //Reusable method waitForUrlTOBe() for driver to wait for URL explicitly
    public static void waitForUrlTobe(String url, int timeOfSecond) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOfSecond));
        wait.until(ExpectedConditions.urlToBe(url));
    }
    //Reusable method selectFromDropDownByIndex() for select the element by index
    public static void selectFromDropByIndex(By by, int index) {
        //Using select class with its object to select the month using findElement function
        Select selectDay = new Select(driver.findElement(by));
        // To select year using selectByIndex function
        selectDay.selectByIndex(index);
    }
    //Reusable method selectFromDropDownByValue() for select the element by its value
    public static void selectFromDropdownByValue(By by, String selectValue) {
        //Using select class with its object to select the month using findElement function
        Select selectYear = new Select(driver.findElement(by));
        // To select Month  using selectByValue function
        selectYear.selectByValue(selectValue);
    }
    //Reusable method selectFromDropDownByVisibleText() for select the element by its visible text
    public static void selectFromDropdownByVisibleText(By by, String visibleText) {
        //Using select class with its object to select the day using findElement function
        Select selectMonth = new Select(driver.findElement(by));
        // To select day using selectByVisibleText function
        selectMonth.selectByVisibleText(visibleText);
    }
//    assert apply for feature file in bdd category feature file for verify we are in category link
    public static void assertCurrentURL(String categoryName){
        Assert.assertTrue(driver.getCurrentUrl().contains(categoryName));
    }


}
