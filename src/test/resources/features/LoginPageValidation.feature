Feature: Sign in
Scenario: Valid Sign in
Given User in Login Page
When User enters valid credentials
Then Should display success message
 
 
Scenario: Invalid Sign in
Given User in Login Page
When User enters invalid credentials
Then Should display error message