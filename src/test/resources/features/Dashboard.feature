@dashboard
Feature: Dashboard page

  Background:
    Given: User is on login page

  #Free Plan Dashboard UI
  Scenario: Verify the Title of the Dashboard
    When User clicks login in button after entering  a valid credential
    Then User should see "Free Plan Dashboard" title

    Scenario: Verify the Profile Name visibility
      When User clicks login in button after entering  a valid credential
      Then User should see user name on the top right side

     Scenario: Verify Profile icon Visibility
       When User clicks login in button after entering  a valid credential
       Then User should see profile icon near user name

       Scenario: Verify Notification Icon visibility
         When User clicks login in button after entering  a valid credential
         Then User should see bell icon for notification

      Scenario: Verify user should see bell icon for notification
        When User clicks login in button after entering  a valid credential
        Then User should see search bar in dashboard

    Scenario: Verify the Button count and its text
      When User clicks login in button after entering  a valid credential
      Then User should see 12 menus in dashboard
      And User Name, "Activity Insights"," Diet Plan","Workout","Water Tracker",  "View Full Cycle Details","Upload Blood Report", "Upgrade to Premium","Generate 7-Day Plan",  "See Premium Plans"

      Scenario: Verify Sub text for title and its location
        When User clicks login in button after entering  a valid credential
        Then User should see  "Free Plan • Access to Basic Features","Enjoy our free plan with basic features and exclusive workout planning."
        And Sub text should be located at the centre of the page

       Scenario: Verify Section visibility and its heading text
         When User clicks login in button after entering  a valid credential
         Then 5 section should be visible
         And Weight & Body Metrics,Health Conditions,Blood Report Insights,Menstrual Cycle Insights,Subscription Information

    Scenario: Verify Metrics Section Displays All Relevant Sub-sections
      When User clicks login in button after entering  a valid credential
      Then Weight , Height , BMI , 7-Day Goal,BMI Reference Guide

      @fail
     Scenario: Verify 7-Day Goal section details
       When User clicks login in button after entering  a valid credential
       Then App should have Starting weight, Goal , Weekly target, Daily Weigh-in

       @shared
      Scenario: Verify Current Weight Value Displayed from Onboarding
        When User clicks login in button after entering  a valid credential
        Then Should display the user’s weight as entered during the onboarding process.

         @shared
        Scenario: Verify Height Value Displayed from Onboarding
          When User clicks login in button after entering  a valid credential
          Then Should display the user’s Height as entered during the onboarding process.

   Scenario: Verify BMI Calculation on Dashboard
    When User clicks login in button after entering  a valid credential
     Then BMI should be correctly calculated using the formula (Weight in kg / (Height in m)^2)

     Scenario: Verify Starting weight value check
       When User clicks login in button after entering  a valid credential
       Then Should display weight entered by user

       @fail
       Scenario: Verify Goal weight value check
         When User clicks login in button after entering  a valid credential
         Then Goal weight should be displayed as the difference from the weekly target

         @fail
     Scenario: Verify Weekly target value check
       When User clicks login in button after entering  a valid credential
       Then Weekly target should be .7 kg

Scenario: Verify Daily weigh in schedule display
  When User clicks login in button after entering  a valid credential
  Then Daily weigh in should be "Morning, before food"

Scenario: Verify subscription details should be displayed in 7-day goal
  When User clicks login in button after entering  a valid credential
  Then Subcription details should be present in 7-day goal section

Scenario: Verify the slider in BMI reference guide
  When User clicks login in button after entering  a valid credential
  Then Slider should be present in BMI reference guide
  And BMI Reference Guide component should be displayed with a gradient slider and labeled ranges

  @fail
  Scenario: Verify gradient color representation
    When User clicks login in button after entering  a valid credential
    Then slider should display a continuous gradient from blue → yellow → orange → red, representing increasing BMI values

    @fail
Scenario: Verify BMI category labels
  When User clicks login in button after entering  a valid credential
  Then Labels "Underweight (18.5)", "Normal (25)", "Overweight (30)", and "Obese (40+)" should be visible and color-coded accordingly

  Scenario: Verify BMI pointer position based on user’s BMI
    When User clicks login in button after entering  a valid credential
    Then Circular pointer should automatically be positioned on the slider corresponding to the user’s BMI value

   Scenario: Verify Slider is non-interactive
     When User clicks login in button after entering  a valid credential
     Then Slider should not allow manual movement; it should remain fixed based on the user’s BMI

   Scenario: Verify Info label visibility
     When User clicks login in button after entering  a valid credential
     Then "Info" label should be visible above the slider

    Scenario: Verify Free plan note
      When User clicks login in button after entering  a valid credential
      Then Message “Free plan includes 7 days of limited tracking” should be displayed clearly below the slider

    #Health Conditions -with condition

  Scenario: Automatic data mapping from onboarding
    Given User has completed onboarding and selected one or more health conditions
    When User clicks login in button after entering  a valid credential
    Then Displayed condition(s) match exactly what was selected during onboarding, without requiring user input again

    @shared
    Scenario Outline: Condition description message
      Given User has completed onboarding and selected one or more health conditions
      When User clicks login in button after entering  a valid credential
      Then "<Message>" appears below "<condition>" card explaining how the plan is adjusted
      Examples:
      |condition|Message|
      |Hypothyroidism|We will moderate certain foods (e.g., raw broccoli, soy) while ensuring your plan has nutrients for thyroid support.|
      |Kidney Disease|Your plan will carefully manage levels of sodium, potassium, phosphorus, and protein to support kidney function.    |
      |Liver Disease |To reduce strain on the liver, your plan will strictly limit alcohol, processed fats, added sugars, and sodium.     |
      |Cardiovascular Disease|To support heart health, your plan will strictly limit sodium, saturated/trans fats, and added sugars.      |
      |Digestive Issues (IBS, Leaky Gut, etc.)|Your plan will be designed to limit common trigger foods (like high-FODMAPs, gluten, or dairy) to support digestive health.|
      |Sleep Apnea                            |To improve sleep quality, your meal plan will avoid heavy meals, alcohol, and excessive caffeine near bedtime.             |
      |High Cholesterol                       |Your plan will restrict saturated and trans fats to help support healthy cholesterol levels.                               |
      |Insulin Resistance / Pre-diabetes      |We will limit high-glycemic foods and added sugars in your plan to help maintain stable blood sugar.                       |
      |PCOS                                   |Your plan will be adjusted to limit refined carbohydrates and sugars to support hormone balance.                           |

    Scenario: Styling and icon display
        Given User has completed onboarding and selected one or more health conditions
        When User clicks login in button after entering  a valid credential
      Then Card includes heart icon, condition name , and info icon with related text

   #Health Conditions -without condition

  @fail
  Scenario: No condition scenario
    Given User has completed onboarding  without health conditions
    When User clicks login in button after entering  a valid credential
    Then Message like “No health conditions selected” or an empty state is displayed

#Blood Report Insights - report uploaded

  @fail
  Scenario: Display Blood Report Insights based on report uploaded
    Given User has completed onboarding and uploaded report
    When User clicks login in button after entering  a valid credential
    Then Blood Report Insights section should display the personalized values and insights

 #Blood Report Insights - report not uploaded

  Scenario: Display Blood Report Insights based on report not uploaded
    Given User has completed onboarding and not uploaded report
    When User clicks login in button after entering  a valid credential
    Then User should see the "Upload Blood Report" button

 Scenario: Message for Blood report
   Given User has completed onboarding and not uploaded report
   When User clicks login in button after entering  a valid credential
   Then "Upload your medical blood test report to receive AI-powered insights on how your results impact weight management and overall health."Message prompting them to upload their medical blood test report

   Scenario: Upload report button
     Given User has completed onboarding and not uploaded report
     When User clicks login in button after entering  a valid credential
     Then "Upload Blood Report" button should be enabled

     #Subscription Information

  Scenario: Presence of start / joined date of subcription
    When User clicks login in button after entering  a valid credential
    Then Joined date should be displayed

    Scenario: Presence of todays date section
      When User clicks login in button after entering  a valid credential
      Then Todays date should be display

      @shared
     Scenario: Plan details is displayed
       When User clicks login in button after entering  a valid credential
       Then Subcription plan should be displayed

Scenario: Status of the plan
  When User clicks login in button after entering  a valid credential
  Then Status of plan should be displayed(how many days left out of 7 days free plan)

  Scenario: Presence of Upgrade to Premium button
    When User clicks login in button after entering  a valid credential
    Then "Upgrade to Premium" button should be displayed

  #Menstrual Cycle Insights

  Scenario: Current phase details
    Given User has completed onboarding and last period start date as input
    When User clicks login in button after entering  a valid credential
    Then Should display current menstrual phase in cycle insights section based on onboarding input

   Scenario: Remaining days are calculated based on onboarding input
     Given User has completed onboarding and last period start date as input
     When User clicks login in button after entering  a valid credential
     Then Should display accurate number of days left in the cycle

   Scenario: Cycle length label displays correctly
     Given User has completed onboarding and last period start date as input
     When User clicks login in button after entering  a valid credential
     Then "Cycle: [number] days" should be displayed accurately based on onboarding input

   Scenario: Current day count of the cycle is displayed correctly
     Given User has completed onboarding and last period start date as input
     When User clicks login in button after entering  a valid credential
     Then "Day" count displayed should match the number of days since the last period start date

    Scenario: Progress bar represents current phase duration visually
      Given User has completed onboarding and last period start date as input
      When User clicks login in button after entering  a valid credential
      Then Filled portion should visually represent the proportion of days completed in the current cycle

      Scenario: Next period prediction countdown
        Given User has completed onboarding and last period start date as input
        When User clicks login in button after entering  a valid credential
        Then Should display “x days” as the countdown to the next period

      Scenario: View Full Cycle Details button navigation
        Given User has completed onboarding and last period start date as input
        When User clicks login in button after entering  a valid credential
        Then User should be redirected to the full Menstrual cycle Tracker page

     Scenario: Free plan information message
       Given User has completed onboarding and last period start date as input
       When User clicks login in button after entering  a valid credential
       Then Message "Free plan includes basic cycle insights" should be displayed

     Scenario: Hormonal Impact on Weight message changes dynamically based on phase
       Given User has completed onboarding and last period start date as input
       When User clicks login in button after entering  a valid credential
       Then Hormonal Impact on Weight message should match the expected text for that phase

       Scenario: Likely Symptoms are displayed dynamically based on phase
         Given User has completed onboarding and last period start date as input
         When User clicks login in button after entering  a valid credential
         Then Symptoms listed should correspond to the expected symptoms for that phase

       Scenario: Likely Cravings are displayed dynamically based on phase
         Given User has completed onboarding and last period start date as input
         When User clicks login in button after entering  a valid credential
         Then Cravings displayed should match the expected cravings for that phase


