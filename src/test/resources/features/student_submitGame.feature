Feature: Student submit game

   @done
  Scenario: Student can submit game successfully (first game from Created column )
    Given student is on the Home Page
    When student clicks My Games module
    And clicks on Submit to Class button
    And adds comment in popped up window
    And clicks Submit button
    Then verifies the game was submitted

   @done
    Scenario: Student submits game without comment
      Given student is on the Home Page
      When student clicks My Games module
      And clicks on Submit to Class button
      And clicks Submit button
      Then verifies message Error : Field is required is displayed