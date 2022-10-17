package com.crm.Organization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.Generic_Utilities.Excel_Utility;
//import com.crm.Generic_Utilities.File_Utility;
import com.crm.Generic_Utilities.File_Utility1;
import com.crm.Generic_Utilities.Java_Utility;
import com.crm.Generic_Utilities.WebDriver_Utility;

import io.github.bonigarcia.wdm.WebDriverManager;


public class CreateOrganization {

	

	public static void main(String[] args) throws Throwable {
		
		WebDriver driver = null;
		/*Step 1: create object of generic utilities */
		Java_Utility jUtil = new Java_Utility();
		File_Utility1 flib = new File_Utility1();
		Excel_Utility eUtil = new Excel_Utility();
		WebDriver_Utility wUtil = new WebDriver_Utility();
		
		
		//File_Utility flib=new File_Utility();
		String BROWSER=flib.getPropertyKeyValue("browser");
		String URL=flib.getPropertyKeyValue("url");
		String UserName=flib.getPropertyKeyValue("un");
		String Password=flib.getPropertyKeyValue("pw");
		String OrgName= eUtil.getDataFromExcel("Sheet1", 0, 0)+jUtil.getRanDomNum();

		//lounch the browser
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			System.out.println("Chrome browser lounched successfully");
		}
		else if(BROWSER.equalsIgnoreCase("Firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			System.out.println("Firefox browser lounched successfully");
		}
		else if(BROWSER.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver= new EdgeDriver();
			System.out.println("Edge browser lounched successfully");
		}
		else
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			System.out.println(" By Default Chrome browser lounched successfully");			
		}
				
		wUtil.maximiseWindow(driver);
		wUtil.waitForElementInDOM(driver);

		
		
		
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(UserName);
		driver.findElement(By.name("user_password")).sendKeys(Password);
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		
		
	
		
		//Random ran=new Random();
		//int RanNum=ran.nextInt(1000);
		
		
	//	FileInputStream fis1 = new FileInputStream("./Book4.xlsx");
	//	Workbook book = WorkbookFactory.create(fis1);
	//	Sheet sh = book.getSheet("Sheet1");

	//	Row row = sh.getRow(0);
	//	Cell cel = row.getCell(0);
	//	String data = cel.getStringCellValue()+RanNum;
	//	System.out.println(data);
		
		driver.findElement(By.name("accountname")).sendKeys(OrgName);
		
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		Thread.sleep(1000);
		String actData=driver.findElement(By.cssSelector("span.dvHeaderText")).getText();
		if(actData.contains(OrgName))
		{
			System.out.println("pass");
			
		}
		else
		{
			System.out.println("fail");
		}
		
		driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();

	}

}
