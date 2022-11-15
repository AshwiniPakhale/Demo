Feature: SwagLab Login functionality  # It is contains TCs related to swaglab Login page

  @Smoke @Regression
  Scenario: Test The Swaglab Application login functinality with diffrent user
    Given user is on swaglab login page
    And user enters the following inputs
      | standard_user   | secret_sauce |
      | locked_out_user | secret_sauce |
    And clicks on login button
    Then user should be login
    And close the browser
    
  # Scenario: Test The Swaglab Application login functinality with diffrent user
   #Given User open the browser and open the swaglab
   #When user enters username and password
   #And clicks on login button
   #Then user should be login
   #And close the browser

  