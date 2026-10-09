package org.iitwf.hc.nexuspulse.tests;

import org.iitwf.hc.nexuspulse.BaseClass;
import org.iitwf.nexuspulse.admin.pages.LoginPage;
import org.iitwf.nexuspulse.admin.pages.MessagesPage;
import org.iitwf.nexuspulse.patient.pages.EditProfilePage;
import org.iitwf.nexuspulse.patient.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestAdminMessages extends BaseClass {
	
	LoginPage loginPage;
	MessagesPage messagesPage;
	
	@BeforeClass
	public void setUp()
	{
	
		launchBrowser(prop.getProperty("adminUrl"));
		LoginPage loginPage = new LoginPage(driver);
		loginPage.adminLogin(prop.getProperty("adminuname"),prop.getProperty("adminpword"));
		driver.navigate().refresh(); // Refresh the page to ensure the sidebar is loaded
		loginPage.navigateSidebarMenu("Messages");
		 
	}
	
	@Test
	
	public void testSendMessageToPatient() {
		
		// Create an instance of MessagesPage
		MessagesPage messagesPage = new MessagesPage(driver);
		
		// Send a message to a specific patient
		String patientName = "Alex A"; // Replace with the actual patient name
		String message = "Msg190Vi";
		messagesPage.sendMessageToPatient(patientName, message);
		
		System.out.println("Message " + message + " sent to patient: " + patientName);


}
}
