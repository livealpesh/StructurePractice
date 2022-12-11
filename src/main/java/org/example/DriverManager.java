package org.example;

//importing org.openqa.selenium.chrome.ChromeDriver package

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;

//importing org.openqa.selenium.chrome.ChromeDriver package
public class DriverManager extends Utils {

// =========================   write down code for BROWSERSTACK to automation run into the cloud========================

    public static final String USERNAME = LoadProp.getProperty("BROWSERSTACK_USERNAME");
    public static final String AUTOMATE_KEY = LoadProp.getProperty("BROWSERSTACK_ACCESS_KEY");
    public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

//    if we are runiing the test case by load prop we are using LoadProp.getProperty("browser");
    String browserName = LoadProp.getProperty("browser");

//    if we are using (System.getProperty("cloud")) to customize in to the jenkins by Vm.

//     String browserName = System.getProperty("browser");

    boolean runIncloud = Boolean.parseBoolean(LoadProp.getProperty("cloud"));

//    if we are using (System.getProperty("cloud")) we need to go right corner in Testsuit.RegisterNewUser
//    and click /select edit config/choose vm option /write a -Dcloue=true
//    boolean runIncloud = Boolean.parseBoolean(System.getProperty("cloud"));

    MutableCapabilities capabilities = new MutableCapabilities();


    //To open browser
    public void openBrowser() {

// ===================================run in cloud====================================================================

        if (runIncloud) {
            System.out.println("running in the cloud");

//=============================connect to cloud========================================================================

            if (browserName.equalsIgnoreCase("Edge")) {
                ///connect with browserstack
                capabilities.setCapability("browserName", "Edge");
                capabilities.setCapability("browserVersion", "106.0");
                HashMap<String, Object> browserstackOptions = new HashMap<String, Object>();
                browserstackOptions.put("os", "Windows");
                browserstackOptions.put("osVersion", "10");
                browserstackOptions.put("local", "false");
                browserstackOptions.put("seleniumVersion", "4.1.0");
                capabilities.setCapability("bstack:options", browserstackOptions);

// this line code responsible for open
//                try {
//                    driver = new RemoteWebDriver(new URL(URL), capabilities);
//                } catch (MalformedURLException e) {
//                    throw new RuntimeException(e);
//                }

            } else if (browserName.equalsIgnoreCase("Firefox")) {
                ///connect with browserstack
                capabilities.setCapability("browserName", "firefox");
                capabilities.setCapability("browserVersion", "106.0");
                HashMap<String, Object> browserstackOptions = new HashMap<String, Object>();
                browserstackOptions.put("os", "Windows");
                browserstackOptions.put("osVersion", "11");
                browserstackOptions.put("local", "false");
                browserstackOptions.put("seleniumVersion", "4.1.0");
                capabilities.setCapability("bstack:options", browserstackOptions);

//this line code responsible for open
//                try {
//                    driver = new RemoteWebDriver(new URL(URL), capabilities);
//                } catch (MalformedURLException e) {
//                    throw new RuntimeException(e);
//                }

            } else if (browserName.equalsIgnoreCase("Chrome")) {
                capabilities.setCapability("browserName", "Chrome");
                capabilities.setCapability("browserVersion", "latest");
                HashMap<String, Object> browserstackOptions = new HashMap<String, Object>();
                browserstackOptions.put("os", "Windows");
                browserstackOptions.put("osVersion", "11");
                browserstackOptions.put("local", "false");
                browserstackOptions.put("seleniumVersion", "3.14.0");
                capabilities.setCapability("bstack:options", browserstackOptions);

//this line code responsible for open

//                try {
//                    driver = new RemoteWebDriver(new URL(URL), capabilities);
//                } catch (MalformedURLException e) {
//                    throw new RuntimeException(e);
//                }

            } else {
                System.out.println("Your browser name is wrong or missing implementation:" + browserName);
            }

//           make global  this line responsible for open a latest default browser open chrome if we are not providing
//           any instruction to which browser ,version etc.

            try {
                driver = new RemoteWebDriver(new URL(URL), capabilities);
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            }

//            run in locally============================================================================================

        } else {
            System.out.println("running in the locally");

            if (browserName.equalsIgnoreCase("Chrome")) {
//      set driver path for Chrome browser
                System.setProperty("webdriver.chrome.driver", "src/test/java/Driver/chromedriver.exe");
//      opening Chrome browser
                driver = new ChromeDriver();
            } else if (browserName.equalsIgnoreCase("edge")) {
//      set driver path for ms edge browser
                System.setProperty("webdriver.edge.driver", "src/test/java/Driver/msedgedriver.exe");
//      opening ms edge browser
                driver = new EdgeDriver();

            } else if (browserName.equalsIgnoreCase("firefox")) {
//      set driver path firefox browser
                System.setProperty("webdriver.gecko.driver", "src/test/java/Driver/geckodriver.exe");
//      opening firefox browser
                driver = new FirefoxDriver();

            } else {
                System.out.println("Your browser name is wrong or missing:" + browserName);
            }

        }

//        Navigating to demo.nopcommerce.com website with get() method through the object driver

//       this is hardcore for opening a home page we can use it
//       driver.get("https://demo.nopcommerce.com/");
//       now we opening home page by load Property class
//       LoadPop is static  so this  class so we called directly for opening homepage
//       url is from TestData.Properties filr
//       every test data now write down in  TestData.Properties file

        driver.get(LoadProp.getProperty("url"));

        //       waiting for the loading the web page
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        Keeping the browser in full screen mode
        driver.manage().window().maximize();

    }

    //To close browser
    public void closeBrowser() {
        driver.quit();
    }
}
