package org.example;
//Importing org.testng.annotations.AfterMethod package
import org.testng.annotations.AfterMethod;

//Importing org.testng.annotations.BeforeMethod package
import org.testng.annotations.BeforeMethod;
//BaseTest inheriting the properties of Utils
public class BaseTest extends Utils {
    //Creating Object of DriverManager
   DriverManager driverManager = new DriverManager();

    //Creating Object of Homepage
    HomePage homepage =new HomePage();

    //Creating Object of RegistrationPage
    RegistrationPage registrationPage=new RegistrationPage();

    //Creating Object of RegisterResultPage
    RegisterResultPage registerResultPage = new RegisterResultPage();

    //Before Method Annotation will execute this method before executing any other method
    @BeforeMethod
    public void SetUp()
    {
       //openBrowser method is called with object
        driverManager.openBrowser();
    }


    @AfterMethod
//AfterMethod Annotation will execute this method after executing any other method
  public void tearDown()
  {
      //closeBrowser method is called with object
      driverManager.closeBrowser();
  }


}
