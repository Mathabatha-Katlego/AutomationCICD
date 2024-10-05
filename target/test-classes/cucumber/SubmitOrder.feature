@tag
Feature: Purchase the order from Ecommerce website

Background: 
  Given I landed on Ecommerce Page

@tag2
Scenario Outline: Positive Test of Submitting the order
  Given Loggedin with username <name> and password <password>
  When I add product <productName> to Cart
  And checkout <productName> and submit order
  Then "THANKYOU FOR THE ORDER." message is displayed on confirmationPage

  Examples:
    | name                         | password     | productName |
    | mathabathamohlaloga@gmail.com | Mkat_940601  | ZARA COAT 3 |
