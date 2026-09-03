package org.iitwf.hc.nexuspulse.tests;

import org.iitwf.hc.nexuspulse.AppLibrary;
import org.iitwf.hc.nexuspulse.BaseClass;
import org.iitwf.nexuspulse.patient.pages.EditProfilePage;
import org.iitwf.nexuspulse.patient.pages.HomePage;
import org.iitwf.nexuspulse.patient.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class EditProfileTests extends BaseClass {

	 
	LoginPage lPage;
	HomePage hPage;
	EditProfilePage profilePage;
	@BeforeClass
	public void setUp()
	{
	
		launchBrowser(prop.getProperty("url"));
		lPage = new LoginPage(driver);
		lPage.login(prop.getProperty("puname"),prop.getProperty("ppword"));
		hPage = new HomePage(driver);
		profilePage = new EditProfilePage(driver);
		 
	}
	@Test
	public void validateEditFName()
	{
		hPage.navigateToAModule("Profile");
		String expectedFName = AppLibrary.randomString("FName");
		profilePage.editFirstName(expectedFName);
		profilePage.submitProfile();
		profilePage.handleAlerts();
		String actualFName = profilePage.getFirstName();
		Assert.assertEquals(actualFName, expectedFName);
	}
	@Test
	public void validateEditLName()
	{
		 
		hPage.navigateToAModule("Profile");
		String expectedLName = AppLibrary.randomString("LName");
		profilePage.editLastName(expectedLName);
		profilePage.submitProfile();
		profilePage.handleAlerts();
		String actualLName = profilePage.getLastName();
		Assert.assertEquals(actualLName, expectedLName);
	}
	@Test
	public void validateEditAllFields()
	{
		 
		hPage.navigateToAModule("Profile");
		String expectedLName = AppLibrary.randomString("LName");
		String expectedFName = AppLibrary.randomString("FName");
		profilePage.editFirstName(expectedFName);
		profilePage.editLastName(expectedLName);
		profilePage.submitProfile();
		profilePage.handleAlerts();
		String actualFName = profilePage.getFirstName();
		String actualLName = profilePage.getLastName();
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(actualLName, expectedLName);
		sa.assertEquals(actualFName, expectedFName);
		sa.assertAll();
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
