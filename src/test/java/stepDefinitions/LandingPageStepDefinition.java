package stepDefinitions;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LandingPage;
import utils.TestContexSetup;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LandingPageStepDefinition {
	TestContexSetup testContexSetup;
	LandingPage landingPage;
	
	public LandingPageStepDefinition(TestContexSetup testContexSetup)
	{
		this.testContexSetup = testContexSetup;
		this.landingPage = testContexSetup.pageObjectManager.getLandingPage();

	}
	@Given("User is on GreenCart Landing page")
	public void user_is_on_green_cart_landing_page() {
		Assert.assertTrue(landingPage.getTitleLandingPage().contains("GreenKart"));
	}
	@When("^user searched with Shortname (.+) and extracted actual name of product$")
	public void user_searched_with_shortname_and_extracted_actual_name_of_product(String shortName) throws InterruptedException {
		
		landingPage.searchItem(shortName);
		Thread.sleep(2000);
		testContexSetup.landingPageProductName = landingPage.getProductName().split("-")[0].trim();
		System.out.println(testContexSetup.landingPageProductName + " is extracted from Home page");
	}
	
	@When("Added {string} items of the selected product to cart")
	public void And_Added_items_of_the_selected_product_to_cart(String quantity)
	{
		landingPage.incrementQuantity(Integer.parseInt(quantity));
		landingPage.addToCart();
	}

}
