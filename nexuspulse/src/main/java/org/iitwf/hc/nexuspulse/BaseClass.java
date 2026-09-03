package org.iitwf.hc.nexuspulse;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

public class BaseClass implements ITestListener {

	protected WebDriver driver;
	protected Properties prop;
	String environment,browserType;
	
	
	
	@BeforeTest
	public void loadProperties() throws IOException
	{
		prop = AppLibrary.readConfig("global.properties");
		environment = prop.getProperty("environment");
		browserType = prop.getProperty("browserType");
		if(environment.equals("qa"))
		{
			prop =  AppLibrary.readConfig("qa.properties");
		}
		else if(environment.equals("stage"))
		{
			prop =  AppLibrary.readConfig("stage.properties");
		}
		else
		{
			prop =  AppLibrary.readConfig("prod.properties");
		}
	}
	@BeforeClass
	public void instantiateDriver() throws IOException
	{
		DriverFactory.initDriver(browserType);
		driver= DriverFactory.getDriver();
		 
	}
	public void launchBrowser(String url)
	{
		driver.get(url);
		driver.manage().window().maximize();
		
	}
}
