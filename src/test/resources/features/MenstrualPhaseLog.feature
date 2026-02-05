Feature: Menstrual Cycle Tracker - UI Verification

  Background: 
    Given User clicks Activity Insights button after logged in

  #Scenario: Her Balance Dashboard with the Activity Insights submenu
    #When User clicks on Menstrual Phase Logs from dashboard
    #Then User is able to see five sections on the Menstrual Phase Logs page
#
  #Scenario: Update Cycle Information button is visible
    #When User clicks on Menstrual Phase Logs from dashboard
    #Then Update Cycle Information button should be visible 
#
  #Scenario: Back to Dashboard button is visible
    #When User clicks on Menstrual Phase Logs from dashboard
    #Then Back to Dashboard button is visible
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

    #Scenario: Section heading text
    #When User clicks on Menstrual Phase Logs from dashboard
    #Then Current Cycle Status is displayed
    
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
   #Scenario: Display correct Current Phase
    #When User clicks on Menstrual Phase Logs from dashboard
    #Then Displays the phase based on the value entered during onboarding process
    #
   #Scenario: Display correct Last period started
    #When User clicks on Menstrual Phase Logs from dashboard
    #Then Displays correct Last period started based on the date entered during onboarding process
    
   #Scenario: Display correct Next period expected
    #When User clicks on Menstrual Phase Logs from dashboard
    #Then Displays correct Next period expected based on the values entered during onboarding process
    
   #Scenario: Subsection heading text per phase
    #When User clicks on Menstrual Phase Logs from dashboard
    #Then Subsection heading reflects the Current Phase in the format Current Phase Details
    #
   #Scenario: Content below the subsection heading per phase
     #When User clicks on Menstrual Phase Logs from dashboard
     #Then Display content should match current phase 
     
     #Upcoming Phases - UI Verification
    #Scenario: Section heading text for Phases UI Verification
     #When User clicks on Menstrual Phase Logs from dashboard
     #Then Upcoming Phases is displayed
     #
    #Scenario: Subtext is displayed for Phases UI Verification
     #When User clicks on Menstrual Phase Logs from dashboard      
     #Then Subtext is displayed
    ##BUG       
    #Scenario: 4 subsections are visible
     #When User clicks on Menstrual Phase Logs from dashboard      
     #Then Four subsections should be visible
    ##BUG 2 
     #Scenario: Subsection heading text
     #When User clicks on Menstrual Phase Logs from dashboard      
     #Then Menstrual Phase, Follicular Phase, Ovulation Phase, Luteal Phase are displayed
     #
     Scenario: Correct start date for each phase 
     When User clicks on Menstrual Phase Logs from dashboard      
     Then Start date should be diaplayed correctly as per the cycle data entered during onboarding process
     
     Scenario: Start date format
     When User clicks on Menstrual Phase Logs from dashboard      
     Then All phase start dates should be displayed in "Starts MMM dd" format
     
     Scenario: Current Phase Start date format
     When User clicks on Menstrual Phase Logs from dashboard      
     Then Current phase date should be displayed in "Started MMM dd" format 
     
     Scenario: Current Phase subsection is highlighted
     When User clicks on Menstrual Phase Logs from dashboard      
     Then "Current Phase" subsection is highlighted based on cycle data entered during onboarding process 
     
     #Recommended Activities- UI Verification
     #Scenario: Section heading text for Recommended Activities
      #When User clicks on Menstrual Phase Logs from dashboard    
      #Then Recommended Activities should be displayed 
      #
      #
      #Scenario: Content below the section heading per phase
      #When User clicks on Menstrual Phase Logs from dashboard    
      #Then Recommended Activities should be displayed as per the "Current Phase"
      #
      #Nutrition Tips - UI Verification
      #Scenario: Section heading text for Nutrition Tips
      #When User clicks on Menstrual Phase Logs from dashboard    
      #Then "Nutrtion Tips" is displayed
      #
      #Scenario: Content below the section heading per phase
      #When User clicks on Menstrual Phase Logs from dashboard   
      #Then Nutrtional Tips should be displayed as per the "Current Phase"
    ## 
      #Next Period - UI Verification
       #Scenario: Section heading text for Next Period UI Verification
      #When User clicks on Menstrual Phase Logs from dashboard 
      #Then "Next Period" is displayed 
      #
      #Scenario: Next period date display for Next Period UI Verification
      #When User clicks on Menstrual Phase Logs from dashboard 
      #Then "Next period date" should be displayed in the format "Month Day, Year" based on cycle data entered during onboarding process 
      #
    #Scenario: Display number of days remaining for the next period
      #When User clicks on Menstrual Phase Logs from dashboard 
      #Then "Next period date" should be displayed in the format "Month Day, Year" based on cycle data entered during onboarding process 