@regression
Feature: Testing Weborder Login Functionality

  @smoke
  Scenario: Testing positive login (correct username and correct password)

    When The user provides the 'guest1@microworks.com' , 'Guest1!' and clicks on sign in button
    Then The user validates the 'ORDER DETAILS - Weborder'

  Scenario: Testing negative login with correct username and wrong password

    When The user provides the 'guest1@microworks.com' , 'wrongpass' and clicks on sign in button
    Then The user validates the message 'Sign in Failed'
@smoke
  Scenario: Testing negative login with wrong username and correct password

    When The user provides the 'wronguser@123.com' , 'Guest1!' and clicks on sign in button
    Then The user validates the message 'Sign in Failed'

  Scenario: Testing negative login with empty username and empty password

    When The user provides the ' ' , ' ' and clicks on sign in button
    Then The user validates the message 'Sign in Failed'