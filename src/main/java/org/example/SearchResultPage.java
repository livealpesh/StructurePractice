package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class SearchResultPage extends Utils
{
    private By _productGrid = By.xpath("//div[@class=\"product-grid\"]");
    private By _productTitle = By.xpath("//h2[@class=\"product-title\"]");
    public void verifyUserIsOnSearchResultPage(){
        Assert.assertTrue(driver.getCurrentUrl().contains("search?"));
    }
    public void verifyYourSearchProductPresentOnTheResultPage(){
        List<WebElement> webElementList=driver.findElements(_productTitle);
        System.out.println(webElementList.size());
        for (WebElement element : webElementList){
            System.out.println(element.getText());
        }

    }
}
