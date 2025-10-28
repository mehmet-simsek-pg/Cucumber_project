Feature: Patient negative tests

  Background:
    When Navigate to the webpage
    Then Enter username and password
    Then Click login button
    Then Verify Home page opened

  @Regression
  Scenario: Create a patient with no firstname
    Then Click add patient button
    Then Enter lastname
    Then Select gender
    Then Enter birthday
    Then Click register patient button

  @Regression
    Scenario: Create a patient with no lastname
      Then Click add patient button
      Then Enter firstname
      Then Select gender
      Then Enter birthday
      Then Click register patient button