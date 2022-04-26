Feature: Student notifications



  @on_hold
  Scenario: Student can scroll Notifications
    Given student is on the Home Page
    When student clicks Notifications
    And scrolls notifications down
    Then verifies the notifications was scrolled down

    @on_hold
  Scenario: Student can receive new Notifications
    Given teacher assigned game to a class
    Given student is on the Home Page
    When student clicks Notifications
    Then verifies new notifications is displayed


  Scenario: Student can close Notifications
    Given student is on the Home Page
    When student clicks Notifications
    And click on close notifications icon
    Then verifies notifications was closed

  Scenario: Student can open Notification about game revision
    Given student is on the Home Page
    When student clicks Notifications
    And clicks on notification about game revision
    Then verifies the Game Details page for that game is opened

