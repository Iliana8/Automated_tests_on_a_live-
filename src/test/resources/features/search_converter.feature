
Feature: Google converter service

  Scenario: Converter service appears first in results
    Given I open Google
    When I search for "currency converter"
    Then The text "converter" should appear in results
