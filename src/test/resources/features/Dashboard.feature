@dashboard
Feature: Dashboard page

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


    Scenario Outline: Verify the Button count and its text
      When User clicks login in button after entering  a valid credential
      Then User should see "<subHeadings>"
      Examples:
      |subHeadings|
      |User Name|
      |Activity Insights|
      |Diet Plan|
      |Workout|
      |Water Tracker|
      |Upgrade to Premium|
      |Generate 7-Day Plan|
      |See Premium Plans|
      
     


      Scenario Outline: Verify Sub text for title and its location
        When User clicks login in button after entering  a valid credential
        Then User should see below "<planText>"
        Examples:
        |planText|
        |Free Plan • Access to Basic Features|
        |Enjoy our free plan with basic features and exclusive workout planning.|


       Scenario Outline: Verify Section visibility and its heading text
         When User clicks login in button after entering  a valid credential
         Then User should see below dashboard "<sections>"
         Examples:
         |sections|
         |Weight & Body Metrics|
         |Health Conditions|
         |Subscription Information|


    Scenario Outline: Verify Metrics Section Displays All Relevant Sub-sections
      When User clicks login in button after entering  a valid credential
      Then User should see below body metrics "<values>"
      Examples:
      |values|
      |BMI Reference Guide|
      |Starting|
      |Height|
      |BMI|
      |7-Day Goal|

      

     Scenario Outline: Verify 7-Day Goal section details
       When User clicks login in button after entering  a valid credential
       Then App should have following goal "<values>"
       Examples:
       |values|
       |Monthly Goal:|
       |Weekly target|
       |Daily Weigh-in|


      Scenario: Verify Current Weight Value Displayed from Onboarding
        When User clicks login in button after entering  a valid credential
        Then Should display the user’s weight as entered during the onboarding process.


        Scenario: Verify Height Value Displayed from Onboarding
          When User clicks login in button after entering  a valid credential
          Then Should display the user’s Height as entered during the onboarding process.


   Scenario: Verify BMI Calculation on Dashboard
    When User clicks login in button after entering  a valid credential
     Then BMI should be correctly calculated using the formula


       Scenario: Verify Goal weight value check
         When User clicks login in button after entering  a valid credential
         Then Goal weight should be displayed as the difference from the weekly target


Scenario: Verify Daily weigh in schedule display
  When User clicks login in button after entering  a valid credential
  Then Daily weigh in should be "Morning, before food"


Scenario: Verify subscription details should be displayed in 7-day goal
  When User clicks login in button after entering  a valid credential
  Then Subcription details should be present in goal section


 Scenario: Verify Info label visibility
     When User clicks login in button after entering  a valid credential
     Then "Info" label should be visible above the slider


    Scenario: Verify Free plan note
      When User clicks login in button after entering  a valid credential
      Then Following Message should display "Free plan includes 7 days of limited tracking"


Scenario: Verify the slider in BMI reference guide
  When User clicks login in button after entering  a valid credential
  Then Slider should be present in BMI reference guide
  And BMI Reference Guide component should be displayed with a gradient slider and labeled ranges

  Scenario: Verify gradient color representation
    When User clicks login in button after entering  a valid credential
    Then slider should display a continuous gradient from blue → yellow → orange → red, representing increasing BMI values

Scenario Outline: Verify BMI category labels
  When User clicks login in button after entering  a valid credential
  Then "<Labels>" should be visible and color-coded accordingly
  Examples:
  |Labels|
  |Underweight|
  |Normal|
  |Overweight|
  |Obese|


    #Health Conditions -with condition


  Scenario: Verify Automatic data mapping from onboarding
    When User clicks login in button after entering  a valid credential with healthCondition
    Then Displayed condition match exactly what was selected during onboarding without requiring user input again

    Scenario: Verify Condition description message
      When User clicks login in button after entering  a valid credential
      Then Displayed message appears below healthCondition card explaining how the plan is adjusted
    

   #Health Conditions -without condition

  Scenario: Verify No condition scenario
    When User clicks login in button after entering  a valid credential without healthCondition
    Then Message like "No Health Issues" or an empty state is displayed










 #Blood Report Insights - report not uploaded


  Scenario: Verify Display Blood Report Insights based on report not uploaded
    When User clicks login in button after entering  a valid credential
    Then User should see the "Upload Blood Report" button


 Scenario: Verify Message for Blood report
   When User clicks login in button after entering  a valid credential
   Then "Upload your medical blood test report to receive AI-powered insights on how your results impact weight management and overall health." Message prompting them to upload their medical blood test report


   Scenario: Verify Upload report button
     When User clicks login in button after entering  a valid credential
     Then Upload Blood Report button should be enabled




     #Subscription Information

  Scenario: Verify Presence of start / joined date of subcription
    When User clicks login in button after entering  a valid credential
    Then Joined date should be displayed

    Scenario: Verify Presence of todays date section
      When User clicks login in button after entering  a valid credential
      Then Todays date should be display

     Scenario: Verify Plan details is displayed
       When User clicks login in button after entering  a valid credential
       Then Subcription plan should be displayed

  Scenario: Verify Presence of Upgrade to Premium button
    When User clicks login in button after entering  a valid credential
    Then "Upgrade to Premium" button should be displayed

  #Menstrual Cycle Insights
 
      Scenario: Verify View Full Cycle Details button navigation
        When User clicks login in button after entering  a valid credential
        And User click on view full cycle details link
        Then User should be redirected to the full "Menstrual Cycle Tracker" page


     Scenario: Verify Free plan information messages
       When User clicks login in button after entering  a valid credential
       Then Message "Free plan includes basic cycle insights" should be displayed












# Dashboard - Functionality

Scenario Outline: Verify Sub menu in  profile name
Given User clicks login in button after entering  a valid credential
When User clicks on profile name
Then User should see below "<options>"
Examples:
|options|
|Home|
|Edit profile|
|Subscription|
|Logout| 

Scenario: Verify Sub menu in activity insights 
Given User clicks login in button after entering  a valid credential
When User clicks on activity Insight
Then User should see  Track Weight", Food Intake" , "Menstrual Phase Logs"

Scenario: Navigation on diet plan
Given User clicks login in button after entering  a valid credential
When User clicks on Diet plan button
Then User should redirected to diet-plan page

Scenario: Verify Navigation on workout plan
Given User clicks login in button after entering  a valid credential
When User clicks on workout button
Then User should redirected to workout page

Scenario: Verify Navigation on water Tracker plan
Given User clicks login in button after entering  a valid credential
When User clicks on water tracker button
Then User should redirected to water tracker page

Scenario: Verify Navigation on View Full cycle details
Given User clicks login in button after entering  a valid credential
When User clicks on View Full Cycle Details 
Then User should be redirected to Menstrual cycle tracker page


Scenario: Verify Navigation on Upload Blood report
Given User clicks login in button after entering  a valid credential
When User clicks on Upload Blood report
Then User should be redirected to explorer to choose the file

@fail
Scenario: Verify Navigation on Upgrade premium 
Given User clicks login in button after entering  a valid credential
When User clicks on  Upgrade to Premium 
Then User should be redirected to Subcription page

Scenario: Verify Navigation on  generate 7-day Plan
Given User clicks login in button after entering  a valid credential
When User clicks on Generate 7-Day Plan
Then User should be redirected to diet-plan page

Scenario: Verify Navigation on see premium plans
Given User clicks login in button after entering  a valid credential
When User clicks on See Premium Plans
Then User should be redirected to Subcription page

#Dashboard - Profile sub menu functionality

Scenario: Verify Navigation of Home button
Given User clicks login in button after entering  a valid credential
And User clicks on profile name
When User clicks on Home 
Then User should be redirected to dashboard option

Scenario: Verify Navigation of Profile
Given User clicks login in button after entering  a valid credential
And User clicks on profile name
When User clicks on Edit Profile
Then User should be redirected to Edit Your Profile page

Scenario: Verify Navigation of Subscription
Given User clicks login in button after entering  a valid credential
And User clicks on profile name
When User clicks on Subscription 
Then User should be redirected to Subscription Management page

Scenario: Verify Navigation of Logout
Given User clicks login in button after entering  a valid credential
And User clicks on profile name
When User clicks on Logout
Then User should be logged out of the application

#Dashboard - Activity Insights sub menu functionality

Scenario: Verify Navigation of Track Weight
Given User clicks login in button after entering  a valid credential
And User clicks on activity Insight
When User clicks on Track Weight
Then User should be redirected to  track weight page

@fail
Scenario: Verify Navigation of  Food Intake
Given User clicks login in button after entering  a valid credential
And User clicks on activity Insight
When User clicks on Food Intake
Then User should be redirected to food intake page

Scenario: Veirfy Navigation of Menstrual Phase Logs
Given User clicks login in button after entering  a valid credential
And User clicks on activity Insight
When User clicks on Menstrual Phase Logs
Then User should be redirected to menstrual phase log page

