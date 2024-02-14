Feature: User Login Function
 
  #normal scenario creation
  
#Scenario: Valid Login
#Given User in on Login Page
#When User enters credentials
#Then Should display Success Msg

 # for reference in the following link
#"tomsmith"
#"SuperSecretPassword!"


# passing username and password from the feature file

#Scenario: Valid Login
#Given User in on Login Page
#When User enters "tomsmith" and "SuperSecretPassword!"
#Then Should display Success Msg

# here, scenario outline is used where multiple users can be given with the help of "Examples"

#Scenario Outline: Valid Login
#Given User in on Login Page
#When User enters "<username>" and "<password>"
#Then Should display Success 
#Examples:
#| username | password |
#| tomsmith | SuperSecretPassword! |
#| testuser1 | welcome123 |
#| testuser2 | welcome123 |

#Scenario: Valid Login
#Given User is on Login Page
#When User enters credentials
#| tomsmith | SuperSecretPassword! |
#Then Should display Success Msg
#| You logged into a secure area! |


Scenario: Valid Login
Given User is on Login Page
When User enters credentials
| tomsmith | SuperSecretPassword! |
Then Should display Success Msg
| You logged into a secure area! |


