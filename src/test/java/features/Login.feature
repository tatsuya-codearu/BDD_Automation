Feature:Login
  Background:
    Given The use must be on the Home Page

    Scenario: Verify if user is Logged in
      Given The <signin> text is visible
      Then the user is not logged in


    Scenario: Verify if user is logged in
      Given the <signin> text is visible
      When the user clicks <signin> button
      And enters <username> and <password>
      Then clicks <btnSignin>