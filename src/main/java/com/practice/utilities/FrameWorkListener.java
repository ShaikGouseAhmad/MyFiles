package com.practice.utilities;


import java.io.File;


import java.io.IOException;
import java.text.SimpleDateFormat;

import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class FrameWorkListener extends TestListenerAdapter {
	
	ExtentHtmlReporter reporter;
	ExtentReports extent;
	ExtentTest test;
	
	@Override
	public void onStart(ITestContext rv)
	{
		String date = new SimpleDateFormat("yyyy-MM-dd hh-mm-ss").format(new Date());
		String ReportName = "Test-Report"+date+".html";
		
		reporter=new ExtentHtmlReporter(System.getProperty("user.dir")+"//test-output//"+ReportName);
		reporter.config().setDocumentTitle("DemoTitle");
		reporter.config().setReportName("Build 1 Result");
		reporter.config().setTheme(Theme.DARK);
		 extent=new ExtentReports();
		 extent.attachReporter(reporter);
		 extent.setSystemInfo("QA","Shaik Gouse Ahmad");
		 extent.setSystemInfo("Environment", "ChromeBrowser .58");
		 extent.setSystemInfo("OS", "Windows 10");
		 
		 
		
	}
	@Override
	public void onFinish(ITestContext rv)
	{
		extent.flush();
	}
	@Override
	public void onTestStart(ITestResult rv)
	{
		test = extent.createTest(rv.getName());
	}
	@Override
	public void onTestSuccess(ITestResult rv)
	{
		test.log(Status.PASS,MarkupHelper.createLabel("SuccessFully executed",ExtentColor.GREEN));
	}
	@Override
	public void onTestFailure(ITestResult rv)
	{
		test.log(Status.FAIL,MarkupHelper.createLabel("Method Failed",ExtentColor.RED));
		
		EventFiringWebDriver efw=new EventFiringWebDriver(BaseClass.driver);
		File f1=efw.getScreenshotAs(OutputType.FILE);
		String date = new SimpleDateFormat("yyyy-MM-dd hh-mm-ss").format(new Date());
		String path = System.getProperty("user.dir")+"//ScreenShot//"+date+".jpg";
		File f2=new File(path);
		try {
			FileUtils.copyFile(f1,f2);
			test.addScreenCaptureFromPath(path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	@Override
	public void onTestSkipped(ITestResult rv)
	{
		test.log(Status.SKIP, MarkupHelper.createLabel("Method Skipped",ExtentColor.ORANGE));
	}
	
	
}
