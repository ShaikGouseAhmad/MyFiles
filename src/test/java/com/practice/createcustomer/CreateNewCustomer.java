package com.practice.createcustomer;

import java.io.IOException;


import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.Test;

import com.practice.utilities.BaseClass;
import com.practice.utilities.ExcelOperation;
import com.practice.webpages.ActiveProjectsCustomersWebPage;
import com.practice.webpages.AddNewCustomer;
import com.practice.webpages.OpenTasksWebPage;


public class CreateNewCustomer extends BaseClass {
	
	
	@Test
	public void testCreateNewCustomer() throws EncryptedDocumentException, InvalidFormatException, IOException
	{
		OpenTasksWebPage  op=new OpenTasksWebPage();
		AddNewCustomer anp=new AddNewCustomer();
		ActiveProjectsCustomersWebPage  apc=new ActiveProjectsCustomersWebPage();
		ExcelOperation eo=new ExcelOperation();
		String s = eo.readData("Sheet1", 0, 0);
		log.info("****************************** click on retrive Data from Excel ******************************");
		op.clickonprojectAndCustomer();
		log.info("****************************** click on ProjectAndCustomer link ******************************");
		apc.clickonaddNewCustomer();
		log.info("****************************** click on  addNewCustomer Button  ******************************");
		anp.enterTextcustomerName(s);
		log.info("****************************** click on  enter customer Name ******************************");
		anp.clickoncreateCustomer();
		log.info("****************************** click on Createcustomer Button ******************************");
		apc.retrieveSuccessMessage();
		log.info("****************************** click on retrive message ******************************");
	}

}
