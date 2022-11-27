package org.example;
//import org.openqa.selenium.By package
import org.openqa.selenium.By;
//importing org.testng.Assert package
import org.testng.Assert;

//RegisterResultPage class inheriting the properties of Utils class
public class RegisterResultPage extends Utils {

        //locator of text message after registration
        private By _registrationResultText = By.className("result");

        //storing the expected string value to variable expectedRegistrationText
        static String expectedRegistrationText  = "Your registration completed";


// if you are not using assert for comparing to expected result to actual result then it is not Test case do not use SOUT it is for print the message only for Console so never used

        //driver is waiting for URL and verifying register message is as expected
        public void verifyUserIsAbleToSeeRegisteredMessage()
        {
            //driver is waiting for URL
            waitForUrlTobe("https://demo.nopcommerce.com/registerresult/1?returnUrl=/",10);

            String registerResulMessage =  getTextFromElement(_registrationResultText);
            System.out.println(registerResulMessage);

            //verifying register message is as expected
            Assert.assertEquals(registerResulMessage , expectedRegistrationText);

        }
}
