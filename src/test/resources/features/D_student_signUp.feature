Feature: Student SignUp with BE

  Background:
    Given student is on the Sign Up Page
    And clicks on signup here
    And clicks on Signup With Breakout EDU

    @done
  Scenario: Student creates account successfully
      And types class code and clicks Next
      And fills up personal info and clicks next
      And provides password and psw confirmation and next
      And clicks Create account button
      Then verifies account was created

    @done
  Scenario: Student tries to create account with invalid class code
    And provides invalid class code
    Then verifies This class code is invalid message is displayed

   @done
  Scenario: Student tries to create account with invalid username(too short)
    And types class code and clicks Next
    And provides invalid username and clicks next
    Then verifies Username must be between six and ten characters message is displayed

    @done
  Scenario: Student tries to create an account with not match password
    And types class code and clicks Next
    And fills up personal info and clicks next
    And provides not matched password
    Then verifies Password are not matched alert is displayed
