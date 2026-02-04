Feature: Menstrual Cycle Tracker - UI Verification

  Background: 
    Given User clicks Activity Insights button after logged in

  #Scenario: Her Balance Dashboard with the Activity Insights submenu
    #When User clicks on Menstrual Phase Logs from dashboard
    #Then User is able to see five sections on the Menstrual Phase Logs page
#
  #Scenario: Update Cycle Information button is visible
    #When User clicks on Menstrual Phase Logs from dashboard
    #Then User is able to see Update Cycle Information button should be visible
#
  #Scenario: Back to Dashboard button is visible
    #When User clicks on Menstrual Phase Logs from dashboard
    #Then User is able to see Add Period Log button should be visible
#
  #Scenario: Add Period Log button is visible
    #When User clicks on Menstrual Phase Logs from dashboard
    #Then Add Period Log button should be visible
#
  #Scenario: Cycle Overview tab is visible
    #When User clicks on Menstrual Phase Logs from dashboard
    #Then Cycle Overview tab should be visible
#
  #Scenario: Menstrual Calendar tab is visible
    #When User clicks on Menstrual Phase Logs from dashboard
    #Then Menstrual Calendar tab should be visible
#
  #Scenario: Period History tab is visible
    #When User clicks on Menstrual Phase Logs from dashboard
    #Then Period History tab should be visible

 #Scenario: Display cycle progress based on onboarding data
    #When User clicks on Menstrual Phase Logs from dashboard
    #Then Displays current cycle progress in the format as the values entered during onboarding process
    #
  #Scenario: Progress bar with phase labels
    #When User clicks on Menstrual Phase Logs from dashboard
    #Then Menstrual, Follicular, Ovulation, Luteal labels are displayed below the progress bar
       #
   #Scenario: Progress bar accuracy for current cycle day and phase
    #When User clicks on Menstrual Phase Logs from dashboard
    #Then Progress bar should be filled according to the current cycle progress
    #
    #Scenario: Display all the labels in Current Cycle Status section
    #When User clicks on Menstrual Phase Logs from dashboard
    #Then Current Phase, Last period started, Next period expected are displayed
    #
   Scenario: Display correct Current Phase
    When User clicks on Menstrual Phase Logs from dashboard
    Then Displays the phase based on the value entered during onboarding process
    
   Scenario: Display correct Last period started
    When User clicks on Menstrual Phase Logs from dashboard
    Then Displays correct Last period started based on the date entered during onboarding process
    
   Scenario: Display correct Next period expected
    When User clicks on Menstrual Phase Logs from dashboard
    Then Displays correct Next period expected based on the values entered during onboarding process
    
   Scenario: Subsection heading text per phase
    When User clicks on Menstrual Phase Logs from dashboard
    Then Subsection heading reflects the Current Phase in the format [Current Phase] Details
    
   Scenario: Content below the subsection heading per phase
     When User clicks on Menstrual Phase Logs from dashboard
     Then Display content should match current phase 
     
    