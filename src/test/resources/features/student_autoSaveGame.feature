Feature: Student auto save game


  Background:
   Given student is on the Home Page
   When student clicks My Games module
   And clicks Create a Game
   And selects class and clicks create game button
   And selects game type
   And provides valid game title and clicks next


  Scenario: Student can auto-save game - Single lock
    And enables auto save
    And inputs Lock Story text
    And selects Text lock clue
    And inputs lock clue text
    And selects lock clue combination
    And clicks Save as draft
    And student clicks My Games module
    And clicks on a created game with auto save enabled
    Then verifies game was autosaved successfully


