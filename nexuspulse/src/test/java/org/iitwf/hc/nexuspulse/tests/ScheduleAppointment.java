package org.iitwf.hc.nexuspulse.tests;

import java.util.List;
import java.util.NoSuchElementException;

import org.iitwf.hc.nexuspulse.AppLibrary;
import org.iitwf.hc.nexuspulse.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ScheduleAppointment extends BaseClass {
	WebDriver driver;
	 

	/*
	 * 
	 * 
	 */
	@Test(description="US04")
	public void validateScheduleAppointment()
	{
		 
		driver.get("http://82.197.92.72:8080/patient/login");
		driver.manage().window().maximize();

		driver.findElement(By.name("username")).sendKeys("patient1");
		driver.findElement(By.name("password")).sendKeys("Mmp@2025!Patient#93");
		driver.findElement(By.xpath("//button[@class='btn-primary']")).click();

		try {

			driver.findElement(By.xpath("//span[text()='Schedule Appointment']")).click();

			String expDoctorName="Dr. Arjun Heart";
			driver.findElement(By.xpath("//div[text()='"+expDoctorName+"']/following-sibling::div[text()='Cardiologist']")).click();
			System.out.println("Doctor is selected");


			driver.findElement(By.xpath("//input[@id='dateInput']/following-sibling::input[1]")).click();


			String expDate=AppLibrary.getFutureDate(250,"d/MMMMM/yyyy");
			String expectedDay = expDate.split("/")[0];
			String expectedMonth = expDate.split("/")[1];
			String expectedYear = expDate.split("/")[2];

			//String actualYear = driver.findElement(By.xpath("//div[@class='flatpickr-current-year']/select")).getText();

			Select monthSelect = new Select(driver.findElement(By.xpath("//select[@aria-label='Month']")));
			String actualMonth = monthSelect.getFirstSelectedOption().getText();



			while(!(expectedMonth.equals(actualMonth)))
			{
				driver.findElement(By.className("flatpickr-next-month")).click();
				actualMonth=monthSelect.getFirstSelectedOption().getText();
			}

			String actualYear = driver.findElement(By.className("numInputWrapper")).findElement(By.tagName("input")).getAttribute("value");


			while(!(expectedYear.equals(actualYear)))
			{
				driver.findElement(By.className("flatpickr-next-month")).click();
				actualYear = driver.findElement(By.className("numInputWrapper")).findElement(By.tagName("input")).getAttribute("value");

			}

			driver.findElement(By.xpath("//span[@class='flatpickr-day' and text()='"+expectedDay+"']")).click();
			Select hourSelect = new Select(driver.findElement(By.xpath("//select[@name='hour']")));
			hourSelect.selectByVisibleText("05");
			Select minSelect = new Select(driver.findElement(By.xpath("//select[@name='minute']")));
			minSelect.selectByVisibleText("30");
			String uniqueReason = AppLibrary.randomString("To Meet Doctor");
			driver.findElement(By.name("reason")).sendKeys(uniqueReason);
			String expReason = driver.findElement(By.name("reason")).getAttribute("value");
			String expTime= hourSelect.getFirstSelectedOption().getText()+":"+minSelect.getFirstSelectedOption().getText();
			expDate=AppLibrary.getFutureDate(250,"yyyy-MM-dd");
			driver.findElement(By.xpath("//button[text()='Create']")).submit();

			List<WebElement> actualRowData = driver.findElements(By.xpath("//table[@class='table-styled']/tbody/tr[td[text()='"+uniqueReason+"']]"));

			if(actualRowData.isEmpty())
			{
				throw new NoSuchElementException(" Not able to find the row with unique reason");
			}

			String actualString = actualRowData.get(0).getText();

			SoftAssert sa = new SoftAssert();
			sa.assertTrue(actualString.contains(expDoctorName));
			sa.assertTrue(actualString.contains(expReason));
			sa.assertTrue(actualString.contains(expTime));
			sa.assertTrue(actualString.contains(expDate));

			sa.assertAll();


		}
		catch(Exception e)
		{
			System.out.println(e);
		}

	}

}
