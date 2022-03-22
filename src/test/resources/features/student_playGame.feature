Feature: Student play game

  Background:
    Given student is on the Home Page

  Scenario: Student plays LOTD game successfully
    Given teacher has a class
    When student clicks LOTD game banner
    And clicks on a lock
    And clicks on Combination Bar
    And enters valid combination
    Then verifies Congratulation! message is displayed




  Scenario: Student plays draft game successfully E2E
    When student clicks My Games module
    And clicks on a game name
    And plays game
    Then verifies Congratulation! message is displayed
