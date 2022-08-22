Feature: Teacher create class feature

  Background:
    Given Teacher is on the Home Page

  Scenario: Teacher create class from Home page
    When teacher clicks on Create Class btn
    And provides class title and clicks Save
    Then verifies class details page is displayed

    Scenario: Teacher create class from My Classes - Create Class btn
      When teacher clicks on My Classes
      And clicks on create class btn
      And provides class title and clicks Save
      Then verifies class was created successfully

  Scenario: Teacher create class from My Classes - empty class card
    When teacher clicks on My Classes
    And clicks on empty class card
    And provides class title and clicks Save
    Then verifies class was created successfully

