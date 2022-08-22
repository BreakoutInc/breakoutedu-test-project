Feature: Teacher able to navigate to a different secondary pages (not main modules)

  Background:
    Given Teacher is on the Home Page

  @teamcity
  Scenario: Teacher navigates to Game Details page
    When teacher clicks on My Games
    And clicks Details button
    Then verifies the Game Details page is displayed

  @teamcity
  Scenario: Teacher navigates to Game Search Details page
    When teacher clicks on recommended game image
    Then verifies Game Search Details page is displayed

  @teacherUI
  Scenario: Teacher navigates to Help Desk page
    When teacher clicks on Help button
    Then Help Desk is displayed