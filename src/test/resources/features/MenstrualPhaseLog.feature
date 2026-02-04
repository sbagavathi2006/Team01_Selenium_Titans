Feature: Menstrual Cycle Tracker - UI Verification

  Background: 
    Given User clicks Activity Insights button after logged in

  Scenario Outline: Her Balance Dashboard with the Activity Insights submenu
    When User clicks on Menstrual Phase Logs
    Then User is able to see <ExpectedOutcome>

    Examples: 
      | ExpectedOutcome                                                                                                         |
      | 5 sections should be visible(Current Cycle Status, Upcoming Phases, Recommended Activities, Nutrtion Tips, Next Period) |
      | "Update Cycle Information" button should be visible                                                                     |
      |"Back to Dashboard" button is visible|
      |"Add Period Log" button should be visible |
   #   |"Cycle Overview" tab should be visible |