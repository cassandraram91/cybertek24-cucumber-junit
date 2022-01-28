@lyft
Feature: Searching Lyft fare details
  As a rider , I should be able to enter pickup and drop off locations so that I can see the estimated fare


Scenario: Fare estimate using City
  Given User is on lyft fare estimate page
  When User enters "Winter Haven, FL, USA" to pickup address
  And User enters "Orlando, FL, USA" to drop-off address
  And User clicks on get estimate button
  Then User should see estimated prices


Scenario: Fare estimate using Full address
  Given User is on lyft fare estimate page
  When User enters "865 Oriole Ct, Winter Haven, FL, 33884" to pickup address
  And User enters "2341 Donegan Pl, Orlando, FL, 32826" to drop-off address
  And User clicks on get estimate button
  Then User should see estimated prices



Scenario: Fare estimate using empty should show error
  Given User is on lyft fare estimate page
  When User enters "" to pickup address
  And User enters "" to drop-off address
  And User clicks on get estimate button
  Then User should see error message
