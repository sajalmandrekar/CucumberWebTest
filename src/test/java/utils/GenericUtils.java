package utils;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;

public class GenericUtils {
	
	WebDriver driver;
	
	public GenericUtils(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void switchToChildTab()
	{
		Set<String> s1=driver.getWindowHandles();
		Iterator<String> itr = s1.iterator();
		itr.next();
		String childWindow = itr.next();
		driver.switchTo().window(childWindow);
	}
	
	public void closeAllTabs()
	{
		Set<String> s1=driver.getWindowHandles();
		Iterator<String> itr = s1.iterator();
		
		while(itr.hasNext())
		{
			String childWindow = itr.next();
			driver.switchTo().window(childWindow);
			driver.close();
		}
	}
}
