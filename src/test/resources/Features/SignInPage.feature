Feature: Sign in
   
  Scenario: User is successfully Sign in with valid credentials
    Given User launch Chrome browser 
    When User opens URL "https://ijmeet.com/login"
    And User enters Email as "abc11@gmail.com" and password as "Admin@1122"
    And I press "Sign in"
    Then Page Title should be "https://ijmeet.com/dashboard"  
    When user click logout link 
    Then close browser
   