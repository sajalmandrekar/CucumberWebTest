package stepDefinations;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LandingPage;
import pageObjects.OfferPage;
import utils.TestContextSetup;

public class OfferPageStepDefination{

	public WebDriver driver;
	public String productNameHome, productNameOffer;
	TestContextSetup testContextSetup;
	
	public OfferPageStepDefination(TestContextSetup testContextSave)
	{
		this.testContextSetup = testContextSave;
		driver = testContextSave.driver;
		productNameHome = testContextSave.productNameHome;
	}
	
	@Then("^user searches (.*) on offer page and extracts it$")
	public void user_searches_in_offers_page_and_validate(String shortNameOffer) throws InterruptedException
	{
		System.out.println("search in offers page\n");
		switchToOffersPage();
		
//		OfferPage offerPage = new OfferPage(driver);
		OfferPage offerPage = testContextSetup.pageObjectManager.getOfferPage();
		offerPage.searchItem(shortNameOffer);
		
		//wait for page to load
		Thread.sleep(2000);
		
		//retrieve name of the item from the search result
		productNameOffer = offerPage.getItemName();
	}
	
	@And("checks if extracted strings match")
	public void check_if_strings_match()
	{
		System.out.println(productNameHome+" "+productNameOffer);
		Assert.assertEquals(productNameHome, productNameOffer);
	}
	
	public void switchToOffersPage()
	{
		if(!testContextSetup.testBase.getCurrentUrl().equalsIgnoreCase("https://rahulshettyacademy.com/seleniumPractise/#/"))
			return;
		
//		LandingPage landingPage = new LandingPage(driver);
		LandingPage landingPage = testContextSetup.pageObjectManager.getLandingPage();
		landingPage.clickText("Top Deals");
		
		testContextSetup.genericUtils.switchToChildTab();
	}
}