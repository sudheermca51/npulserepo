package org.iitwf.nexuspulse.admin.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MessagesPage {
	WebDriver driver;
	
	
	public MessagesPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void verifyPatientMessage(String patientName, String expectedMessage) {
		// Locate the message element for the specified patient
		WebElement messageElement = driver.findElement(By.xpath("//td[text()='" + patientName + "']/following-sibling::td[1]"));
		
		// Get the actual message text
		String actualMessage = messageElement.getText();
		
		// Verify that the actual message matches the expected message
		if (!actualMessage.equals(expectedMessage)) {
			throw new AssertionError("Expected message: " + expectedMessage + ", but found: " + actualMessage);
		}
	}
	
	public void sendMessageToPatient(String patientName, String message) {
		// Locate the message input field for the specified patient
		
	   WebElement viewButton = driver.findElement(By.xpath("//td[text()='" + patientName + "']/following-sibling::td[3]"));
	   viewButton.click();
		
	   WebElement messageInput = driver.findElement(By.xpath("//input[@name='text']"));
		
		// Enter the message
		messageInput.sendKeys(message);
		
		// Locate and click the send button for the specified patient
		WebElement sendButton = driver.findElement(By.xpath("//button[normalize-space()='Send']"));
		sendButton.click();
	}

}
