package org.example;
import org.openqa.selenium.By;
import org.testng.Assert;
//RegisterResultPage class inheriting the properties of Utils class
public class RegistrationPage extends Utils {
    //Female radio button locator
    private By _maleRadioButton = By.id("gender-male");

    //First name dialog box locator
    private By _firstName = By.id("FirstName");

    //Last name dialog box locator
    private By _lastName = By.id("LastName");

    //Select Day of birth locator
    private By _day = By.name("DateOfBirthDay");

    //Select Month of birth locator
    private By _month = By.name("DateOfBirthMonth");

    //Select Year of birth locator
    private By _year = By.name("DateOfBirthYear");

    //Email dialog box locator
    private By _email = By.id("Email");

    //Company name dialog box locator
    private By _companyName = By.id("Company");

    //Newsletter check box locator
    private By _newsletter = By.xpath("//input[@type=\"checkbox\"]");

    //Password dialog box locator
    private By _password = By.id("Password");

    //Confirm password dialog box locator
    private By _confirmPassword = By.id("ConfirmPassword");

    //Register button on registration page locator
    private By _register = By.id("register-button");

    //driver is waiting for URL and verifying user is on right page
    public void verifyUserIsOnRegisterPage()
    {
       waitForUrlTobe("https://demo.nopcommerce.com/register?returnUrl=%2F",10);

        // verifying user is on right page with assert
        Assert.assertTrue(driver.getCurrentUrl().contains("register"));

    }

    public void register()
    {
        //clicking on female radio button
        clickOnElement(_maleRadioButton);

        //inputting firstname
//        it is hard core code writting so now we called test data from TestData.Properties file as a first name

        typeText(_firstName, LoadProp.getProperty("FirstName"));


        //inputting last name
        typeText(_lastName, LoadProp.getProperty("LastName"));


        //selecting day of the date of birth
      selectFromDropByIndex(_day,1);


        //selecting month of the date of birth
       selectFromDropdownByValue( _month,"2");


        //selecting year of the date of birth

       selectFromDropByIndex(_year,3);


        //inputting email address
        typeText(_email,LoadProp.getProperty("email_1")+getTimeStamp()+LoadProp.getProperty("email_2"));


        //inputting company name
        typeText(_companyName ,LoadProp.getProperty("companyName_Name"));


        //clicking on newsletter checkbox to un tick
        clickOnElement(_newsletter);


        //inputting password
        typeText(_password,LoadProp.getProperty("password_New"));


        //inputting password again to confirm
        typeText(_confirmPassword,LoadProp.getProperty("confirmPassword_Confirm"));


        //clicking on register button
        clickOnElement(_register);

    }

}
