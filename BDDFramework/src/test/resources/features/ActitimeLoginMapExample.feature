Feature: Actitime Login Functionality Test Cases

  Scenario: Test the login functionality for actitime
    Given user in on actitime login page
    And user enters following inputs
      | Username | Password |
      | admin    | manager  |
    And user click on login button
    Then user should be login successfully
    And user should logout and close the browser

  
