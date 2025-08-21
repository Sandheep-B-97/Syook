Feature: Login functionality for Bugbash app

  @Positive
  Scenario: Successful login with valid email and password
    Given I open the Bugbash login page
    When I enter email as "valid@test.com" and password as "validPassword"
    And I click on login button
    Then I should see the dashboard

  @Negative
  Scenario: Failed login with invalid email
    Given I open the Bugbash login page
    When I enter email as "wrong@test.com" and password as "wrongpass"
    And I click on login button
    Then I should see an error message "Please enter a valid email address"
