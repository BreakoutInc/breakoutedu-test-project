@smoke @done
Feature: Student Login with Breakout account

  Background:
    Given student is on the Student Login Page
    When student clicks on Log In with Breakout EDU

  Scenario: Student Login successfully
    And enters valid Email and Password
    And clicks on Log In
    Then verifies Student Home Page in displayed

    Scenario: Student Login with invalid credentials
      And enters invalid email and password
      And clicks on Log In
      Then verifies Username or password is invalid message is displayed