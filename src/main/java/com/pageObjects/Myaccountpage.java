package com.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Myaccountpage extends HomePage{
	
	//constructor
	public Myaccountpage(WebDriver driver)
	{
		super(driver);
	}
	
	
	//Locators
	@FindBy(xpath = "//h2[normalize-space()='My Account']")
	WebElement myaccountmsg;
	
	
	//Action
	public boolean confirmmyaccount()
	{
		try
		{
			return (myaccountmsg.isDisplayed());
		}
		catch (Exception e) {
			return false;
		}
	}
	

}
