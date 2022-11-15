Feature: OrangeHRM Login Functionality

  @Smoke @SpecificHook
  Scenario: Test the login functionality of OrnageHRM with valid credentials
    Given User open the browser and open the application
    When User enters the username and password
    And User click on the login button
    Then User should login successfully
    And User logout and close the browser

  #Scenario: Test the login functionality of OrnageHRM using excel reading
   # Given application url is on "LoginDetails" sheet and row no is 1
    #And login credentials is on "LoginDetails" sheet and row no is 1
    #And user open the browser and application as per sheet data
    #When user enters the username and password as per sheet data
    #And User click on the login button
    #Then User should login successfully
    #And User logout and close the browser
