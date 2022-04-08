Feature: Student play game

  Background:
    Given student is on the Home Page
    When student clicks My Games module

  Scenario: Student plays draft game successfully E2E
    And clicks on a game name
    And plays game
    Then verifies Congratulation! message is displayed

    Scenario: Student can close the game
    And clicks on a game name
    And clicks on a close game icon in a left corner
    Then verifies the game was exited


  Scenario: Student tries to play a game that wasn't auto saved (no locks)
    And clicks on a created game with auto save disabled
    Then verifies No locks found message is displayed

    Scenario: Student able to switch locks when playing Non-Seq game
      And clicks on a Non Seq game name
      And clicks on a few locks
      Then verifies the locks very switched successfully

      Scenario: Student enters invalid lock combination
        And clicks on a game name
        And clicks on a lock at the top
        And clicks on Combination Bar
        And enters invalid combination
        Then verifies Nope, that’s not it. Try Again! message is displayed