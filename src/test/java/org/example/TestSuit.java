package org.example;

//Importing org.testng.annotations.Test package
import org.testng.annotations.Test;
//TestSuit class inheriting the properties of BaseTest
public class TestSuit extends BaseTest {

//     create  object for access homepage class
     HomePage homePage = new HomePage();

//     create  object for access electronics class
     Electronics electronics =new Electronics();

//     create  object for access CameraAndPhoto class
     CameraAndPhoto cameraAndPhoto = new CameraAndPhoto();

     @Test
     public void registerNewUser()
     {
          //Methods from HomePage class are being called with its object
          homePage.verifyRegisterButtonPresent();
          homePage.clickOnRegisterButton();
          

          //Methods from RegistrationPage class are being called with its object
          registrationPage.verifyUserIsOnRegisterPage();
          registrationPage.register();

          //Method from RegisterResultPage class are being called with its object
          registerResultPage.verifyUserIsAbleToSeeRegisteredMessage();
     }

     @Test
     public void verifyEachProductHasName(){
//         we already on Home Page
//          navigate to the electronics Menu
          homePage.clickOnElectronicsButton();
//           navigate to the Camera & photo Menu
          electronics.clickOnCameraAndPhotoButton();
//          calling method for print the product names
          cameraAndPhoto.printProductNames();








     }


}
