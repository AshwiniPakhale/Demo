Feature: Actitime Login Functionality 
   @Smoke @Regression
  Scenario: Test the Actitime login functionality 
    Given user is actitme login page
    And user enters given inputs
      | Username | Password |
      | admin    | manager  |
    And user click login button
    Then user should login successfully
    And user should logout and after close the browser