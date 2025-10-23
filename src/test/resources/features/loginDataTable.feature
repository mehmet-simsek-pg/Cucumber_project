Feature: Login with Datatable

  Scenario: Login with multiple user credentials
    Given User is on login page
    Then User enters credentials
      | username        | password     |
      | standard_user   | secret_sauce |
      | locked_out_user | secret_sauce |
      | problem_user    | secret_sauce |