package org.iitwf.nexuspulse.patient.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PayFeesPage {

    WebDriver driver;

    public PayFeesPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getFirstAppointmentDate() {

        return driver.findElement(
                By.xpath("(//table//tbody/tr)[1]/td[1]")
        ).getText().trim();
    }

    public String getFirstAmount() {

        return driver.findElement(
                By.xpath("(//table//tbody/tr)[1]/td[4]")
        ).getText().trim();
    }

    public String getFirstStatus() {

        return driver.findElement(
                By.xpath("(//table//tbody/tr)[1]/td[5]")
        ).getText().trim();
    }
}