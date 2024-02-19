Feature: User Login Function
#data table if u pass data at step level,for each step we have to get the data and pass it
#(get as arugument and processing the data and it is used)
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
#(approach used by "scenario outline and examples" is "data driven")

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


