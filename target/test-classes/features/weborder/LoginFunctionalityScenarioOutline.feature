Feature: Testing Weborder Login Functionality

  Scenario: Testing positive login (correct username and correct password)

    When The user provides the 'guest1@microworks.com' , 'Guest1!' and clicks on sign in button
    Then The user validates the 'ORDER DETAILS - Weborder'

    Scenario Outline: Testing negative login with correct username and wrong password

      When The user provides the '<userName>' , '<password>' and clicks on sign in button
      Then The user validates the message '<message>'

      Examples:
      |userName               |password          |message|
      |guest1@microworks.com  |wrongpass         |Sign in Failed       |
      |wronguser@123.com      |wrongpass         |Sign in Failed       |
      |                       |                  |Sign in Failed       |


