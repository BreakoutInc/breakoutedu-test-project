Feature: Student able to play game successfully

@test
  Scenario Outline: Student plays Single lock game successfully
    Given student is on the Home Page
    When student clicks My Games module and clicks Create a Game
    And selects class and clicks create game title
    And selects "<game type>"
    And provides valid game title and clicks next
    And inputs Lock Story text
    And selects Text lock clue
    And inputs lock clue text
    And selects lock clue combination
    And clicks Save as draft
    Then verifies the game has been created
    Examples:
      |game type|
      |Single lock|


  Scenario Outline: Student plays Single lock game successfully
    Given student is on the Home Page
    When student clicks My Games module and clicks Create a Game
    And selects class and clicks create game title
    And selects "<game type>"
    And provides valid game title and clicks next
    And inputs Lock Story text
    And selects Text lock clue
    And inputs lock clue text
    And selects lock clue combination
    And clicks Save as draft
    Then verifies the game has been created
    Examples:
      |game type|
      |Non-sequential game|
      |Sequential game|