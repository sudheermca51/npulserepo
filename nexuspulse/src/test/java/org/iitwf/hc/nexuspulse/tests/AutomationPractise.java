package org.iitwf.hc.nexuspulse.tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AutomationPractise {
	
	static WebDriver driver;
	public static void main(String[] args) {
		
		driver = new ChromeDriver();
		driver.get("https://practicetestautomation.com/practice-test-table/");
		WebElement bCheckbox = driver.findElement(By.xpath("//input[@value='Beginner']"));
		bCheckbox.click();
		
		Duration d = Duration.ofSeconds(10);
		WebDriverWait wait = new WebDriverWait(driver,d);
		WebElement resetWE = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("resetFilters")));
		resetWE.click();
		
		driver.findElement(By.xpath("//div[@id='enrollDropdown']/div")).click();
		driver.findElement(By.xpath("//ul[@role='listbox']/li[text()='50,000+']")).click();	 
		

		selectAnyValue("5,000+");
		selectAnyValue("10,000+");
	}
	public static void selectAnyValue(String value)
	{
		driver.findElement(By.xpath("//div[@id='enrollDropdown']/div")).click();
		driver.findElement(By.xpath("//ul[@role='listbox']/li[text()='"+value+"']")).click();

	}

}
