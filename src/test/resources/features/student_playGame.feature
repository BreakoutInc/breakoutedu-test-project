Feature: Student play game


  Scenario: Student plays LOTD game successfully
    Given student is on the Home Page
    When student clicks LOTD game banner
    And clicks on a lock
    And clicks on Combination Bar
    And enters valid combination
    Then verifies Congratulation! message is displayed




  Scenario: Student plays draft game successfully
    Given student is on the Home Page
    When student clicks My Games module
    And clicks on a game name
    And clicks on a lock
    And clicks on Combination Bar
    And enters valid combination
    Then verifies Congratulation! message is displayed
