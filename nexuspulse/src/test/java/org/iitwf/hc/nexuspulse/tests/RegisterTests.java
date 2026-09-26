package org.iitwf.hc.nexuspulse.tests;

import org.iitwf.hc.nexuspulse.BaseClass;
import org.iitwf.nexuspulse.patient.pages.LoginPage;
import org.iitwf.nexuspulse.patient.pages.RegisterPage;
import org.testng.annotations.Test;

public class RegisterTests extends BaseClass{

	@Test
	public void validateEditFName()
	{
		launchBrowser(prop.getProperty("url"));
		LoginPage lPage = new LoginPage(driver);
		RegisterPage rPage = lPage.register();
		String actual = rPage.registerPatient();
		System.out.println("Actual::: " + actual);
		
		
	}
}
