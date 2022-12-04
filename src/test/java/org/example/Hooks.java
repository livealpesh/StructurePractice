package org.example;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks extends  BasePage {

    DriverManager driverManager = new DriverManager();

    @Before
    public void setup(){

        driverManager.openBrowser();
    }





   @After
   public void tearDown(Scenario scenario){
        if (scenario.isFailed()){

            TakesScreenshot ts= (TakesScreenshot) driver;

            byte[] src = ts.getScreenshotAs(OutputType.BYTES);
            scenario.attach(src,"image/png","screenshot");

        }else {
            System.out.println("Your scenario is paas so it will not take a screenshot because you are using scenario.isfailed fot taking screen shot ");
        }

//        driverManager.closeBrowser();
   }



}
