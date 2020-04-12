package com.practice.utilities;

import java.io.FileInputStream;


import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;


@Listeners(com.practice.utilities.FrameWorkListener.class)
public class BaseClass {
	
	public static WebDriver driver;
	FileInputStream fis;
	Properties p1;
	public static Logger log;
	@BeforeTest
	public void openBrowser() throws IOException
	{
		log=LogManager.getLogger(BaseClass.class);
		String path = System.getProperty("user.dir")+"//drivers//chromedriver.exe";
		System.setProperty("webdriver.chrome.driver",path);
		driver=new ChromeDriver();
		String path2 = System.getProperty("user.dir")+"//App.Properties";
		fis=new FileInputStream(path2);
		p1=new Properties();
		p1.load(fis);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(p1.getProperty("url"));
		log.info("*****************Open Browser Successfully************************");
	}
	@BeforeClass
	public void loginPage()
	{
		driver.findElement(By.name("username")).sendKeys(p1.getProperty("username"));
		driver.findElement(By.name("pwd")).sendKeys(p1.getProperty("password"));
		driver.findElement(By.xpath("//input[@valign='absmiddle']")).click();
		log.info("*****************login completed************************");
	}
	@AfterClass
   public void logOut()
   {
	   driver.findElement(By.className("logoutImg")).click();
	   log.info("*****************logout successfully************************");
   }
   @AfterTest
   public void  closeBrowser()
   {
	   driver.close();
	   log.info("*****************Close Browser************************");
   }
}
