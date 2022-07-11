Feature: LOTD

Background:
  Given student is on the Home Page

  Scenario: Student plays LOTD game successfully
#    Given teacher has a class
    When student clicks LOTD game banner
#    And clicks on a lock
    And plays game
#    And clicks on Combination Bar
#    And enters valid combination
    Then verifies Congratulation! message is displayed