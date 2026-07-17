package org.iitwf.hc.nexuspulse;

public class Pay_fees {
	@Test
	public void validatePayFees()
	{
		 
		hPage.navigateToAModule("Pay Fees");
		String expectedAmount = AppLibrary.randomString("Amount");
		profilePage.editFirstName(expectedFName);
		profilePage.editLastName(expectedLName);
		profilePage.submitProfile();

}
