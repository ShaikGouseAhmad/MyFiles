package com.practice.webpages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.practice.utilities.BaseClass;

public class OpenTasksWebPage {
	@FindBy(linkText="Projects & Customers")
	private WebElement projectAndCustomer;

	public OpenTasksWebPage()
	{
		PageFactory.initElements(BaseClass.driver,this);
	}
	
	public void clickonprojectAndCustomer()
	{
		projectAndCustomer.click();
	}

}
