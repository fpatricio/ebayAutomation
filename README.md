# ebayAutomation
Tools and Technologies
  Maven project
  Cucumber BDD
  Selenium
  Page Object model pattern
  
# Test Runner path: src\test\java\TestRunner.java

# Cucumber features Path: \src\test\resources\features
## Scenarios

Scenario: The number of results for brand PUMA
	Given I go to the Ebay page on URL "https://www.ebay.com" 
	When I fill the value "shoes" in the text field 
	And I click on the search button 
	And I select the brand PUMA 
	And I select the size 10 
	Then I should see the number of results 

Scenario: Assert the order taking the first 5 results 
	Given I go to the Ebay page on URL "https://www.ebay.com" 
	When I fill the value "shoes" in the text field 
	And I click on the search button 
	And I select the brand PUMA 
	And I select the size 10 
	And I order by price ascendant 
	Then I should assert the order taking the first 5 results 

Scenario: Print the first 5 products with their prices in console
	Given I go to the Ebay page on URL "https://www.ebay.com" 
	When I fill the value "shoes" in the text field 
	And I click on the search button 
	And I select the brand PUMA 
	And I select the size 10 
	And I order by price ascendant 
	Then I should print the first 5 products with their prices in console

Scenario: Print the first 5 products by name in ascendant mode console
  	Given I go to the Ebay page on URL "https://www.ebay.com"
  	When I fill the value "shoes" in the text field
  	And I click on the search button
  	And I select the brand PUMA
  	And I select the size 10
  	And I order by price ascendant
  	Then I should print the first 5 products ordered by name

Scenario: Order and print the products by price in descendant mode
	Given I go to the Ebay page on URL "https://www.ebay.com"
	When I fill the value "shoes" in the text field
	And I click on the search button
	And I select the brand PUMA
	And I select the size 10
	And I order by price descendant
	Then I should print the first "5" products with their prices in descendant mode
