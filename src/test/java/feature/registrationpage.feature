Feature: Registration
  @regression
  Scenario: As a user, i want to register successfully
    Given I am on register page
    When I enter user registration details
    Then I should be able to register successfully
