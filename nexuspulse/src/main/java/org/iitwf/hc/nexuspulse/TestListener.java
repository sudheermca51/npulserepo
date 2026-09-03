package org.iitwf.hc.nexuspulse;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener{
	public  void onTestSuccess(ITestResult result) {
	    // not implemented
		
		System.out.println("The Testcase is Passed- " + result.getMethod().getMethodName());
		Object instance = result.getInstance();
		
		BaseClass baseClass = (BaseClass) instance;
		
		try {
			ScreenshotUtil.captureScreenshot(baseClass.driver, result.getMethod().getMethodName());
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

}
