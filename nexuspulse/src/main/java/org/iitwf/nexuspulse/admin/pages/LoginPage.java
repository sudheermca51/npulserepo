package org.iitwf.nexuspulse.admin.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	WebDriver driver;
	private By usernameLoc = By.name("username");
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;		
	}
	public void adminLogin(String uName,String pWord) {
		 
		driver.findElement(usernameLoc).sendKeys(uName);
		driver.findElement(By.name("password")).sendKeys(pWord);
		driver.findElement(By.xpath("//button[@class='btn-primary']")).click();
	}
}
