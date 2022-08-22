Feature: Roaster page actions

  Background:
    Given Teacher is on the Home Page
    When teacher clicks on My Games
    And clicks on Roster btn


  Scenario: Teacher can sort students by name
    And clicks on sort name icon
    Then verifies names column was sorted

  Scenario: Teacher can sort students by username
    And clicks sort username icon
    Then verifies usernames column was sorted

  Scenario: Teacher can sort student by games completed
    And clicks on games completed sort icon
    Then verifies games completed column was sorted

  Scenario: Teacher can sort students by awaiting review
    And clicks on awaiting review sort icon
    Then verifies awaiting review column was updated

  Scenario: Teacher can search for students
    And inputs student name in search box
    Then verifies search result was generated

  Scenario: Teacher edit student name
    And clicks on more button-ellipsis-Roster
    And clicks on Edit Name btn
    And provides new student name and clicks Save
    Then verifies name was edited successfully

  Scenario: Teacher reset student password
    And clicks on more button-ellipsis-Roster
    And clicks on Reset Password btn
    And provides new student password and clicks Save
    Then verifies password was updated successfully

  Scenario: Teacher removes student from the class
    And clicks on more button-ellipsis-Roster
    And clicks on Remove Student btn
    And clicks Yes on the appeared window
    Then verifies student was removed from the class





