Feature: Teacher Assigned Games page actions

  Background:
    Given Teacher is on the Home Page
    When teacher clicks on My Games
    And clicks on Assigned Games btn

  Scenario: Teacher can sort assigned games by game title
    And clicks on sort game title icon
    Then verifies game title column was sorted

  Scenario: Teacher can sort assigned games by complete percentage
    And clicks on sort completed percentage icon
    Then verifies complete percentage column was sorted

  Scenario: Teacher can sort assigned games by date assigned
    And clicks on sort date assigned icon
    Then verifies date assigned column was sorted

  Scenario: Teacher can play assigned game
    And clicks on assigned game image asset
    Then verifies game player is displayed


  Scenario: Teacher can view assigned game results
    And clicks on Results btn
    Then verified assigned game results is displayed


  Scenario: Teacher can view game details page for assigned game
    And clicks on more button-ellipsis-AssignedGames
    And clicks on Results btn
    Then verifies the Game Details page is displayed

    Scenario: Teacher can remove assigned game
      And clicks on more button-ellipsis-AssignedGames
      And clicks on Remove Game btn
      Then verifies assigned game was removed

      Scenario: Teacher can search for assigned game
        And inputs game title in the search box
        Then verifies assigned game search result was generated




