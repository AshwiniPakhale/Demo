
Feature: Scenarioes for Actitlime Login functionality.
  
  Scenario: Test the login functionality of Actitime with valid credentials
    Given Open the browser and Enter correct Url
    When user enter correct username
    And correct password and click on login button
    Then user should login succesfully
    And user logout and close the browser

 