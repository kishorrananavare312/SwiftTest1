package com.utilities;

import java.util.Date;
import java.util.List;
import java.awt.Desktop;
import java.io.File;
import java.text.SimpleDateFormat;


import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.testBase.TestBase;

//public class ExtentReportManager implements ITestListener {
//
//	public ExtentSparkReporter sparkreporter;
//	public ExtentReports extent;
//	public ExtentTest test;
//	
//	String repname;
//	
//	public void onStart(ITestContext context)
//	{
//		/*
//		SimpleDateFormat df=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
//		Date dt=new Date();
//		String currenttimedatestamp=df.format(dt);
//		*/
//		
//		
//		String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
//		repname="Test-Report-"+ timestamp + ".html";
//		
//		
//		sparkreporter=new ExtentSparkReporter(System.getProperty("user.dir") + "/Reports/" + repname);
//		sparkreporter.config().setDocumentTitle("opencart application report");
//		sparkreporter.config().setReportName("opencart functional testing");
//		sparkreporter.config().setTheme(Theme.DARK);
//		
//		extent=new ExtentReports();
//		extent.attachReporter(sparkreporter);
//		extent.setSystemInfo("Application", "opencart");
//		extent.setSystemInfo("Module", "admin");
//		extent.setSystemInfo("Submodule", "customer");
//		extent.setSystemInfo("User Name", System.getProperty("user.name"));
//		extent.setSystemInfo("Enviorement", "QA");
//		
//		String browser=context.getCurrentXmlTest().getParameter("browser");
//		extent.setSystemInfo("Browser", browser);
//		
//		
//	    List<String> includegroups=context.getCurrentXmlTest().getIncludedGroups();
//	    if(!includegroups.isEmpty())
//	    {
//	    	extent.setSystemInfo("Groups", includegroups.toString());
//	    }		
//	}
//	
//	public void onTestSuccess(ITestResult result)
//	{
//		test = extent.createTest(result.getTestClass().getName());
//		test.assignCategory(result.getMethod().getGroups());//to display groups in reports
//		test.log(Status.PASS,result.getName()+ "got successfully executed");
//	}
//	
//	public void onTestFailed(ITestResult result)
//	{
//		test = extent.createTest(result.getTestClass().getName());
//		test.assignCategory(result.getMethod().getGroups());//to display groups in reports
//		test.log(Status.FAIL,result.getName()+"got Failed");
//		test.log(Status.INFO,result.getThrowable().getMessage());
//		
//		try {
//			String imgpath = new TestBase().CaptureScreen(result.getName());
//			test.addScreenCaptureFromPath(imgpath);
//		}
//		catch (Exception e) {
//				e.printStackTrace();
//		}
//	}
//	
//	public void onTestSkipped(ITestResult result)
//	{
//		test = extent.createTest(result.getTestClass().getName());
//		test.assignCategory(result.getMethod().getGroups());
//		test.log(Status.SKIP,result.getName()+"got Failed");
//		test.log(Status.INFO,result.getThrowable().getMessage());
//	}
//	
//	public void onTestFinish(ITestResult result)
//	{
//		extent.flush();
//		String pathofextetreport=System.getProperty("user.dir") + "/Reports/" + repname;
//		File extentReport=new File(pathofextetreport);
//		
//		try
//		{
//			Desktop.getDesktop().browse(extentReport.toURI());
//		}
//		catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//	
//}
