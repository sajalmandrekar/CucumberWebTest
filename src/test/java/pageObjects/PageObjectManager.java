package pageObjects;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {

	WebDriver driver;
	
	public PageObjectManager( WebDriver driver)
	{
		this.driver = driver;
	}
	public LandingPage getLandingPage()
	{
		return new LandingPage(driver);
	}
	
	public OfferPage getOfferPage()
	{
		return new OfferPage(driver);
	}
	
	public CheckoutPage getCheckOutPage()
	{
		return new CheckoutPage(driver);
	}
}
