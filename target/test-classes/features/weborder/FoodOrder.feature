@regression
Feature: Testing WebOrder Food Order functionality

  Background: food order with same steps
    When The user provides the username , password, clicks on sign in button and go to food order page
    Then The user validates the group order checkbox functionality

  Scenario: Testing order page functionality

#    When The user provides the username , password, clicks on sign in button and go to food order page
#    Then The user validates the group order checkbox functionality
    And The user clicks on the next button, provides the note 'I LOVE CUCUMBER' to invitees,emails 'email@gmail.com , email2@gmail.com' to invite list and select the delivery location 'My House'
    Then The user validates the home address '3137 Laguna' and clicks create group order button
    And The user validates the header 'View Group Order' and description 'Your group order is now pending'


 Scenario: Testing order page functionality for Office
#  When The user provides the username , password, clicks on sign in button and go to food order page
#  Then The user validates the group order checkbox functionality
  And The user clicks on the next button, provides the note 'TESTING1' to invitees,emails 'email@gmail.com , email2@gmail.com' to invite list and select the delivery location 'Office'
  Then The user validates the home address '2012 EMPIRE' and clicks create group order button
  And The user validates the header 'View Group Order' and description 'Your group order is now pending'
#   And user validate the name 'zinah' this is being tested for dryRun logic by making the dryRun true, once we have the snips
#  we change it to false to make sure its running properly