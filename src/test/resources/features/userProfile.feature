Feature: User Profile

  Background:
    Given Navigate to register page

  Scenario Outline: Create a new user
    When Enter user info username "<username>" and email "<email>"
    And Fill the additional details
      | field       | value         |
      | country     | <country>     |
      | city        | <city>        |
      | phoneNumber | <phoneNumber> |
    Then Verify profile created

    Examples:
      | username | email             | country | city        | phoneNumber   |
      | user1    | user1@example.com | Turkey  | Istanbul    | +901231313123 |
      | user2    | user2@example.com | Germany | Duesseldorf | +491234343434 |
