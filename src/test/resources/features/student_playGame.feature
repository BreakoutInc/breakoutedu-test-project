Feature: Student able to play game successfully

  Background:
    Given student is on the Home Page
    When student clicks My Games module and clicks Create a Game
    And selects class and clicks create game title


  Scenario: Student plays Single lock game successfully
    And selects game type
    And provides valid game title and clicks next
    And inputs Lock Story text
    And selects Text lock clue
    And inputs lock clue text
    And selects lock clue combination
    And clicks Save as draft
    Then verifies the game has been created


    @test
  Scenario Outline: Student plays Single lock game successfully
    And selects "<game type>"
    And provides valid game title and clicks next
    And inputs Lock Story text
    And selects new lock icon
#    And creates lock
#    And clicks Add Another Lock button
#    And creates lock
#    And clicks Save as draft
#    Then verifies the game has been created
    Examples:
      |game type|
      |Non-sequential game|
      |Sequential game|