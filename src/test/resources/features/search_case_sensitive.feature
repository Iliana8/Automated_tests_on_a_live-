
Feature: Check case sensitivity

  Scenario: Google should ignore uppercase/lowercase
    Given I open Google
    When I search for "Computer"
    Then Results should contain keyword "computer"
