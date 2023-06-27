@uiregression @regression
Feature:Testing the Google Search Functionality   #general description

  Scenario: Happy Path(positive) testing the search functionality  #the test case

    Given User navigate to the google
    When User searches for CodeFish
    Then User validates first page returns more than ten links


@smoke
  Scenario: Happy Path(positive) testing result for search

    Given User navigate to the google
    When User searches for Kyrgyz Food in USA
    Then User validates the result is less than three hundred million


  Scenario: Happy Path(positive) testing the result for search bar

    Given User navigate to the google
    When User searches for Turkish baklava
    Then User validates the result loads in less than one second