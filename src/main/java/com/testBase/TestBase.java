package com.testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class TestBase {

 public static WebDriver driver;
 public Logger logger; 
 public Properties p;
	
 
	@BeforeClass(groups= {"Sanity","Regression","Master"})
    @Parameters({"browser"})
    public void setup(String br) throws IOException
    {
 		//Loading config.properties file
 		FileReader filep=new FileReader("./src//test//resources//config.properties");
 		p=new Properties();
 		p.load(filep);
 		
 		
		//Generate the logs
		logger=LogManager.getLogger(this.getClass());//******log4j2
		
		
		switch (br.toLowerCase()) 
		{
		case "chrome": driver=new ChromeDriver(); break;
		case "edge": driver=new EdgeDriver(); break;	
		case "firefox": driver=new FirefoxDriver(); break;	
		default:System.out.println();return;
		}
	
    	//driver=new ChromeDriver();
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    	driver.get(p.getProperty("appURL"));//getting url from properties file
    	driver.manage().window().maximize();
    }
	
 	
 	//Close Browser
	@AfterClass(groups= {"Sanity","Regression","Master"})
	public void teardown()
	{
		driver.quit();
	}
	
	
	//RanodomString
	public String randomstring()
	{
		String generatestring=RandomStringUtils.randomAlphabetic(5);
		return generatestring;
	}
	
	public String randomnumber()
	{
		String generatenumber=RandomStringUtils.randomNumeric(10);
		return generatenumber;
	}
	
	public String alphanumeric()
	{
		String generatestring=RandomStringUtils.randomAlphabetic(5);
		String generatenumber=RandomStringUtils.randomNumeric(10);
		return generatenumber+"@"+generatestring;
	}
	
//	public String CaptureScreen(String tname)
//	{
//		String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
//		
//		TakesScreenshot takescreenshot=(TakesScreenshot) driver;
//		File sourcefile=takescreenshot.getScreenshotAs(OutputType.FILE);
//		
//		String Targepathtfile=System.getProperty("user.dir")+"\\Screenshots\\" + tname + "_"+ timestamp + ".png";
//		File Targetfile=new File(Targepathtfile);
//		
//		sourcefile.renameTo(Targetfile);
//		return Targepathtfile;
//	}

}
