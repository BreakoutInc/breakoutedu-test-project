Feature: Student can open a game from different locations

   Background:
    Given student is on the Home Page

   Scenario: Student opens a created game from My Games
    When student clicks My Games module
    And clicks on a game name
    Then verifies game was opened

  Scenario: Student opens an assigned game on the Home Page
    When student clicks on game asset from the New Assignments
    Then verifies game was opened

    Scenario: Student can open game from Notifications
      When student clicks Notifications
      And selects a notification about assigned game
      Then verifies game was opened


