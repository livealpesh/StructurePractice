package org.example;

import org.openqa.selenium.By;
import org.testng.Assert;

public class EmailAFriendPageAppleMcBook extends Utils{

    //creating class to email a friend to refer a product

        //declaring locators
        private final By _entreFriendEmail = By.xpath("//input[@class=\"friend-email\"]");
        private final By _entreYouComments = By.xpath("//textarea[@class=\"your-email\"]");
        private final By _clickOnSendEmailButton = By.xpath("//button[@name=\"send-email\"]");

        //creating class to verify user is on email a friend page or not
        public void verifyUserIsOnEmailAfriendPage() {
            //using assert method to verify user is on email a friend page or not
            Assert.assertTrue(driver.getCurrentUrl().contains("productemailafriend/4"));
        }

    //creating method to send an email
    public void sendAnEmailToAFriendAppleMcBook() {
//enter user's friend email id
        typeText(_entreFriendEmail, LoadProp.getProperty("friendemail1")+getTimeStamp()+LoadProp.getProperty("friendemail2"));
        //enter users' email id
        typeText(_entreYouComments,LoadProp.getProperty("entre_coment_emailfriend_page"));
        //click on email button
        clickOnElement(_clickOnSendEmailButton);
    }
}


















