package com.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.pageObjects.HomePage;
import com.pageObjects.Loginpage;
import com.pageObjects.Myaccountpage;
import com.testBase.TestBase;

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
	    		
		}
		catch (Exception e) {
			Assert.fail();
		}
	    
		logger.info("login test is finished");
	    
		
	}

}
