@spartan
Feature: Add new spartan

  Scenario: Add new spartan on UI and Compare with Confirmation page
    Given User is on spartan home page
    When User goes to Web Data page
    And clicks on add spartan
    And enters following data and submits:
      | name | Test Test |
      | gender | Male |
      | phone | 12341231234 |
    Then success message should be displayed
    And data on confirmation page must be same