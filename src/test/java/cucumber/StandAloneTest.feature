@tag
  Feature: Purchase an order from an Ecommerce Website

    Background:
      Given I landed on Ecommerce Page

    @Regression
#    @tags2
    Scenario Outline: Positive test of submitting the order
      Given Logged in with username <name> and password <password>
      When I add a product <productName> to Cart
      And Checkout <productName> and submit the order to the country <countryName>
      Then "Thankyou for the order." is displayed

      Examples:
      |name                    |password    | productName | countryName |
      |test1000332@gmail.com   |M267280m    | ZARA COAT 3 | india       |