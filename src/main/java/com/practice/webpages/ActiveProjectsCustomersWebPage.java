package com.practice.webpages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.practice.utilities.BaseClass;

public class ActiveProjectsCustomersWebPage {
	
	@FindBy(xpath="//input[@value='Add New Customer']")
	private WebElement addNewCustomer;
	@FindBy(xpath="//input[@value='Add New Project']")
	private WebElement addNewProject;
	
	@FindBy(className="successmsg")
	private WebElement fetchSuccessMessage;
	
	public ActiveProjectsCustomersWebPage()
	{
		PageFactory.initElements(BaseClass.driver,this);
	}
	
	public void clickonaddNewCustomer()
	{
		addNewCustomer.click();
	}
	
	public void clickonaddNewProject()
	{
		addNewProject.click();
	}
	public String retrieveSuccessMessage()
	{
		String s = fetchSuccessMessage.getText();
		return s;
	}
	
}
