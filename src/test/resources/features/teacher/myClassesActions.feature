Feature: Teacher My Classes page actions

  Background:
    Given Teacher is on the Home Page
    When teacher clicks on My Classes

  Scenario: Teacher edit class name
    And clicks on more btn (ellipsis)
    And clicks on Edit Class Name btn
    And provides new class name and clicks Save btn
    Then verifies class name was updated

  Scenario: Teacher attempts to edit class name with short title (under 3 char)
    And clicks on more btn (ellipsis)
    And clicks on Edit Class Name btn
    And provides title under three characters and clicks Save btn
    Then verifies error message class title is too short is displayed

  Scenario: Teacher shuffle class code
    And clicks on more btn (ellipsis)
    And clicks on Shuffle Class code
    And verifies class code was shuffled

  Scenario: Teacher archive class
    And clicks on more btn (ellipsis)
    And clicks on Archive Class btn
    And clicks Yes on the appeared window
    Then verifies class was archived

  Scenario: Teacher delete class
    And clicks on more btn (ellipsis)
    And clicks on Delete Class btn
    And clicks Yes on the appeared window
    Then verifies class was archived

  Scenario: Teacher Manage Class
    And clicks on Manage class button
    Then verifies class details page is displayed

  Scenario: Teacher navigate to Roster from My Classes
    And clicks on number of students on class card
    Then verifies Roster page is displayed

  Scenario: Teacher navigate to Submitted Game from My Classes
    And clicks on number of awaiting review games on class card
    Then verifies Submitted Games page is displayed

  Scenario: Teacher navigate to Archive Classes
    And clicks on View Archive btn
    Then verifies Archived Classes page is displayed


