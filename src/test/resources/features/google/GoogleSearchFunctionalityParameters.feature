@apiregression @regression
Feature:Testing the Google Search Functionality Parameters  #general description

  Background:  Given User navigate to the 'https://www.google.com/'

  Scenario: Happy Path(positive) testing the search functionality parameters  #the test case

#    Given User navigate to the 'https://www.google.com/'
    When User searches for 'CodeFish'
    Then User validates first page returns more than 10 links



  Scenario: Happy Path(positive) testing result for search parameters

#    Given User navigate to the 'https://www.google.com/'
    When User searches for 'Kyrgyz Food in USA'
    Then User validates the result is less than 300000000

@smoke
  Scenario: Happy Path(positive) testing the result for search bar parameters

#    Given User navigate to the 'https://www.google.com/'
    When User searches for 'Turkish baklava'
    Then User validates the result loads in less than 1.0 second