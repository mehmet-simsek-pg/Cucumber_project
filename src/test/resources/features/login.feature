Feature: Login Functionality

  Scenario: Login with valid data
    When Navigate to the webpage
    Then Enter username and password
    Then Click login button
    Then Verify Home page opened

  Scenario: Unsuccessfully Login with invalid credentials
    When Navigate to the webpage
    Then Enter invalid username and password
    Then Click login button
    Then Verify error message
