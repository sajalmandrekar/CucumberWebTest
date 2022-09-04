package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OfferPage {
	
	By search = By.xpath("//input[@type='search']");
	By productName = By.cssSelector("tr td:nth-child(1)");
	WebDriver driver;
	
	public OfferPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void searchItem(String shortName)
	{
		driver.findElement(search).sendKeys(shortName);
	}
	
	public String getItemName()
	{
		return driver.findElement(productName).getText();
	}
}
