package org.example;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;



public class MyStepdefs {

    HomePage homePage = new HomePage();

    RegistrationPage registrationPage = new RegistrationPage();

    RegisterResultPage registerResultPage = new RegisterResultPage();


// ========================================this method for registration page ===========================================

    @Given("I am on register page")
    public void i_am_on_register_page() {
        // Write code here that turns the phrase above into concrete actions
        homePage.verifyRegisterButtonPresent();
        homePage.clickOnRegisterButton();
    }
    @When("I enter user registration details")
    public void i_enter_user_registration_details() {
        // Write code here that turns the phrase above into concrete actions
        registrationPage.verifyUserIsOnRegisterPage();
        registrationPage.register();

    }
    @Then("I should be able to register successfully")
    public void i_should_be_able_to_register_successfully() {
        // Write code here that turns the phrase above into concrete actions
       registerResultPage.verifyUserIsAbleToSeeRegisteredMessage();
    }

//========================================= this method for category feature ===========================================

    @When("I click on {string} link")
    public void iClickOnLink(String category_name) {
        homePage.clickOnCategoryPage(category_name);
    }

    @Then("I should able to navigate to related {string}")
    public void iShouldAbleToNavigateToRelated(String category_link) {
        Utils.assertCurrentURL(category_link);
    }
}
