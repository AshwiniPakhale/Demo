Feature: It contains TCs releted to Actitme Task creation page

  Scenario Outline: Create new task "<Flow>"
    Given user is on actitime login page for task creation
    And user enters username as "<username>" in the username field
    And user enters password as "<password>" in the password field
    And user should click on login button
    When click on task tab
    And click on add new button
    And select new tasks
    And select project from project dropdown
    And enter task name as "<taskName>"
    And click on create Tasks button
    Then user should be able to see the created task on page
    And close the actitime application browser

    Examples: 
      | Flow     | username | password | taskName       |
      | Positive | admin    | manager  | 1Seleniun       |
      | Positive | admin    | manager  | 1WebDevelopment |
      | Positive | admin    | admin    | 1Cucumber       |
