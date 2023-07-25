Feature: add/remove products to caparison page to compare
  Background:
    Given the user must be on the Home Page

    @Test
    Scenario: Verify if a user not logged in can add products to compare - multiple products view
      Given the user identified "Radiant Tee" as their product of interest
      When the user hovers over "Radiant Tee" and clicks the Add to Compare button
      Then a confirm message, "You added product Radiant Tee to the comparison list." should appear
      And the "Radiant Tee" should be added in the Compare Products screen

  Scenario: Verify if a user not logged in can add products to compare - multiple products view
    Given the user identified "Breathe-Easy Tank" as their product of interest
    When the user goes and hovers over "Breathe-Easy Tank" and clicks the Add to Compare button
    Then a confirm message, "You added product Breathe-Easy Tank to the comparison list." should appear
    And the "Breathe-Easy Tank" should be added in the Compare Products screen

  Scenario: Verify if a user not logged in can add products to compare - multiple products view
    Given the user identified "Argus All-Weather Tank" as their product of interest
    When the user hovers over "Argus All-Weather Tank" and clicks the Add to Compare button
    Then a confirm message, "You added product Argus All-Weather Tank to the comparison list." should appear
    And the "Argus All-Weather Tank" should be added in the Compare Products screen
    Then remove "Argus All-Weather Tank" from Compare products screen

  Scenario: Verify if a user not logged in can add products to compare - multiple products view
    Given the user identified "Hero Hoodie" as their product of interest
    When the user hovers over "Hero Hoodie" and clicks the Add to Compare button
    Then a confirm message, "You added product Hero Hoodie to the comparison list." should appear
    And the "Hero Hoodie" should be added in the Compare Products screen