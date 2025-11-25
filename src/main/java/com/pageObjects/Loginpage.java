package com.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Loginpage extends BasePage {
	
	
	//constructor
	public Loginpage(WebDriver driver)
	{
		super(driver);
		
	}
	
	
	//Locators
	@FindBy(xpath = "//input[@id='input-email']")
	WebElement txtusername;
	
	@FindBy(xpath = "//input[@id='input-password']")
	WebElement txtpassword;
	
	@FindBy(xpath = "//input[@value='Login']")
	WebElement btnlogin;
	
	
	//Actions
	public void username(String usrname)
	{
		txtusername.sendKeys(usrname);
	}
	
	public void password(String pwd)
	{
		txtpassword.sendKeys(pwd);
	}
	
	public void loginbtn()
	{
	    btnlogin.click();
	}
	
	

}
