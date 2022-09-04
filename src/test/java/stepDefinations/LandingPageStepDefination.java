package stepDefinations;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pageObjects.LandingPage;
import utils.TestContextSetup;

public class LandingPageStepDefination{

	public WebDriver driver;
	TestContextSetup testContextSetup;
	LandingPage landingPage;
	
	public LandingPageStepDefination(TestContextSetup testContextSetup)
	{
		this.testContextSetup = testContextSetup;
		this.landingPage = testContextSetup.pageObjectManager.getLandingPage();
	}
	
	@Given("user is on landing page")
	public void user_is_on_landing_page()
	{
		Assert.assertTrue(landingPage.getTitle().contains("GreenKart"));
	}
	
	@When("^user searches short name (.*) in home page and extracts it$")
	public void user_searches_in_home_page(String shortName) throws InterruptedException
	{
		System.out.println("search in home page");
		
		//LandingPage landingPage = new LandingPage(testContextSave.driver);
		LandingPage landingPage = testContextSetup.pageObjectManager.getLandingPage();
		landingPage.searchItem(shortName);
		
		//wait for some time for page to load
		Thread.sleep(2000);
		
		testContextSetup.productNameHome = landingPage.getItemName();
		
		System.out.println("Product searched: "+testContextSetup.productNameHome);
	}
	
	//And user adds "3" items of selected product to cart
	@And("user adds {string} items of selected product to cart")
	public void user_adds_item_to_cart(String number_items)
	{
		// increment product
		// add to cart
		landingPage.incrementQuantity(Integer.parseInt(number_items));
		landingPage.addToCart();
	}
	
}