package com.utilities;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.testBase.TestBase;

public class ScreenshotList extends TestBase implements ITestListener{

	  @Override
	    public void onTestFailure(ITestResult result) {
		  CaptureScreen(result.getName());
	        System.out.println("Screenshot captured for failed test: " + result.getName());
	    }
}
