package org.example;

import org.openqa.selenium.By;



public class Electronics extends Utils{

    public void clickOnCameraAndPhotoButton(){
        driver.findElement(By.linkText("Camera & photo")).click();
    }


}
