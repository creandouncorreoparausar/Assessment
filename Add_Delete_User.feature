Feature: Orange HRM - Add and Delete User

  Scenario: Validate Successful Add and Delete Users
    Given I navigate to website
    When I enter Admin as username
    And I enter admin123 as password
    And I click on the login button
    And I click on Admin tab on the left side menu
    And I get the number of records found
    And I click on add button
    And I fill the required data
    And I click on save button
    And I verify that the number of records increased by 1
    And I search with the username for the new user
    And I delete the new user
    Then I verify that the number of records decreased by 1
