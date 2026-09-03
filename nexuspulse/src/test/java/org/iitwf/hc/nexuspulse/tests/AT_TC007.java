package org.iitwf.hc.nexuspulse.tests;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AT_TC007 {


	@Test(description="Test case 7: Sort by Enrollments (ascending, numeric)")
	public void validateSortByEnrollments()
	{

		WebDriver driver = new ChromeDriver();
		driver.get("https://practicetestautomation.com/practice-test-table/");
		driver.manage().window().maximize();
		
		List<WebElement> enrollmentList = driver.findElements(By.xpath("//table[@id='courses_table']/tbody/tr/td[5]"));
		List<Integer> expectedEnrollments = new ArrayList<Integer>();
		for(int i =0 ;i < enrollmentList.size();i++)
		{
			String enrollmentValue = enrollmentList.get(i).getText();
			System.out.println("Enrollment Value:: " +enrollmentValue );
			expectedEnrollments.add(Integer.parseInt(enrollmentValue));
		}
		
		Collections.sort(expectedEnrollments);
		
		System.out.println("######################Sorting the Expected Enrollments#######################");
		System.out.println(expectedEnrollments);


		//Fetching the Actual Values
		WebElement sortByLocator = driver.findElement(By.id("sortBy"));
		Select sortBySelect = new Select(sortByLocator);
		sortBySelect.selectByVisibleText("Enrollments");


	    enrollmentList = driver.findElements(By.xpath("//table[@id='courses_table']/tbody/tr/td[5]"));
		List<Integer> actualEnrollments = new ArrayList<Integer>();
		for(int i =0 ;i < enrollmentList.size();i++)
		{
			String enrollmentValue = enrollmentList.get(i).getText();
			System.out.println("Enrollment Value:: " +enrollmentValue );
			actualEnrollments.add(Integer.parseInt(enrollmentValue));
		}
		Collections.sort(actualEnrollments);
		
		System.out.println("######################Sorting the Actual Enrollments#######################");
		System.out.println(actualEnrollments);
		
		
		Assert.assertEquals(actualEnrollments, expectedEnrollments);
		
	}

}
