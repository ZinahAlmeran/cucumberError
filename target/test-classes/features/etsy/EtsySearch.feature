@regression
Feature: Testing the search functionality of the Etsy Website
  Scenario: Search functionality (happy path for etsy hat)
    When user searches for 'Hat' in Etsy
    Then user validates the title 'Hat - Etsy' from Etsy

  Scenario: Search functionality (happy path for etsy hat)
    When user searches for 'Key' in Etsy
    Then user validates the title 'Key - Etsy' from Etsy

  Scenario: Search functionality (happy path for etsy hat)
    When user searches for 'Pin' in Etsy
    Then user validates the title 'Pin - Etsy' from Etsy