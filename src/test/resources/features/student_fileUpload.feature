Feature: Student uploads file as lock clue when creating a game

  Background:
    Given student is on the Home Page
    When student clicks My Games module
    And clicks Create a Game
    And selects class and clicks create game button

  @done
  Scenario:Student upload image successfully - Single lock
    And selects game type
    And provides valid game title and clicks next
    And selects Image lock type
    And uploads image
    Then verifies image was uploaded

    @done
    Scenario: Student tries to upload image with unsupported media type - Single lock
    And selects game type
    And provides valid game title and clicks next
    And selects Image lock type
    And uploads image with invalid media type
    And clicks Save as draft
    Then verifies error message is displayed

     @done
     Scenario: Student tries to upload image with too big size - Single lock
      And selects game type
      And provides valid game title and clicks next
       And selects Image lock type
      And uploads large image as a lock clue
      Then verifies the please insert less than or equal to five mb alert is displayed

## Multi-lock

  Scenario Outline:Student upload image successfully - Multi-lock
    And selects "<game type>"
    And provides valid game title and clicks next
    And clicks Add New Lock button
    And creates lock with image clue
    And selects Image lock type
    And uploads image
    Then verifies image was uploaded
    Examples:
      |game type|
      |Non-sequential game|
      |Sequential game|


  Scenario Outline: Student tries to upload image with unsupported media type - Multi-lock
    And selects "<game type>"
    And provides valid game title and clicks next
    And creates lock with custom image type - wrong media type
    And clicks Save as draft
    Then verifies error message is displayed
    Examples:
      |game type|
      |Non-sequential game|
      |Sequential game|

  Scenario Outline: Student tries to upload image with too big size - Multi-lock
    And selects "<game type>"
    And provides valid game title and clicks next
    And creates lock with custom image type - large
    Then verifies the please insert less than or equal to five mb alert is displayed
    Examples:
      |game type|
      |Non-sequential game|
      |Sequential game|