package com.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.pageObjects.AccountRegistration;
import com.pageObjects.HomePage;
import com.testBase.TestBase;

public class TC001_AccountRegistration extends TestBase {
	
	@Test(groups={"Sanity","Master"})
	public void accountreagistrationverify() throws InterruptedException
	{
		
		logger.info("*********Starting Accountregitration testcase**********");
		
		try
		{
		HomePage hp=new HomePage(driver);
		hp.account();
		logger.info("click on myaccount");
		
		hp.registeration();
		logger.info("click on register");
		
		
		AccountRegistration acc=new AccountRegistration(driver);
		logger.info("Providing customer details");
		acc.setfirstname(randomstring().toUpperCase());
		acc.setlastname(randomstring().toUpperCase());
		acc.setemail(randomstring()+"@gmail.com");
		acc.settelephoneno(randomnumber());
		String pwdd=alphanumeric();
		acc.setpassword(pwdd);
		acc.setconfirmpassword(pwdd);
		acc.policy();
		acc.continu();
		Thread.sleep(2000);
		//acc.confirmationmsg();
		
		logger.info("Valaidating confirmation message");
		String msg=acc.confirmationmsg();
		
		if(msg.equals("Your Account Has Been Created!"))
				{
					Assert.assertTrue(true);
				}
		else
		{
			logger.error("Test failed");
			logger.debug("Debug logs");
			Assert.assertTrue(false);
		}
		
		
		//Assert.assertEquals(msg,"Your Account Has Been Created!!!");
	}
	
	catch(Exception e)
	{
		 logger.error("Exception occurred during login test: " + e.getMessage(), e);
		 Assert.fail("Test failed due to exception: " + e.getMessage());
		//Assert.fail();
	}
		logger.info("Account regstration test is finished");
	}
	


}
