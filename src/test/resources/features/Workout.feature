Feature: Workout Page UI verification

  Background: 
    Given User logged into the application

  Scenario: Verify the workout page title
    When user clicks workout button on navigation bar
    Then User should see page title as "Daily Personalized Workouts"

  ##Scenario: Verify the presence of "Back to Dashboard" text on the Workout page
  ##  When user clicks workout button on navigation bar
 ##   Then User should see the link Back to dashboard

 ##Scenario: Verify the presence of daily workout plan section
  ##  When user clicks workout button on navigation bar
  ##  Then User should see the "Daily Workout Plan" section
