package org.example;

import org.openqa.selenium.By;
import org.testng.Assert;


//creating class to navigate page to camera page from electronics page

public class ElectronicsPage extends Utils{

//    public void clickOnCameraAndPhotoButton(){
//        driver.findElement(By.linkText("Camera & photo")).click();
//    }

    //creating method to verify user is on electronics page
    public void verifyUserIsOnElectronicsPage() {
        //using assert to verify user in register page or note
        Assert.assertTrue(driver.getCurrentUrl().contains("electronics"));
    }
    //creating method to navigate page to camera page from electronics page
    public void navigateToCameracPage() {
        //by exporting click on element from utils class to click on camera button
        clickOnElement(By.xpath("//h2[@class=\"title\"]/a[@title=\"Show products in category Camera & photo\"]"));
    }


}
