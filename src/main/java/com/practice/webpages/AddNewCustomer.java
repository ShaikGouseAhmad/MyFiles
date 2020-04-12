package com.practice.webpages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.practice.utilities.BaseClass;

public class AddNewCustomer {
	
	@FindBy(name="name")
	private WebElement customerName;
	
	@FindBy(name="createCustomerSubmit")
	private WebElement createCustomer;
	
	
	public AddNewCustomer()
	{
		PageFactory.initElements(BaseClass.driver,this);
	}
	
	public void enterTextcustomerName(String Name)
	{
	     customerName.sendKeys(Name);	
	}
	
	public void clickoncreateCustomer()
	{
		createCustomer.click();
	}

}
