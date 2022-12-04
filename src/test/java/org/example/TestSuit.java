package org.example;

//Importing org.testng.annotations.Test package
import org.testng.annotations.Test;
//TestSuit class inheriting the properties of BaseTest
public class TestSuit extends BaseTest {

     //     create  object for access homepage class
     HomePage homePage = new HomePage();

     //     create  object for access electronics class
     ElectronicsPage electronics = new ElectronicsPage();

     //     create  object for access CameraAndPhoto class
     CameraAndPhoto cameraAndPhoto = new CameraAndPhoto();

     //     create  object for access AppleMCBookPage class

     AppleMCBookPage appleMCBookPage = new AppleMCBookPage();

     EmailAFriendPageAppleMcBook emailAFriendPageAppleMcBook = new EmailAFriendPageAppleMcBook();

     EmailaFriendAppleMcBookResultPage emailaFriendAppleMcBookResultPage = new EmailaFriendAppleMcBookResultPage();

     NewsReleasePage newsReleasePage = new NewsReleasePage();

     FaceBookPage faceBookPage = new FaceBookPage();

     ElectronicsPage electronicsPage = new ElectronicsPage();

     CameraPhotoPage cameraPhotoPage = new CameraPhotoPage();

     SearchResultPage searchResultPage = new SearchResultPage();


     @Test
     public void registerNewUser() {
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
     public void verifyEachProductHasName() {
//         we already on Home Page
//          navigate to the electronics Menu
          homePage.clickOnElectronicsButton();
//           navigate to the Camera & photo Menu
//          electronics.clickOnCameraAndPhotoButton();
//          calling method for print the product names
          cameraAndPhoto.printProductNames();

     }

     //test case to handle a pop up alert
     @Test
     public void verifyAlertDisplay() {
          homePage.clickOnVoteButton();
          homePage.alertPopUpdisplayAccept();
     }

     //test case to verify new release comments
     @Test
     public void verifyYourCommentsOnNewsReleasePage() {
          homePage.clickOnNewsReleaseDetilsButton();
          newsReleasePage.entreNewComments();
          newsReleasePage.clickOnNewComentButttonAndverify();
          newsReleasePage.verifyCommentsIsOnLastOfTheAllComments();

     }

     //test case to open facebook page and come back on main window
     @Test
     public void verifyURLOpenAndComeBackFromFacebookPage() {
          homePage.clickOnFaceBookSymbol();
          faceBookPage.userSwitchToMainPage();
     }

     //test case to verify first selected currency symbol present or not
     @Test
     public void verifyPricesByCurruntPriceSymbol() {

          homePage.curruntCurruncySymbolresentWithPricesOnHomepage();
     }


     @Test

     public void verifyRegisteredUserCanReferAProduct() {

          homePage.verifyRegisterButtonPresent();
          homePage.clickOnRegisterButton();
          registrationPage.verifyUserIsOnRegisterPage();
          registrationPage.register();
          registerResultPage.verifyUserIsAbleToSeeRegisteredMessage();
          homePage.clickOnComputersButton();
          homePage.clickOnNotebooksButton();
          homePage.clickOnAppleMcBookProductOnHomePage();
          appleMCBookPage.verifyUserIsOnAppleMcBookPage();
          appleMCBookPage.clickOnSenAEmailToFriend();
          emailAFriendPageAppleMcBook.verifyUserIsOnEmailAfriendPage();
          emailAFriendPageAppleMcBook.sendAnEmailToAFriendAppleMcBook();
          emailaFriendAppleMcBookResultPage.verifyUserOnResultPage();
     }

     //test case to check all the product have add to cart button on camera page
     @Test
     public void verifyProductHasAddToCartButton() {
          homePage.navigateToElectronicsPage();
          electronicsPage.verifyUserIsOnElectronicsPage();
          electronicsPage.navigateToCameracPage();
          cameraPhotoPage.addTocartButtoncheck();

     }

     @Test
     public void verifyColorChangesWhenHoverMouseOverCatagoryPage() {
          homePage.hoverOverAndCheckTheColorChangeOnCatagoryPage("Electronics", "Camera & photo");
     }

     @Test
     public void verifySearchElementsSearchProductsCorroectly() {
          homePage.searchProductsInSearchBarAtHomepage();
          searchResultPage.verifyUserIsOnSearchResultPage();
          searchResultPage.verifyYourSearchProductPresentOnTheResultPage();


     }
}



