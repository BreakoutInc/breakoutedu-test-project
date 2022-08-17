Feature: Teacher navigation to a different pages

  Background:
    Given Teacher is on the Home Page

  @teamcity
  Scenario: Teacher navigates to My Account page (using avatar icon)
    When teacher clicks on the avatar icon
    Then My Account page is displayed

  @teamcity
  Scenario: Teacher navigates to My Account page (using My Account button)
    When teacher clicks on the My Account button
    Then My Account page is displayed

  @teamcity
  Scenario: Teacher navigated to My Classes (from the siderail)
    When teacher clicks on My Classes
    Then My Classes page is displayed

  @teamcity
  Scenario: Teacher navigates to My Classes (from the Home Page)
    When teacher clicks on My Classes from the Home page
    Then My Classes page is displayed

  @teamcity
  Scenario: Teacher navigates to My Games (from the siderail)
    When teacher clicks on My Games
    Then My Games page is displayed

  @teamcity
  Scenario: Teacher navigates to My Games (from the Home Page)
    When teacher clicks on My Games from the Home Page
    Then My Games page is displayed

  @teamcity
  Scenario: Teacher navigates to Shop
    When teacher clicks on Shop
    Then Shop page is displayed

