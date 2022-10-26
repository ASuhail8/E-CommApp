
@tag
Feature: I want to do error validation
  I want to use this template for my feature file
  
  

  @errorvalidation
  Scenario Outline: validate error on login page with incorrect username and password
  	Given I am on landing page
    And I login to the application using <username> and <password>
    Then I verify "Incorrect email or password." is displayed

 	 Examples: 
      | username  								| password 		 | 
      | abdullasuhail21@gmail.com | Suhail	 |