package org.iitwf.hc.nexuspulse.tests;

import org.iitwf.hc.nexuspulse.BaseClass;
import org.iitwf.nexuspulse.patient.pages.HomePage;
import org.iitwf.nexuspulse.patient.pages.LoginPage;
import org.iitwf.nexuspulse.patient.pages.PayFeesPage;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class PayFeesTests extends BaseClass {

    LoginPage lPage;
    HomePage hPage;
    PayFeesPage payFeesPage;

    @BeforeClass
    public void setUp() {

        launchBrowser(prop.getProperty("url"));

        lPage = new LoginPage(driver);

        lPage.login(
                prop.getProperty("puname"),
                prop.getProperty("ppword")
        );

        hPage = new HomePage(driver);

        payFeesPage = new PayFeesPage(driver);
    }

    @Test
    public void validateFirstFeeRecord() {

        hPage.navigateToAModule("Fees");

        String expectedAppointmentDate =
                "2025-12-05T22:16:59.589355";

        String expectedAmount = "500.00";

        String actualAppointmentDate =
                payFeesPage.getFirstAppointmentDate();

        String actualAmount =
                payFeesPage.getFirstAmount();

        SoftAssert sa = new SoftAssert();

        sa.assertEquals(
                actualAppointmentDate,
                expectedAppointmentDate,
                "Appointment date does not match"
        );

        sa.assertEquals(
                actualAmount,
                expectedAmount,
                "Amount does not match"
        );

        sa.assertAll();
    }
}