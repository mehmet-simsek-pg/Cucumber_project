Feature: Login Functionality

  @ignore
  Scenario: Login with valid data
    When Navigate to the webpage
    Then Enter username and password
    Then Click login button
    Then Verify Home page opened

  @ignore
  Scenario: Unsuccessfully Login with invalid credentials
    When Navigate to the webpage
    Then Enter invalid username and password
    Then Click login button
    Then Verify error message

  Scenario Outline: Login with different credentials
    When Navigate to the webpage
    Then Enter username "<username>" and password "<password>"
    Then Click login button
    Then Verify result "<result>"

    Examples:
      | username | password |   result        |
      | admin    | Admin123 |   home page     |
      | admin    | wrongPass|   error message |
