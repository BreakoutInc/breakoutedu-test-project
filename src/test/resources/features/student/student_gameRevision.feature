Feature: Student game submission process

  Background:
    Given student is on the Home Page
    When student clicks My Games module


     Scenario: Student can view a comment on a game that needs revision
       And clicks on View Comment on needs revision game
       Then verifies comment window was opened

    Scenario: Student can resubmit game that needs revision
      And clicks on a tree dots on needs revision game
      And clicks Resubmit button
      And inputs comment
      And clicks Submit button
      Then verifies the game was submitted

      Scenario: Student can Edit game that needs revision
        And clicks on a tree dots on needs revision game
        And clicks Edit button
        Then verifies game Edit Game page was opened

