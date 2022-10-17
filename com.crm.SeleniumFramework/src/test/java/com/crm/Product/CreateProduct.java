package com.crm.Product;

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

public class CreateProduct {

	public static void main(String[] args) throws Throwable {
		
		
		WebDriver driver = null;	
		
		
		//create object of utilities
		File_Utility1 flib= new File_Utility1();
		Java_Utility jlib=new Java_Utility();
		Excel_Utility elib= new Excel_Utility();
		WebDriver_Utility wlib= new WebDriver_Utility();
		
		
	/*	String Key="webdriver.chrome.driver";
		String value="C:\\Users\\Nikhil Madhumatke\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe";
		System.setProperty(Key, value);
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);  */

		
	//	File_Utility flib=new File_Utility();
		String BROWSER= flib.getPropertyKeyValue("browser");
		String URL=flib.getPropertyKeyValue("url");
		String UserName=flib.getPropertyKeyValue("un");
		String PassWord=flib.getPropertyKeyValue("pw");
		
	/*	driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(UserName);
		driver.findElement(By.name("user_password")).sendKeys(PassWord);
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.linkText("Products")).click();
		driver.findElement(By.xpath("//img[@alt='Create Product...']")).click();  */
		
	/*	Java_Utility jlib=new Java_Utility();
		int RanNum = jlib.getRanDomNum();   */

		
		//Random ran=new Random();
		//int RanNum=ran.nextInt(1000);
		
	//	Excel_Utility elib=new Excel_Utility();
		String data = elib.getDataFromExcel("Sheet1", 0, 0)+jlib.getRanDomNum();
		
		
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
				
		wlib.maximiseWindow(driver);
		wlib.waitForElementInDOM(driver);
		
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(UserName);
		driver.findElement(By.name("user_password")).sendKeys(PassWord);
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.linkText("Products")).click();
		driver.findElement(By.xpath("//img[@alt='Create Product...']")).click();

		
		//FileInputStream fis1 = new FileInputStream("./Book4.xlsx");
		//Workbook book = WorkbookFactory.create(fis1);
		//Sheet sh = book.getSheet("Sheet1");

		//Row row = sh.getRow(0);
		//Cell cel = row.getCell(0);
		//String data = cel.getStringCellValue()+RanNum;
		//System.out.println(data);
		
		driver.findElement(By.name("productname")).sendKeys(data);
		
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		Thread.sleep(1000);
		String actData=driver.findElement(By.cssSelector("span.lvtHeaderText")).getText();
		if(actData.contains(data))
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
