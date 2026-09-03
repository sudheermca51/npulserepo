package org.iitwf.hc.nexuspulse.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class NavigationMethods {

	@Test
	public void validate_navigation()
	{
		WebDriver driver = new ChromeDriver();
		
		// Open site
		driver.get("https://selenium.dev"); 

		// Navigate to another page
		driver.navigate().to("https://google.com"); 

		// Use browser history
		driver.navigate().back(); 
		driver.navigate().forward(); 
		driver.navigate().refresh();
	}
}
