Feature: Student login with Google account



  Scenario: Student Login with Google Classroom successfully
    Given student is on the Student Login Page
    When student clicks on Log In With Google Classroom
    ##And clicks on Use Another Account
    And enters valid Classroom Email and clicks Next
   ## And enters valid Classroom password and clicks Next
    Then verifies Student Home Page in displayed