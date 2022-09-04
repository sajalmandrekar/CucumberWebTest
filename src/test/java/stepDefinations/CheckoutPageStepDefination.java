package stepDefinations;

import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pageObjects.CheckoutPage;
import utils.TestContextSetup;

public class CheckoutPageStepDefination {
	
	TestContextSetup testContextSetup;
	CheckoutPage checkoutPage;
	
	public CheckoutPageStepDefination(TestContextSetup testContextSetup)
	{
		this.testContextSetup = testContextSetup;
		this.checkoutPage = testContextSetup.pageObjectManager.getCheckOutPage();
	}
	
	@Then("^user proceeds to checkout page and validates the (.*) of ordered item$")
	public void user_proceeds_to_checkout_page_and_validates(String shortName) throws InterruptedException
	{
		checkoutPage.checkoutItems();
		
		//search product name and check if it matches
		String productNameCheckout = checkoutPage.getProductName();
		String orderedProduct = testContextSetup.productNameHome;
	
		Assert.assertEquals(productNameCheckout, orderedProduct);
	}
	
	@And("verify the ability to enter promo code and place order")
	public void verify_the_ability_to_enter_promo_code_and_place_order()
	{
		Assert.assertTrue(checkoutPage.verifyPlaceOrderButton());
		Assert.assertTrue(checkoutPage.verifyPromoButton());
	}
}
