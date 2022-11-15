
Feature: SwagLab Aplication Login and Create New Lead and Delete It
 
  Scenario: 1Test Login Functionality and Create new Lead
    Given user open browser and open application
    When user enter username and password 
    And click on login button
    And user should click on burgur manu
    And user should click on markeing optionn
    And user should click on lead option
    And user should create lead
    Then user should verify create lead and 
    And delete created lead
    And logout and close browser

 