package com.practice.createproject;

import java.io.IOException;


import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.Test;

import com.practice.utilities.BaseClass;
import com.practice.utilities.ExcelOperation;
import com.practice.webpages.ActiveProjectsCustomersWebPage;
import com.practice.webpages.AddNewProject;
import com.practice.webpages.OpenTasksWebPage;


public class CreateNewProject extends BaseClass{
	
	@Test
	public void testCreateNewProject() throws EncryptedDocumentException, InvalidFormatException, IOException
	{
		OpenTasksWebPage  op=new OpenTasksWebPage();
		AddNewProject anp=new AddNewProject();
		ActiveProjectsCustomersWebPage  apc=new ActiveProjectsCustomersWebPage();
		ExcelOperation eo=new ExcelOperation();
		String s = eo.readData("Sheet1", 0, 1);
		String s1 = eo.readData("Sheet1", 0, 2);
		log.info("****************************** click on retrive Data from Excel ******************************");
		op.clickonprojectAndCustomer();
		log.info("****************************** click on ProjectAndCustomer link ******************************");
		apc.clickonaddNewProject();
		log.info("***************************** click on  addNewCustomer Button  ******************************");
		anp.selectcustomerName(s);
		log.info("****************************** click on  select Customer Name ******************************");
		anp.enterTextprojectName(s1);
		log.info("****************************** click on  enter project Name ******************************");
		anp.clickoncreateProjectSubmit();
		log.info("****************************** click on Createcustomer Button ******************************");
		apc.retrieveSuccessMessage();
		log.info("****************************** click on retrive message ******************************");
	}

}
