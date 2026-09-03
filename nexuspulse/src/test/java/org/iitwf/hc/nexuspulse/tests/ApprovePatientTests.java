package org.iitwf.hc.nexuspulse.tests;

import org.iitwf.hc.nexuspulse.BaseClass;
import org.iitwf.nexuspulse.admin.pages.LoginPage;
import org.iitwf.nexuspulse.admin.pages.PatientApprovalPage;
import org.iitwf.nexuspulse.patient.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ApprovePatientTests extends BaseClass{


	LoginPage lPage;
	HomePage hPage;
	PatientApprovalPage pApprovalPage;
	@BeforeClass
	public void setUp()
	{

		launchBrowser(prop.getProperty("adminurl"));
		lPage = new LoginPage(driver);
		lPage.adminLogin(prop.getProperty("adminuname"),prop.getProperty("adminpword"));
		hPage = new HomePage(driver);
		pApprovalPage = new PatientApprovalPage(driver);
	}
	@Test
	public void validateApprovePatientTests()
	{
		hPage.navigateToAModule("Patients");
		pApprovalPage.approvePatient("dsdsdsd");
		String actualData = pApprovalPage.fetchApprovedStatusMessage("dsdsdsd");
		Assert.assertTrue(actualData.contains("Approved"));

	}
}