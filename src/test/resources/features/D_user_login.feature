
Feature: Teacher login

  @done
  Scenario Outline: User login successfully
    Given user is on Login Page
    When user provides valid "<email>" and "<password>"
    And clicks Sign In button
    Then verifies logged in successfully
    Examples:
      |email| password |
      |yuliia+teacher1@breakoutedu.com|yuliiawork22|
      |yuliia+teacher2@breakoutedu.com|yuliiawork22|
      |yuliia+schooladmin@breakoutedu.com|yuliiawork22|
      |yuliia+schooladmin2@breakoutedu.com|yuliiawork22|
      |yuliia+districtadmin@breakoutedu.com|yuliiawork22|
      |yuliia+districtadmin2@breakoutedu.com|yuliiawork22|

    @done
  Scenario: User tries to login with invalid credentials
    Given user is on Login Page
    When user provides invalid email and password
    And clicks Sign In button
    Then verifies Invalid credentials window is displayed