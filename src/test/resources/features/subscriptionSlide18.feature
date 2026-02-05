@SubscriptionSlide18
Feature:
  Subscription Slide 18 - Step 11 Onboarding Process

  Background: User completes onboarding process until step 10

Scenario: Title is displayed
  Given User is on step 11 onboarding process
    When User clicks on "Complete" after entering the required medication details
    Then "Choose Your Transformation Journey" header should be displayed on the page

  Scenario:Verify Page Header Section title text inside Free Plan title
    Given User is on step 11 onboarding process
    When User clicks on "Complete" after entering the required medication details
    Then "All plans include personalization based on your menstrual cycle phases for optimal results." sub-text header is visible on the page

  Scenario:Verify Page Header Section Sub text for section title
    Given User is on step 11 onboarding process
    When User clicks on "Complete" after entering the required medication details
    Then There should be exactly 3 subscription plan tiles displayed on the page
  Scenario:Verify Total number of Sections Header inside the section
    Given User is on step 11 onboarding process
    When User clicks on "Complete" after entering the required medication details
    Then Three subscription plan tiles should be displayed on the page

  Scenario:Verify Free Plan tile Section title text inside Free Plan title
    Given User is on step 11 onboarding process
    When User clicks on "Complete" after entering the required medication details
    Then "Free Plan - 7 Days Trial" section tile is displayed inside Free plan tile on the page

  Scenario:Verify Free Plan tile Sub text for section title
    Given User is on step 11 onboarding process
    When User clicks on "Complete" after entering the required medication details
    Then "AI-generated 7-day meal plan,workouts and yoga personalized to your menstrual cycle - absolutely free!" section title is displayed inside Free plan slide

  Scenario:Verify Free Plan tile Header inside the section
    Given User is on step 11 onboarding process
    When User clicks on "Complete" after entering the required medication details
    Then "Free" header is visible inside Free plan tile on the page

  Scenario:Verify Free Plan tile Subtext under header
    Given User is on step 11 onboarding process
    When User clicks on "Complete" after entering the required medication details
    Then "7 days access" subtext under header is visible inside Free plan tile on the page

  Scenario Outline:Verify Subscribe Now button for Free plan tile
    Given User is on step 11 onboarding process
    When User clicks on "Complete" after entering the required medication details
    Then Subscribe Now button should be visible

  Scenario:Verify Checklist for Free plan tile
    Given User is on step 11 onboarding process
    When User clicks on "Complete" after entering the required medication details
    Then All specified checklist "<list>" should be visible inside Free plan
    Examples:
      | list|
        | Cycle-based diet plan (adjusted to your current phase) |
        |  Daily workouts & yoga |
        |  AI tips for stress relief |
    |  Blood report analysis + expert recommendations" lines preceeded with checkmark are visible |

  Scenario:Verify State of Subscribe now button
    Given User is on step 11 onboarding process
    When User clicks on "Complete" after entering the required medication details
  #  Then Subscribe Now button should be in disabled state - Subscribe now button is not displayed as it is a free plan



#  Scenario:Verify Most Popular badge
#  Scenario:Verify Subheader text inside Monthly Plan tile
#  Scenario:Verify Sub text for subheader
#  Scenario:Verify Header inside the section
#  Scenario:Verify Subtext under header
#  Scenario:Verify Checklist for Monthly plan tile
#  Scenario:Verify Subscribe Now button for Monthly plan tile
#  Scenario:Verify State of Subscribe now button
#  Scenario:
#  Scenario:
#  Scenario:
#  Scenario:
#  Scenario:
#  Scenario:
#  Scenario:
#  Scenario:
#  Scenario:
#  Scenario:
#  Scenario:
#  Scenario:
#  Scenario:
#  Scenario:
#  Scenario:
#  Scenario:




















