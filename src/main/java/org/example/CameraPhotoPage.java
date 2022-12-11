package org.example;
//creating class to verify all the product has add to cart button by extends reusable method from utils class

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class CameraPhotoPage extends  Utils{
    public void addTocartButtoncheck() {
        By itemBoxesfield=By.className("product-item");
        By productnamefield=By.className("product-title");
        List<String> noAddToCartButtonProducts = new ArrayList<String>();

        List<WebElement> webElementList=driver.findElements(itemBoxesfield);
        System.out.println(webElementList.size());
        int count=0;
        for (WebElement element : webElementList)
        {
            if (element.getText().contains("ADD TO CART"))
            {
                count++;
            }else
            {
                noAddToCartButtonProducts.add("NO add to cart Button:"+element.findElement(productnamefield).getText());
            }
        }
        Assert.assertEquals(count,webElementList.size(),"One or more products missing add to card button\n"+noAddToCartButtonProducts);



    }

}
