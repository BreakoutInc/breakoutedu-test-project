Feature: Student able to delete a game

  @teamcity
  Scenario: Student delete game
    Given student is on the Home Page
    When student clicks My Games module
    And clicks on three dots icon
    And clicks on delete button
    And selects yes on popped up window
    Then verifies the game was delete