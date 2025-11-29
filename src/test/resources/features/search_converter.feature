
Feature: Google converter service

  Scenario: Converter service appears first in results
    Given I open Google
    When I search for "Google converter services"
    Then The service "Converter" should be displayed
