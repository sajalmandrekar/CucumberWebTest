package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {
	
	WebDriver driver;
	By checkoutButton = By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]");
	By cartImg = By.cssSelector("[alt='Cart']");
	By promoButton = By.cssSelector(".promoBtn");
	By placeOrder = By.xpath("//button[contains(text(),'Place Order')]");
	By productName = By.xpath("//*[@id=\"productCartTables\"]/tbody/tr/td[2]/p");
	
	public CheckoutPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void checkoutItems()
	{
		//clicks Cart Image
		//clicks Proceed to checkout
		driver.findElement(cartImg).click();
		driver.findElement(checkoutButton).click();
	}
	
	public Boolean verifyPromoButton()
	{
		return driver.findElement(promoButton).isDisplayed();
	}

	public Boolean verifyPlaceOrderButton()
	{
		return driver.findElement(placeOrder).isDisplayed();
	}
	
	public String getProductName()
	{
		return driver.findElement(productName).getText().split("-")[0].trim();
	}
	
}
