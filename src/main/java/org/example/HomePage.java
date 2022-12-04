package org.example;
//importing org.openqa.selenium.By package

import org.openqa.selenium.By;
//importing org.testng.Assert package
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;

//HomePage class inheriting the properties of Utils class
public class HomePage extends Utils {

    //Register locator on homepage
    private By _registrationButton = By.className("ico-register");
    //locator to click on vote button on homepage
    private By _voteButton = By.id("vote-poll-1");
    private By _appleMcBook = By.xpath("//img[@title=\"Show details for Apple MacBook Pro 13-inch\"]");

    //locator for to click on detail button for news reelease on homepage
    private By _newsReleaseDetilsButton = By.xpath("//div[@class=\"buttons\"]/a[@href=\"/nopcommerce-new-release\"]");

    //locator for to click on facebook symbol on homepage
    private By _faceBookSymbol = By.className("facebook");

    private By _serachBar = By.xpath("//input[@class=\"search-box-text ui-autocomplete-input\"]");
    private By _searchBarButton=By.xpath("//button[@class=\"button-1 search-box-button\"]");



    public void verifyRegisterButtonPresent() {
        //driver is waiting for URL
        waitForUrlTobe("https://demo.nopcommerce.com/", 10);
        //verifying Register Button Is Present
        Assert.assertEquals(getTextFromElement(By.className("ico-register")), "Register", "your test is failed ");

    }
    //clicking on register button on homepage
    public void clickOnRegisterButton() {
        clickOnElement(_registrationButton);
    }

    //creating method to click on news release details button
    public void clickOnNewsReleaseDetilsButton() {

        clickOnElement(_newsReleaseDetilsButton);
    }

    //creating method to click on vote button
    public void clickOnVoteButton() {
        clickOnElement(_voteButton);
    }

    //creating method to click on pop up alert
    public void alertPopUpdisplayAccept() {
        driver.switchTo().alert().accept();
    }


    public void clickOnElectronicsButton(){
        driver.findElement(By.linkText("Electronics")).click();
    }

    public void clickOnComputersButton(){
        driver.findElement(By.linkText("Computers")).click();
    }
    public void clickOnNotebooksButton(){
        driver.findElement(By.linkText("Notebooks")).click();
    }




    // method create for clickOnCategoryPage for BDD category feature file to click various category into the home page
    public void clickOnCategoryPage(String category){
        clickOnElement(By.linkText(category));
    }


    //creating method to click on facebook symbol
    public void clickOnFaceBookSymbol() {
        clickOnElement(_faceBookSymbol);
    }

    //creating method to verify current currency symbol price is present on homepage
    public void curruntCurruncySymbolresentWithPricesOnHomepage() {
//creating object to verify current currency symbol price is present on homepage
        List<WebElement> productsPrices = driver.findElements(By.xpath("//span[@class=\"price actual-price\"]"));
        System.out.println(productsPrices.size());
        Select select = new Select(driver.findElement(By.id("customerCurrency")));
        select.getFirstSelectedOption();
        for (WebElement element : productsPrices) {
            Assert.assertTrue(element.getText().contains("$"), "curruncy symbol $ is missing");
        }
    }
    //creating class to click on apple mc book product on home page
    public void clickOnAppleMcBookProductOnHomePage() {
        clickOnElement(_appleMcBook);
    }

    //creating class to click on electronic page
    public void navigateToElectronicsPage() {
        clickOnElement(By.xpath("//ul[@class=\"top-menu notmobile\"]/li[2]"));
    }

    public void hoverOverAndCheckTheColorChangeOnCatagoryPage(String category, String subcategory){
        WebElement categoryLink=driver.findElement(By.xpath("//ul[contains(@class,'notmobile')]//a[contains(.,'"+category+"')]"));
        String beforeHover =categoryLink.getCssValue("color");
        System.out.println("Before hover color for category link is = "+beforeHover);
        Actions builder = new Actions(driver);
        Action mouesOverCategory = builder.moveToElement(categoryLink).build();
        mouesOverCategory.perform();
        String afterHover =categoryLink.getCssValue("color");
        System.out.println("After hover color for category link is = "+afterHover);
        clickOnElement(By.linkText(subcategory));
        waitForUrlTobe("https://demo.nopcommerce.com/camera-photo",20);
    }

    public void searchProductsInSearchBarAtHomepage(){
        typeText(_serachBar,LoadProp.getProperty("searchbar_homepage"));
        clickOnElement(_searchBarButton);
    }

}
