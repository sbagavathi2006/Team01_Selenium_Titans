Feature: Onboarding step 8 Functionality and Step 9 UI verification

Background:
   Given User completes onboarding until step 7

  Scenario: Continue button is enabled upon dietary option selection
  When User selects "<DietOption>" dietary option
  Then Continue button should be enabled in Step 8
  
  Examples:
  | DietOption           |
  | PescatarianDiet      |
  | Non-Vegetarian       |
  | VegetarianDiet       |
  | VeganDiet            |
 
 
  Scenario: Navigating back to Step 7 from Step 8
  When User clicks the Back button in Step 8
  Then User should be redirected to Step "7 of 10"
 

  Scenario Outline: Verify Step 9 UI elements are displayed
  When User clicks continue after selecting any dietary options
  Then Step9 "<UI Element>" should be displayed

Examples:
  | UI Element                     |
  | ProgressBar                    |
  | Titleofstep9                   |
  | Descriptionstep9               |
  | SedentaryRadioButton           |
  | LightlyActiveRadioButton       |
  | ModeratelyActiveRadioButton    |
  | VeryActiveRadioButton          |
  | SedentaryTxt                   |
  | LightlyTxt                     |
  | ModeratelyTxt                  |
  | VeryActiveTxt                  |
  | Infonote                       |
  
 
