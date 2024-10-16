package stepDefinitions;



import io.cucumber.java.en.Then;
import pageObjects.LandingPage;
import pageObjects.OffersPage;
import pageObjects.PageObjectManager;
import utils.TestContexSetup;

import java.util.Iterator;
import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class OfferPageStepDefinition {
	public WebDriver driver;
	public String offertPageProductName;
	TestContexSetup testContexSetup;
	PageObjectManager pageObjectManager;
	
	public OfferPageStepDefinition(TestContexSetup testContexSetup)
	{
		this.testContexSetup = testContexSetup;
	}
	
	@Then("^user searched for (.+) shorname in offers page$")
	public void user_searched_for_same_shorname_in_offers_page(String shortName) throws InterruptedException {
		switchToOffersPage();
		OffersPage offersPage = new OffersPage(testContexSetup.driver);
	    offersPage.searchItem(shortName);
	    Thread.sleep(2000);
	    offertPageProductName =offersPage.getProductName();
	    }
	public void switchToOffersPage()
	{
		
		LandingPage landingPage = testContexSetup.pageObjectManager.getLandingPage();
		landingPage.selectTopDealsPage();
		testContexSetup.genericUtils.SwitchWindowToChild();
	}
	@Then("validate product name in Offers page matches with Landing Page")
	public void validate_product_name_in_Offers_page()
	{
		Assert.assertEquals(offertPageProductName,testContexSetup.landingPageProductName );
	}
}
