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




#    Examples:
#      |game type|
#      | Single lock|
#      | Non-sequential game |
#      |Sequential game|