Feature: Menstrual Cycle Tracker UI Verification

  Background: 
    Given User clicks Activity Insights button after logged in
    When User clicks on Menstrual Phase Logs from dashboard

  Scenario Outline: UI elements should be visible on Menstrual Phase Logs page
    Then <ThenConditions>

    Examples: 
      | ThenConditions                                                     |
      | User is able to see five sections on the Menstrual Phase Logs page |
      | Update Cycle Information button should be visible                  |
      | Back to Dashboard button is visible                                |
      | Add Period Log button should be visible                            |
      | Cycle Overview tab should be visible                               |
      | Menstrual Calendar tab should be visible                           |
      | Period History tab should be visible                               |

  @CurrentCycleStatus
  Scenario Outline: Current Cycle Status UI Verification
    Then <StepsForThen>

    Examples: 
      | StepsForThen                                                                                  |
      | Current Cycle Status is displayed                                                             |
      | Displays current cycle progress in the format as the values entered during onboarding process |
      | Menstrual, Follicular, Ovulation, Luteal labels are displayed below the progress bar          |
      | Progress bar should be filled according to the current cycle progress                         |
      | Current Phase, Last period started, Next period expected are displayed                        |
      | Displays the phase based on the value entered during onboarding process                       |
      | Displays correct Last period started based on the date entered during onboarding process      |
      | Displays correct Next period expected based on the values entered during onboarding process   |
      | Subsection heading reflects the Current Phase in the format Current Phase Details             |
      | Display content should match current phase                                                    |

  @UpcomingPhases
  Scenario Outline: Upcoming Phases UI Verification
    Then <steps>

    Examples: 
      | steps                                                                                            |
      | Upcoming Phases is displayed                                                                     |
      | Subtext is displayed                                                                             |
      | Four subsections should be visible                                                               |
      | Menstrual Phase, Follicular Phase, Ovulation Phase, Luteal Phase are displayed                   |
      | Start date should be diaplayed correctly as per the cycle data entered during onboarding process |
      | All phase start dates should be displayed in "Starts MMM dd" format                              |
      | Current phase date should be displayed in "Started MMM dd" format                                |
      | "Current Phase" subsection is highlighted based on cycle data entered during onboarding process  |

  @RecommendedActivities
  Scenario Outline: Recommended Activities UI Verification
    Then <stepForRecommendedActivites>

    Examples: 
      | stepForRecommendedActivites                                           |
      | Recommended Activities should be displayed                            |
      | Recommended Activities should be displayed as per the "Current Phase" |
@NutritionTips
  Scenario Outline: Nutrition Tips UI Verification
    Then <stepsUnderNutritionTips>
    Examples: 
      | stepsUnderNutritionTips                                        |
      | "Nutrtion Tips" is displayed                                   |
      | Nutrtional Tips should be displayed as per the "Current Phase" |
