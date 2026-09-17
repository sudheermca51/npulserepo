package org.iitwf.hc.nexuspulse;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class TestListener implements ITestListener{
	
	ExtentReports extentReport = ExtentUtil.createExtentInstance();
	
	private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();
	
	public void onTestStart(ITestResult result)
	{
		ExtentTest test = extentReport.createTest("TestCase Name"+ result.getName());
		extentTest.set(test);
	}
	
	public  void onTestSuccess(ITestResult result) {
	    // not implemented
		
		System.out.println("The Testcase is Passed- " + result.getMethod().getMethodName());
		Object instance = result.getInstance();
		
		BaseClass baseClass = (BaseClass) instance;
		extentTest.get().log(Status.PASS, result.getMethod().getMethodName()+" is PASSED");
		
		try {
			String screenshotPath = ScreenshotUtil.captureScreenshot(baseClass.driver, result.getMethod().getMethodName());
			extentTest.get().addScreenCaptureFromPath(screenshotPath, result.getMethod().getMethodName()+"TestCase Evidence");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  }
	public  void onTestFailure(ITestResult result) {
	    // not implemented
		
		System.out.println("The Testcase is failed- " + result.getMethod().getMethodName());
		Object instance = result.getInstance();
		
		BaseClass baseClass = (BaseClass) instance;
		
		try {
			ScreenshotUtil.captureScreenshot(baseClass.driver, result.getMethod().getMethodName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  }
	public void onFinish(ITestContext context) {
		
		extentReport.flush();
	}

}
