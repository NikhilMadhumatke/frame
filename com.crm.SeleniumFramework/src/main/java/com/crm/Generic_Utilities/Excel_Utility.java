package com.crm.Generic_Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class Excel_Utility {
	
	/**
	 * This method is used to fetch data from excel
	 * @param sheetName
	 * @param RowNum
	 * @param cellNum
	 * @return
	 * @throws Throwable
	 * @author Nikhil Madhumatke
	 */
	
	public String getDataFromExcel(String sheetName,int RowNum,int cellNum) throws Throwable 
	{
		//FileInputStream fis1 = new FileInputStream("./Book4.xlsx");
		FileInputStream fis1 = new FileInputStream("ipathConstant.ExcelFilePath");
		Workbook book = WorkbookFactory.create(fis1);
		Sheet sh = book.getSheet(sheetName);
		Row row = sh.getRow(RowNum);
		Cell cel = row.getCell(cellNum);
		String data = cel.getStringCellValue();
		return data;  
	//	DataFormatter format=new DataFormatter();
		
	//	return format.formatCellValue(book.getSheet(sheetName).getRow(RowNum).getCell(cellNum));
		
	}

}
