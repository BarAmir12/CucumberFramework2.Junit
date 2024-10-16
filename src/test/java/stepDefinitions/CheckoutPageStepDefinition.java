package stepDefinitions;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.Checkoutpage;
import pageObjects.LandingPage;
import utils.TestContexSetup;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class CheckoutPageStepDefinition {
	TestContexSetup testContexSetup;
	public Checkoutpage checkoutPage;
	
	public CheckoutPageStepDefinition(TestContexSetup testContexSetup)
	{
		this.testContexSetup = testContexSetup;
		this.checkoutPage=testContexSetup.pageObjectManager.getCheckoutpage();

	}
	@Then("verify user has ability to enter promo code and place the order")
	public void verify_user_has_ability_to_enter_promo_code_and_place_the_order()
	{
		Assert.assertTrue(checkoutPage.VerifyPromoBtn());
		Assert.assertTrue(checkoutPage.VerifyPlaceOrder());

	}
	
	@Then("^User proseeds to Checkout and validate the (.+) items in checkout page$")
	public void User_proseeds_to_Checkout_and_validate_the_items_in_checkout_page(String name) throws InterruptedException
	{
		checkoutPage.CheckOutItem();
		//validate the items in checkout page
	}
	
	
}
