package org.iitwf.hc.nexuspulse;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtil {

	public static void captureScreenshot(WebDriver driver,String screenshotName) throws IOException
	{
		  
		    String timeStamp = AppLibrary.getFutureDate(0,"d_MMMMM_yyyy_H_m_s");
	        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	        FileUtils.copyFile(scrFile, new File(screenshotName+"_"+timeStamp));
	         
	}
}
