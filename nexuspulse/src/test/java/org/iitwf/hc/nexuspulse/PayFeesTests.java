package org.iitwf.hc.nexuspulse;

import org.iitwf.nexuspulse.patient.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PayFeesTests extends BaseClass{
	
	HomePage hPage;
	 
	@BeforeClass
	public void intializePageObjects()
	{
		hPage = new HomePage(driver);
		
	}
	@Test
	public void validatePayFees()
	{
		hPage.navigateToAModule("Pay Fees");
		String expectedAmount = "100";
//		payFeesPage.enterAmount(expectedAmount);
//		payFeesPage.submitPayment();
//		payFeesPage.handleAlerts();
//		String actualAmount = payFeesPage.getPaidAmount();
//		Assert.assertEquals(actualAmount, expectedAmount);
	}
	
	@Test
	public void validatePayFees1()
	{
		hPage.navigateToAModule("Pay Fees");
		String expectedAmount = "100";
//		payFeesPage.enterAmount(expectedAmount);
//		payFeesPage.submitPayment();
//		payFeesPage.handleAlerts();
//		String actualAmount = payFeesPage.getPaidAmount();
//		Assert.assertEquals(actualAmount, expectedAmount);
	}

}
