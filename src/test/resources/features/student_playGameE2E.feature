Feature: Student able to play game successfully

  Background:
    Given student is on the Home Page
    When student clicks My Games module
    And clicks Create a Game
    And selects class and clicks create game title

   @done
  Scenario: Student plays single-lock game successfully
    And selects game type
    And provides valid game title and clicks next
    And inputs Lock Story text
    And selects Text lock clue
    And inputs lock clue text
    And selects lock clue combination
    And clicks Save as draft
    Then verifies the game has been created



  Scenario Outline: Student plays multi-lock game successfully
    And selects "<game type>"
    And provides valid game title and clicks next
    And inputs Lock Story text for multi-lock
    And creates color lock
    And clicks Add Another Lock button
    And creates directional lock
    And clicks Save as draft
    Then verifies the game has been created
    Examples:
      |game type|
      |Non-sequential game|
      |Sequential game|



