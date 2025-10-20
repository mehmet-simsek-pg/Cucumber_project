Feature: Login Functionality

  Scenario: Login with valid data
    When Navigate to the webpage
    Then Enter username and password
    Then Click login button
    Then Verify Home page opened
