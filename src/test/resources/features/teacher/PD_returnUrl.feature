Feature: Teacher Return Url feature


  #This tests can't be executed on Prod env since the flow of navigation is different there
  Background:
    Given teacher is on the Login Page

  @teamcity
  Scenario: Teacher Return Url feature with NO returnUrl param - My Account
    When teacher goes to My Account url path
    Then LogIn page is displayed
    And teacher logs into account
    Then My Account page is displayed

  @teamcity
  Scenario: Teacher Return Url feature with NO returnUrl param - My Classes
    When teacher goes to My Classes url path
    Then LogIn page is displayed
    And teacher logs into account
    Then My Classes page is displayed

  @teamcity
  Scenario: Teacher Return Url feature with NO returnUrl param - My Games
    When teacher goes to My Games url path
    Then LogIn page is displayed
    And teacher logs into account
    Then My Games page is displayed

  @teamcity
  Scenario: Teacher Return Url feature with NO returnUrl param - Store
    When teacher goes to Store url path
    Then LogIn page is displayed
    And teacher logs into account
    Then Shop page is displayed

  @teamcity
  Scenario: Teacher Return Url feature with NO returnUrl param - Change Password
    When teacher goes to Change Password url path
    Then LogIn page is displayed
    And teacher logs into account
    Then Change Password page is displayed


  @on_hold
  Scenario: Teacher Return Url feature with returnUrl param - My Account
    When teacher goes to My Account url path with returnUrl param
    Then LogIn page is displayed
    And teacher logs into account
    Then My Account page is displayed

  @on_hold
  Scenario: Teacher Return Url feature with returnUrl param - My Classes
    When teacher goes to My Classes url path with returnUrl param
    Then LogIn page is displayed
    And teacher logs into account
    Then My Classes page is displayed

  @on_hold
  Scenario: Teacher Return Url feature with returnUrl param - My Games
    When teacher goes to My Games url path with returnUrl param
    Then LogIn page is displayed
    And teacher logs into account
    Then My Games page is displayed

  @on_hold
  Scenario: Teacher Return Url feature with returnUrl param - Store
    When teacher goes to Store url path with returnUrl param
    Then LogIn page is displayed
    And teacher logs into account
    Then Shop page is displayed


  @on_hold
  Scenario: Teacher Return Url feature with returnUrl param - Change Password
    When teacher goes to Change Password url path with returnUrl param
    Then LogIn page is displayed
    And teacher logs into account
    Then Change Password page is displayed


