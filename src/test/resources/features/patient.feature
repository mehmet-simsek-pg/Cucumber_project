Feature: Patient functionality

  Background:
    When Navigate to the webpage
    Then Enter username and password
    Then Click login button
    Then Verify Home page opened

  Scenario Outline: Create a new patient
    Then Click add patient button
    Then Enter firstname "<firstname>" and lastname "<lastname>"
    Then Select gender "<number>"
    Then Enter birthday "<birthday>"
    Then Click register patient button

    Examples:
      | firstname | lastname | birthday| number|
      |test       |user      |12.03.1990|1     |
      | tester    |users     | 23.02.1980|2    |