
Feature: Google calculator

  Scenario: Calculator should appear when searching "calculator"
    Given I open Google
    When I search for "calculator"
    Then The service "Calculator" should be displayed
