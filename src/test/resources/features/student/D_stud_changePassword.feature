Feature: Student change password

  Background:
    Given student is on the Home Page
    When student clicks on account icon
    And clicks on Change password button

  @teamcity
  Scenario: Student change password successfully
    And fills up the form
    And clicks on Save Password
    Then verifies You have successfully changed your password window is displayed

    @teamcity
    Scenario: Student attempts to save password with not matched confirmation password
      And fills up the form with not matched confirmation password
      And clicks on Save Password
      Then verifies confirm password does not matched alert is displayed

