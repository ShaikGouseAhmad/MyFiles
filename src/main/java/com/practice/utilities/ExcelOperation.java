package com.practice.utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelOperation {
	
	String path;
	public String readData(String sheetName,int rowNo,int cellNo) throws EncryptedDocumentException, InvalidFormatException, IOException
	{
		
		path = System.getProperty("user.dir")+"//test-data//userdata.xlsx";
		FileInputStream  fis=new FileInputStream(path);
	          String s1 = WorkbookFactory.create(fis).getSheet(sheetName).getRow(rowNo).getCell(cellNo).getStringCellValue();
	       return s1;
	}
    public void writeData(String sheetName,int rowNo,int cellNo,String setString) throws EncryptedDocumentException, InvalidFormatException, IOException
    {
    	path = System.getProperty("user.dir")+"//test-data//userdata.xlsx";
		FileInputStream  fis=new FileInputStream(path);
	   Workbook w1 = WorkbookFactory.create(fis);
	    w1.getSheet(sheetName).getRow(rowNo).getCell(cellNo).setCellValue(setString);
	    FileOutputStream fos=new FileOutputStream(path);
	     w1.write(fos);
    }
}
