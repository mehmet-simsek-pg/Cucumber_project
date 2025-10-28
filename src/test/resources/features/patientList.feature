Feature: Patient

  @Regression
  Scenario Outline: Patient List
    When Navigate to the webpage
    Then Enter username and password
    Then Click login button
    Then Verify Home page opened

    Then Click add patient button
    Then Enter firstname "<firstname>" and lastname "<lastname>"
    Then Select gender "<number>"
    Then Enter birthday year "<year>" month "<month>"
    Then Click register patient button

    Then Click patient list button
    Then Click all list button
    Then Verify patient name "<patientName>"

    Examples:
      | firstname | lastname | year | month | number | patientName |
      | test      | user     | 14   | 12    | 1      | test user   |