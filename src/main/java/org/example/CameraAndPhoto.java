package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class CameraAndPhoto extends Utils{


    public void printProductNames() {
//        using list method for dynamic Change in web page
        List<WebElement> productName = driver.findElements(By.xpath("//h2[@class=\"product-title\"]"));
//       print how many product name in this whole webpage its give you number for double check
        System.out.println(productName.size());
//        apply for loop for print whole list coverage into the product name
        for (WebElement element : productName){
//        printing for product name
            System.out.println(element.getText());
        }

    }


}
