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

public class AT_TC007_Modularity_Fwk {

	WebDriver driver;
	@Test(description="Test case 7: Sort by Enrollments (ascending, numeric)")
	public void validateSortByEnrollments()
	{

		launchApp();
		List<Integer> expectedEnrollments= fetchAlltheEnrollmentValues();
		sortBy();
		List<Integer>actualEnrollments = fetchAlltheEnrollmentValues();
		Assert.assertEquals(actualEnrollments, expectedEnrollments);

	}
	public void launchApp()
	{
		driver = new ChromeDriver();
		driver.get("https://practicetestautomation.com/practice-test-table/");
		driver.manage().window().maximize();
	}
	public void sortBy()
	{
		//Fetching the Actual Values
		WebElement sortByLocator = driver.findElement(By.id("sortBy"));
		Select sortBySelect = new Select(sortByLocator);
		sortBySelect.selectByVisibleText("Enrollments");

	}
	public List<Integer> fetchAlltheEnrollmentValues()
	{
		List<WebElement> enrollmentList = driver.findElements(By.xpath("//table[@id='courses_table']/tbody/tr/td[5]"));
		List<Integer> sortedEnrollments = new ArrayList<Integer>();
		for(int i =0 ;i < enrollmentList.size();i++)
		{
			String enrollmentValue = enrollmentList.get(i).getText();
			System.out.println("Enrollment Value:: " +enrollmentValue );
			sortedEnrollments.add(Integer.parseInt(enrollmentValue));
		}

		Collections.sort(sortedEnrollments);

		System.out.println("######################Sorting the Expected Enrollments#######################");
		System.out.println(sortedEnrollments);
		return sortedEnrollments;


	}


}
