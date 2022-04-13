Feature: Student able to select various elements while creating game

  Background:
    Given student is on the Home Page
    When student clicks My Games module
    And clicks Create a Game
    And selects class and clicks create game button

  @done
  Scenario Outline: Student able to select all lock types for single-lock game
    And selects game type
    And provides valid game title and clicks next
    Then verifies all "<lock types>" can be selected
    Examples:
      |lock types|
      |text|
      |number|
      |directional|
      |shape|
      |color|

  @done
  Scenario Outline: Student able to select all lock types for Non-Seq game
    And selects Non-Sequential game type
    And provides valid game title and clicks next
    And clicks Add New Lock button
    Then verifies all "<lock types>" can be selected
    Examples:
      |lock types|
      |text|
      |number|
      |directional|
      |shape|
      |color|
#    Examples:
#      |game type|
#      |Non-sequential game|
#      |Sequential game    |


  @done
  Scenario Outline: Student tries to create a game with invalid game title
    And selects "<game type>"
    And provides title under three characters and clicks next
    Then verifies The title must be at least 3 characters alert is displayed
    Examples:
      |game type|
      |Single lock|
      |Non-sequential game|
      |Sequential game|


  @done
  Scenario Outline: Student tries to create a game with existing game title
    And selects "<game type>"
    And provides existing game title and clicks next
    Then verifies Title already has been taken alert is displayed
    Examples:
      |game type|
      |Single lock|
      |Non-sequential game|
      |Sequential game|

  @done
  Scenario: Student tries to submit a game with no lock clue text - Single lock
    And selects game type
    And provides valid game title and clicks next
    And selects Text lock clue
    And selects lock clue combination
    And clicks Save and Play
    Then verifies Please provide lock clue text alert is displayed


   Scenario: Student able to switch types of Multi Lock games
    Given student is on the Home Page
    And selects Non-Sequential game type
    And provides valid game title and clicks next
    And he clicks on another game type to switch
    And verifies game type was switched