
@TestWeightTrack
Feature: Weight Tracking functional verification
Background:

  Scenario: Verify if the Header text is displayed
    Given User is on Her balance Home page after successful login
    When User navigates to the Activity Insights tab - Weight Tracking page
    Then Header text "Weight Tracking" should be displayed

  Scenario: Verify subtitle Free Plan-7 Days Tracking is displayed
    Given User is on Her balance Home page after successful login
    When User navigates to the Activity Insights tab - Weight Tracking page
    Then Subtitle text "Free Plan - 7 Days Tracking" should be displayed

  Scenario: Verify if Back to Dashboard button is visible
    Given User is on Her balance Home page after successful login
    When User navigates to the Activity Insights tab - Weight Tracking page
    Then Back to Dashboard button is be displayed

  Scenario Outline:  Verify if 3 Cards for Weight info are displayed
    Given User is on Her balance Home page after successful login
    When User navigates to the Activity Insights tab - Weight Tracking page
    Then The mentioned "<Cards>" for Weight info should be displayed
    Examples:
      | Cards |
      |   Starting Weight      |
      |   Current Weight      |
      |   Goal Weight         |

#  Scenario:  Verify if Starting weight value is displayed
#    Given User is on Her balance Home page after successful login
#    When User navigates to the Activity Insights tab - Weight Tracking page
#    Then Starting Weight value should be mapped from the onboarding process

  Scenario:  Verify if Current weight and starting weight value is same for new user
    Given User is on Her balance Home page after successful login
    When User navigates to the Activity Insights tab - Weight Tracking page
    Then Current Weight and starting weight value should be same value for new user

 # Scenario:  Verify if Current weight value is displayed based on recent weight log for existing user
#    Given User is on Her balance Home page after successful login
#    When User navigates to the Activity Insights tab - Weight Tracking page
#    Then according to the recent weight log, Weight value should be mapped

  Scenario:  Verify if Goal weight value is displayed
    Given User is on Her balance Home page after successful login
    When User navigates to the Activity Insights tab - Weight Tracking page
    Then Goal weight option should be displayed

  Scenario: Verify if Progress overview section is visible
    Given User is on Her balance Home page after successful login
    When User navigates to the Activity Insights tab - Weight Tracking page
    Then Header should be displayed as "Progress overview" text

  Scenario: Verify if Subtext in progress bar section is displayed
    Given User is on Her balance Home page after successful login
    When User navigates to the Activity Insights tab - Weight Tracking page
    Then Subtext "Weight Loss Progress" text should be displayed


  Scenario: Verify if Completion percentage is shown
    Given User is on Her balance Home page after successful login
    When User navigates to the Activity Insights tab - Weight Tracking page
    Then Completion percentage should be displayed in percentage format

  Scenario: Verify if Weight lost is displayed
    Given User is on Her balance Home page after successful login
    When User navigates to the Activity Insights tab - Weight Tracking page
    Then  Weight lost value should be displayed

  Scenario: Verify if Remaining weight is displayed
    Given User is on Her balance Home page after successful login
    When User navigates to the Activity Insights tab - Weight Tracking page
    Then Remaining weight value should be displayed

  Scenario: Verify if Graph section header is displayed
    Given User is on Her balance Home page after successful login
    When User navigates to the Activity Insights tab - Weight Tracking page
    Then Graph section header "Weight Progression over Time" should be displayed

  Scenario Outline: Verify if X-axis labels are displayed
    Given User is on Her balance Home page after successful login
    When User navigates to the Activity Insights tab - Weight Tracking page
    Then Graph should be visible with x axis "<values>" showing days
    Examples:
      | values |
      | Day 1  |
      | Day 2  |
      | Day 3  |
      | Day 4  |
      | Day 5  |
      | Day 6  |
      | Day 7  |


  Scenario: Verify if Y-axis labels are displayed
    Given User is on Her balance Home page after successful login
    When User navigates to the Activity Insights tab - Weight Tracking page
    Then Y-axis should display weight values in Weight kg

  Scenario Outline: Verify if Fields in log section is displayed
    Given User is on Her balance Home page after successful login
    When User navigates to the Activity Insights tab - Weight Tracking page
    Then mentioned "<inputs>" and "<fields>" should be displayed
    Examples:
      |inputs|   | fields  |
      | weight|   | Weight (kg)|
      |  bmi |    | BMI (Auto-calculated) |
      | note |    | Note (Optional)  |

  Scenario: Verify if Tracking details are displayed
    Given User is on Her balance Home page after successful login
    When User navigates to the Activity Insights tab - Weight Tracking page
    Then Section should indicate the current tracking day at the left log todays weight section

  Scenario: Verify if Log Weight button appears in default state
    Given User is on Her balance Home page after successful login
    When User navigates to the Activity Insights tab - Weight Tracking page
    Then "Log Weight" button should be disabled

  Scenario:Verify if BMI is auto-calculated after entering weight
    Given User is on Activity Insights tab - Weight Tracking page
    When User enters valid value in weight as "69.06" in Log Today's weight section
    Then "BMI" field should auto-calculated based on the entered weight value

  Scenario: Verify if Log Weight button enables after valid input
    Given User is on Activity Insights tab - Weight Tracking page
    When User enters weight(kg) as "44.80" in Log Todays weight section
    Then Log Weight button should be Enabled


  Scenario:  Verify if error is displayed for Invalid weight entry
    Given User is on Activity Insights tab - Weight Tracking page
    When User enter invalid value in weight "-1" in log today's weight section
    Then error message "Please enter a valid weight message" should be displayed

