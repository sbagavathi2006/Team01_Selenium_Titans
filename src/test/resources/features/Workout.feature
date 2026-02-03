Feature: Workout Page UI verification

  Background: 
    Given User logged into the application

  Scenario Outline: Verify UI elements on the Workout page
    When user clicks workout button on navigation bar
    Then User should see <ElementType> as "<ExpectedValue>"

    Examples: 
      | ElementType                                 | ExpectedValue                                                                                     |
      | page title                                  | Daily Personalized Workouts                                                                       |
      | link text                                   | Back to dashboard                                                                                 |
      | workout section title                       | Daily Workout Plan                                                                                |
      | plan text description                       | Fresh AI-powered workout tailored to your current cycle phase                                     |
      | message                                     | No workout plan found                                                                             |
      | message alignment                           | centre                                                                                            |
      | button text                                 | Generate workout plan                                                                             |
      | luteal phase workout section text           | Your Luteal Phase Workouts                                                                        |
      | luteal phase workout section description    | In your luteal phase ,focus on maintenance and stree reduction                                    |
      | presence of benefits of cycle               | Benefits of Cycle-Synced Workouts                                                                 |
      | benefits of cycle description               | This personalized 7-day workout plan                                                              |
      | icons under benefits of cycle section       | Home Workouts, Mood Enhancement, Calorie Tracking, and Hormonal Balance                           |
      | Free Plan Special card on right panel       | Free Plan Special Complete 7 Day Workout Plan                                                     |
      | background colour of Free Plan Special card | green                                                                                             |
      | Free plan Special card section description  | Get your complete weekly workout plan with personalized exercises                                 |
      | 7 Day Plan button                           | Generate 7 Day plan                                                                               |
      | Premium Plan section on Right panel         | Ready to Transform Your Health Journey?                                                           |
      | Premium Plan Card background color          | purple                                                                                            |
      | premium plan section description            | Upgrade to access personalized AI recommendations, detailed analytics, expert guidance, and more! |
      | See premium plans button                    | See premium plans button displayed                                                                |

      
      