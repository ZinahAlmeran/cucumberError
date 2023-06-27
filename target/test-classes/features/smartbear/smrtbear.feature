@regression
Feature: Testing Order Functionality of the SmartBear page

  Scenario Outline: Testing Order Page Functionality
    Given User provides login information of username and password for SmartBear login
    When User clicks order button and selects the product '<Product>' and Quantity '<Quantity>' for Product Information
    And User provides Customer Name '<Name>',Street '<Street>', city '<City>', state '<State>' and zipCode '<Zipcode>' for addressInformation
    And User selects the card Type '<CardType>', provides the card Number '<CardNum>' and expiration date '<Expiration>' for payment information
    And User clicks the Process button
    Then User validates the confirmation Message '<Message>' and clicks view all orders
    And User validated order information name '<Name>', product '<Product>', quantity '<Quantity>', date '<Date>', street '<Street>', city '<City>', state '<State>', zipCode '<Zipcode>', card '<CardType>', card number '<CardNum>' and expiration '<Expiration>'
    Examples:
      |Product    |Quantity|Name |Street  |City    |State|Zipcode|CardType         |CardNum|Expiration|Message                               |Date|
      |MyMoney    |3       |john |Wall St |Orlando |FL   |12345  |Visa             |123456 |12/28     |New order has been successfully added.|06/27/2023|
      |FamilyAlbum|2       |james|Wall St |Tampa   |FL   |67891  |MasterCard       |123456 |12/28     |New order has been successfully added.|06/27/2023|
      |ScreenSaver|5       |jack |Wall St |WG      |FL   |46802  |American Express |123456 |12/28     |New order has been successfully added.|06/27/2023|