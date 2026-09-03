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

public class AT_TC007_DataDriven_Fwk {

	WebDriver driver;
	@Test(description="Test case 7: Sort by Enrollments (ascending, numeric)")
	public void validateSortByEnrollments()
	{

		launchApp("https://practicetestautomation.com/practice-test-table/");
		//Column Index is 5 for Enrollments
		List<Integer> expectedEnrollments= fetchAlltheCourseTableValues(5);
		sortBy("Enrollments");
		List<Integer>actualEnrollments = fetchAlltheCourseTableValues(5);
		Assert.assertEquals(actualEnrollments, expectedEnrollments);

	}
	@Test(description="Test case 7: Sort by ID (ascending, numeric)")
	public void validateSortByID()
	{

		launchApp("https://practicetestautomation.com/practice-test-table/");
		//Column Index is 5 for Enrollments
		List<Integer> expectedID= fetchAlltheCourseTableValues(1);
		sortBy("ID");
		List<Integer>actualID= fetchAlltheCourseTableValues(1);
		Assert.assertEquals(actualID, expectedID);

	}
 
	public void launchApp(String url)
	{
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
	}
	public void sortBy(String sortByCriteria)
	{
		//Fetching the Actual Values
		WebElement sortByLocator = driver.findElement(By.id("sortBy"));
		Select sortBySelect = new Select(sortByLocator);
		sortBySelect.selectByVisibleText(sortByCriteria);

	}
	public List<Integer> fetchAlltheCourseTableValues(int columnIndex)
	{
		List<WebElement> courseTableList = driver.findElements(By.xpath("//table[@id='courses_table']/tbody/tr/td["+columnIndex+"]"));
		List<Integer> sortedCourseValues= new ArrayList<Integer>();
		for(int i =0 ;i < courseTableList.size();i++)
		{
			String courseValue = courseTableList.get(i).getText();
			System.out.println("Table Value:: " +courseValue );
			sortedCourseValues.add(Integer.parseInt(courseValue));
		}

		Collections.sort(sortedCourseValues);

		System.out.println("######################Sorting the Expected Enrollments#######################");
		System.out.println(sortedCourseValues);
		return sortedCourseValues;


	}


}
