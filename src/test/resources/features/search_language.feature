
Feature: Search in multiple languages

  Scenario Outline: Validate search works in different languages
    Given I open Google
    When I search for "<query>"
    Then Results should contain keyword "<expected>"

    Examples:
      | query      | expected |
      | calculator | calculator |
      | компьютер  | компьютер |
      | ordenador  | ordenador |
