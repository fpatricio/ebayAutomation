package pe.com.automation.exam.steps;

import org.testng.Assert;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pe.com.automation.exam.fw.ParentScenario;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class EbayStoreSteps extends ParentScenario {

	@Given("^I go to the Ebay page on URL \"([^\"]*)\"$")
	public void I_go_to_the_Ebay_page_on_url(String url) {
		startChrome();
		landingPage.gotoUrl(url);
		System.out.println("The url loaded correctly");
	}

	@When("^I fill the value \"([^\"]*)\" in the text field$")
	public void I_fill_the_value_in_the_text_field(String product) {
		landingPage.writeProduct(product);
		System.out.println("The product name was correctly written "+product);
	}
	
	@And("^I click on the search button$")
	public void I_click_on_the_search_button(){
		landingPage.clickBtnSearch();
		System.out.println("The search button was correctly clicked");
	}
	
	@And("^I select the brand PUMA$")
	public void I_select_the_brand_PUMA(){
		landingPage.selectChkBrandPuma();
		System.out.println("The puma brand was correctly selected");
	}
	
	@And("^I select the size 10$")
	public void I_select_the_size_10(){
		landingPage.selectSize10();
		System.out.println("The size 10 was correctly selected");
	}
	
	
	@Then("^I should see the number of results$")
	public void I_should_see_the_results_list(){
		String nResultados = landingPage.getNumberResults();
		System.out.println("The number of results is displayed correctly: "+nResultados);
		closeDriver();
	}
	
	@And("^I order by price ascendant$")
	public void I_order_by_price_ascendant(){
		landingPage.orderByPriceAscendant();
		System.out.println("The products list was sorted in ascending order correctly");
	}
	
	@Then("^I should assert the order taking the first 5 results$")
	public void I_should_assert_the_order_taking_the_first_5_results(){

		double productPrice1 = landingPage.getProductPrice(1);
		double productPrice2 = landingPage.getProductPrice(2);
		double productPrice3 = landingPage.getProductPrice(3);
		double productPrice4 = landingPage.getProductPrice(4);
		double productPrice5 = landingPage.getProductPrice(5);

		Assert.assertTrue(productPrice1 < productPrice2, "Product 1 price should be less than product 2 price");
		Assert.assertTrue(productPrice2 < productPrice3, "Product 2 price should be less than product 3 price");
		Assert.assertTrue(productPrice3 < productPrice4, "Product 3 price should be less than product 4 price");
		Assert.assertTrue(productPrice4 < productPrice5, "Product 4 price should be less than product 5 price");

		System.out.println("The first 5 results were verified correctly");
		closeDriver();
	}
	
	@Then("^I should print the first 5 products with their prices in console$")
	public void I_should_print_the_first_5_products_with_their_prices_in_console(){
		System.out.println("The first 5 products are:");
		for (int i = 1; i <= 5; i++) {
			System.out.println(landingPage.getNameProduct(i)+": "+landingPage.getProductPrice(i));
		}
		closeDriver();
	}
	
	@And("^I order by price descendant$")
	public void I_order_by_price_descendant(){
		landingPage.orderByPriceDescendant();
		System.out.println("The list was sorted in descending order correctly");
	}
	
	@Then("^I should print the first \"([^\"]*)\" products with their prices in descendant mode$")
	public void I_should_print_the_first_products_with_their_prices_in_descendant_mode(String numero){
		System.out.println("The first "+numero+" products in descendant mode are:");
		for (int i = 1; i <= Integer.parseInt(numero); i++) {
			System.out.println(landingPage.getNameProduct(i)+": "+landingPage.getProductPrice(i));
		}
		closeDriver();
	}

	@Then("^I should print the first 5 products ordered by name$")
	public void I_should_print_the_first_products_ordered_by_name(){
		System.out.println("The first 5 products in descendant mode are:");
		ArrayList<String> list = new ArrayList<String>();
		for (int i = 1; i <= 5; i++) {
			list.add(landingPage.getNameProduct(i));
		}
		Collections.sort(list);
		System.out.println("The first 5 products ordered by name are: \n");
		for (int i = 0; i <5; i++) {
			System.out.println(list.get(i) + "\n");
		}
		closeDriver();
	}
}
