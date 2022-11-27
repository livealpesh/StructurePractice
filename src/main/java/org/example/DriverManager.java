package org.example;

//importing org.openqa.selenium.chrome.ChromeDriver package

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

//importing org.openqa.selenium.chrome.ChromeDriver package
public class DriverManager extends Utils
{
    String browserName = LoadPop.getProperty("browser");


    //To open browser
    public void openBrowser()
    {
        if (browserName.equalsIgnoreCase("chorme"))
        {
//      set driver path for Chrome browser
            System.setProperty("webdriver.chrome.driver", "src/test/java/Driver/chromedriver.exe");
//      opening Chrome browser
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("edge"))
        {
//      set driver path for ms edge browser
            System.setProperty("webdriver.edge.driver", "src/test/java/Driver/msedgedriver.exe");
//      opening ms edge browser
            driver = new EdgeDriver();

        }
//        else if (browserName.equalsIgnoreCase("firefox"))
//        {
////      set driver path firefox browser
//            System.setProperty("webdriver.gecko.driver", "src/test/java/Driver/geckodriver.exe");
////      opening firefox browser
//            driver = new FirefoxDriver();

//        }
        else
        {
            System.out.println("Your browser name is wrong or missing:"+browserName);
        }


//        Navigating to demo.nopcommerce.com website with get() method through the object driver

//       this is hardcore for opening a home page we can use it
//       driver.get("https://demo.nopcommerce.com/");
//       now we opening home page by load Property class
//       LoadPop is static  so this  class so we called directly for opning hompage
//       url is from TestData.Properties filr
//       every test data now write down in  TestData.Properties file

        driver.get(LoadPop.getProperty("url"));
//        Keeping the browser in full screen mode
        driver.manage().window().maximize();
//       waiting for the loading the web page
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));



    }


    //To close browser
    public void closeBrowser() {
        driver.quit();
    }
}
