package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage {

	By search = By.xpath("//input[@type='search']");
	By productName = By.cssSelector("h4.product-name");
	By increment = By.cssSelector("a.increment");
//	By add_to_cart = By.xpath("//button[contains(text(),'ADD TO CART')]");
	By add_to_cart = By.cssSelector(".product-action button");
	WebDriver driver;
	
	public LandingPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void searchItem(String shortName)
	{
		driver.findElement(search).sendKeys(shortName);
	}
	
	public String getItemName()
	{
		return driver.findElement(productName).getText().split("-")[0].trim();
	}
	
	public void clickText(String text)
	{
		driver.findElement(By.linkText(text)).click();
	}
	
	public String getTitle()
	{
		return driver.getTitle();
	}
	
	public void incrementQuantity(int quantity)
	{
		for(int i=1;i<=quantity;i++)
			driver.findElement(increment).click();
	}
	
	public void addToCart()
	{
		driver.findElement(add_to_cart).click();
	}
}
