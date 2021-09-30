Feature: login functionality

  #@positiveTC
  #Scenario: As a user I want to sign in with valid credentials to login to my account
    #Given user is in the appliation homepage
    #And click on sign in button and land in signin page
    #When enter the valid userName
    #And enter the valid password and click sign in button
    #Then user is logged in to account homePage


  @negativeTC
  Scenario Outline: Title of your scenario outline
  
  	Given user is in the appliation homepage
    And click on sign in button and land in signin page
    When enter the invalid "<userName>"
    And enter the invalid "<password>" and click sign in button


    Examples: 
      | userName  | password |
      | name1 |     5 |
      | name2 |     7 |

      

