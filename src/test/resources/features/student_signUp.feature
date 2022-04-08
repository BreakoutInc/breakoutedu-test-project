Feature: Student SignUp with BE

  Background:
    Given student is on the Home Page
    And clicks on signup here
    And clicks on Signup With Breakout EDU
    And types class code and clicks Next

  Scenario: Student creates account successfully
    And provides valid username
    And creates a password and clicks Next
    Then verifies account was created


  Scenario: Student tries to create account with invalid username
    And provides invalid username
    Then verifies Username must be between 6 and 10 characters message is displayed


  Scenario: Student tries to create an account with not match password
    And provides valid username
    And provides not matched password
    Then verifies Password are not matched alert is displayed
