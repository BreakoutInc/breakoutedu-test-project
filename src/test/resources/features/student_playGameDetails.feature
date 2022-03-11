Feature: Student able to select various elements while creating game

  Background:
    Given student is on the Home Page
    When student clicks My Games module and clicks Create a Game
    And selects class and clicks create game title


  Scenario Outline: Student able to select all lock types for single-lock game
    And selects game type
    And provides valid game title and clicks next
    Then verifies all "<lock types>" can be selected
    Examples:
      |lock types|
      |text lock|
      |number lock|
      |directional lock|
      |shape lock|
      |color lock |


  Scenario Outline: Student able to select all lock types for multi-lock game
    And selects "<game type>"
    Examples:
      |game type|
      |Non-sequential game|
      |Sequential game    |
    And provides valid game title and clicks next
    And clicks Add New Lock button
    Then verifies all "<lock types>" can be selected
    Examples:
      |lock types|
      |text lock|
      |number lock|
      |directional lock|
      |shape lock|
      |color lock |


   Scenario Outline: Student tries to create a game with invalid game title
    And selects "<game type>"
    Examples:
      |game type|
      |Single lock|
      |Non-Sequential Game |
      |Sequential Game|
    And provides title under three characters
    Then verifies The title must be at least 3 characters alert is displayed


     And selects "<game type>"
     And provides existing game title and clicks next
     Then verifies Title already has been taken alert is displayed
     Examples:
       |game type|
       |Single lock|
       |Non-sequential game |
       |Sequential game|