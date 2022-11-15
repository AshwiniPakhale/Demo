Feature: Create lead in Vtiger application

  Background: 
    Given user already in login page
    And user login successfully with valid data
    And click on navigation bar
    And go to Marketing and select Leads

  @Smock @Regression
  Scenario Outline: Create new lead with name as "<firstName>"
    When click on Add Leads button and enter firstname as "<firstName>" ,last as "<lastName>" ,company as "<company>" and click on save button
    And click on All link
    Then varify lead is created with "<first>"
    And close the Vtiger application browser

    Examples: 
      | firstName | lastName | company            |
      | Smith     | Lee      | TestingForCucumber |
      | Jeff      | Mike     | SeleniumTesting    |

  @Smock @Regression
  Scenario: Delete all leads
    When click on select all leads checkbox
    And click on delete logo
    And user will get a popup to comfirm deletion, select Yes
    Then varify that all leads deleted
    And close the Vtiger application browser
