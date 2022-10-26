@tag
Feature: I want to submit an order
  I want to use this template for my feature file
  
  Background: 
  Given I am on landing page

  @regression
  Scenario Outline: submit an order
    Given I login to the application using <username> and <password>
    When I add <productname> to cart and click on cart
    And verify if <productname> is present in cart
    Then I click on checkoutpage and verify "Thankyou for the order." is displayed

    Examples: 
      | username  								| password 		 | productname   	 |
      | abdullasuhail21@gmail.com | Suhail@1 		 | ZARA COAT 3 	   |
      | abdullasuhail21@gmail.com | Suhail@1 		 | ADIDAS ORIGINAL |
