Feature: Testing Etsy search functionality with scenario outline
  Scenario Outline: Testing different products for search functionality
    When user searches for '<itemName>' in Etsy
    Then user validates the title '<title>' from Etsy
    Examples:
    |itemName|title|
    |Hat     |Hat - Etsy|
    |Key     |Key - Etsy|
    |Pin     |Pin - Etsy|