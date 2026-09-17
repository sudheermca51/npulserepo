package org.iitwf.hc.nexuspulse;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentUtil {
	
	static ExtentSparkReporter sparkReporter;
	static ExtentReports extentReport;
	public static ExtentReports createExtentInstance()
	{
		String reportPath = System.getProperty("user.dir")+"/target/ExtentReport.html";
		sparkReporter = new ExtentSparkReporter(reportPath);
		sparkReporter.config().setReportName("NexusPulse Regression Test Results");
		sparkReporter.config().setDocumentTitle("NexusPulse Regression Test Results");
		
		extentReport = new ExtentReports();
		extentReport.attachReporter(sparkReporter);
		return extentReport;
		
	}

}
