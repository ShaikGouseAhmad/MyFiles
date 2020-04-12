package com.practice.webpages;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.practice.utilities.BaseClass;

public class AddNewProject {
	
	@FindBy(name="customerId")
	private WebElement customerName;
	
	@FindBy(name="name")
	private WebElement projectName;
	
	@FindBy(name="createProjectSubmit")
	private WebElement createProjectsSubmit;

	public AddNewProject()
	{
		PageFactory.initElements(BaseClass.driver,this);
	}
	
	public void selectcustomerName(String customername)
	{
		Select s1=new Select(customerName); 
		s1.selectByVisibleText(customername);
	}
	
	public void enterTextprojectName(String name)
	{
		projectName.sendKeys(name);
	}
	public void clickoncreateProjectSubmit()
	{
		createProjectsSubmit.click();
	}
}
