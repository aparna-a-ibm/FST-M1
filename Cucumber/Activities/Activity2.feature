Feature: Login Test

  @activity2
  Scenario: Testing Login
    Given User is on Login page
    When User enters username and password
    Then Read the page title and confirmation message
    And  Close the Browser