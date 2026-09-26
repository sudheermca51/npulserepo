package org.iitwf.hc.nexuspulse.tests;

import org.iitwf.hc.nexuspulse.AppLibrary;
import org.iitwf.hc.nexuspulse.BaseClass;
import org.iitwf.nexuspulse.patient.pages.HomePage;
import org.iitwf.nexuspulse.patient.pages.LoginPage;
import org.iitwf.nexuspulse.patient.pages.MessagesPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class TestMessages extends BaseClass {
	LoginPage loginPage;
	HomePage homePage;
	MessagesPage messagePage;
	
	@BeforeClass
	
	public void setup()
	{
		launchBrowser(prop.getProperty("url"));
		loginPage = new LoginPage(driver);
		loginPage.login(prop.getProperty("puname"),prop.getProperty("ppword"));
		homePage = new HomePage(driver);
		homePage.navigateToAModule("Messages");
	}
	
	@Test
	public void testSendMessage() {
		messagePage = new MessagesPage(driver);
		String randomMessage = AppLibrary.randomString("Msg");
		messagePage.sendMessage(randomMessage);
		
		String displayedMessage = messagePage.checkMessage(randomMessage);
		Assert.assertEquals(displayedMessage, randomMessage);
	}
	

}
