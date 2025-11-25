package com.testCases;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.pageObjects.HomePage;
import com.pageObjects.Loginpage;
import com.pageObjects.Myaccountpage;
import com.testBase.TestBase;


@Listeners(com.utilities.ScreenshotList.class)
public class TC002_UserLogin extends TestBase{

	@Test(groups={"Regression","Master"})
	public void userlogin()
	{
		logger.info("*********Starting UserLogin testcase**********");
		
		try
		{
		HomePage hp=new HomePage(driver);
		hp.account();
		logger.info("click on myaccount");
		
		hp.login();
		logger.info("click on Login");
	
	    Loginpage log=new Loginpage(driver);
	    
	    logger.info("Providing login details");
	    log.username(p.getProperty("Username"));//property file
	    log.password(p.getProperty("password"));
	    log.loginbtn();
	    
	    logger.info("Valaidating confirmation message");
	    Myaccountpage myacc=new Myaccountpage(driver);
	    boolean confirmationpage=myacc.confirmmyaccount();
	    
	    Assert.assertTrue(confirmationpage);
	    logger.info("Login Successfully");
	    
	    
	    		
		}
		catch (AssertionError ae) {
		    logger.error("Exception occurred during login test: " + ae.getMessage());
		    String screenshotPath = CaptureScreen("UserLoginFailure");
		    logger.info("Screenshot taken: " + screenshotPath);
		    Assert.fail("Assertion Failed: " + ae.getMessage());
		    
		}
	    
		logger.info("login test is finished");
	    
		
	}

}
