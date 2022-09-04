package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {
	
	WebDriver driver;
	
	public WebDriver WebDriverManager() throws IOException
	{
		File fl = new File(System.getProperty("user.dir")+"//src//test//resources//global.properties");
		FileInputStream fin = new FileInputStream(fl);
		
		Properties prop = new Properties();
		prop.load(fin);
		
		String url = prop.getProperty("QAUrl");
		String browser_prop = prop.getProperty("browser");
		String browser_cli = System.getProperty("browser");
		String browser_name = browser_cli!=null?browser_cli:browser_prop;
		
		if(driver == null)
		{
			if(browser_name.equalsIgnoreCase("chrome"))
			{
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//src//test//resources//chromedriver.exe");
				driver = new ChromeDriver();
			}
			else if(browser_name.equalsIgnoreCase("firefox"))
			{
				System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"//src//test//resources//geckodriver.exe");
				driver = new FirefoxDriver();
			}
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			driver.get(url);
		}
		return driver;
	}
	
	public String getCurrentUrl()
	{
		return driver.getCurrentUrl();
	}
}
