package org.example;

import org.openqa.selenium.By;
import org.testng.Assert;
//importing java util set to handle pop up window
import java.util.Set;
//importing time unit to handle wait time
import java.util.concurrent.TimeUnit;

//crating class to land on facebook page ,close face book page and come back to main window
// by using reusable method from utils class
public class FaceBookPage extends Utils {
    //crating method to land on facebook page ,close face book page and come back to main window
    public void userSwitchToMainPage() {
//deleting any cookies which can cause any action after clicking on facebook symbol from homepage
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        //creating object to handle pop up window
        String MainWindow = driver.getWindowHandle();
        Set<String> s1 = driver.getWindowHandles();
        for (String ChildWindow : s1) {
            if (!MainWindow.equalsIgnoreCase(ChildWindow)) {
                driver.switchTo().window(ChildWindow);
                clickOnElement(By.xpath("/html/body/div[2]/div[1]/div/div[2]/div/div/div/div[2]/div/div[2]/div[1]/div/div[1]/div/span/span"));
                //using assert to verify user is on facebook page or not
                Assert.assertTrue(driver.getCurrentUrl().contains("facebook.com/nopCommerce"));
                //printing if test case is pass
                System.out.println("Step 1: child window has opened successfully __facebook page");
                //closing facebook window
                driver.close();
                //switching back to main window
                driver.switchTo().window(MainWindow);
                // using assert to verify user is on main window or not
                Assert.assertTrue(driver.getCurrentUrl().contains("nopcommerce"));
                //  printing if test case is pass
                System.out.println("Step 2:  back on main window successfully __nopcommerce website");
            }
        }
    }
}
