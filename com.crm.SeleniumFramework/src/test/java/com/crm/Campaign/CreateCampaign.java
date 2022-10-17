package com.crm.Campaign;

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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.crm.Generic_Utilities.Excel_Utility;
import com.crm.Generic_Utilities.File_Utility1;
import com.crm.Generic_Utilities.Java_Utility;

public class CreateCampaign {

	public static void main(String[] args) throws Throwable {
		
		String Key="webdriver.chrome.driver";
		String value="C:\\Users\\Nikhil Madhumatke\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe";
		System.setProperty(Key, value);
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		File_Utility1 flib=new File_Utility1();
		String URL=flib.getPropertyKeyValue("url");
		String UserName=flib.getPropertyKeyValue("un");
		String PassWord=flib.getPropertyKeyValue("pw");
		
		
		//FileInputStream fis= new FileInputStream("./Common_Data.properties");
	//	Properties pro=new Properties();
	//	pro.load(fis);
		//String URL =pro.getProperty("url");
		//String UserName=pro.getProperty("un");
	//	String PassWord=pro.getProperty("pw");
		
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(UserName);
		driver.findElement(By.name("user_password")).sendKeys(PassWord);
		driver.findElement(By.id("submitButton")).click();
		
		WebElement more = driver.findElement(By.xpath("//a[text()='More']"));
		Actions a=new Actions(driver);
		a.moveToElement(more).perform();
		
		
		driver.findElement(By.linkText("Campaigns")).click();
		driver.findElement(By.xpath("//img[@alt='Create Campaign...']")).click();
		
		Java_Utility jlib=new Java_Utility();
		int RanNum = jlib.getRanDomNum();

		
		//Random ran=new Random();
		//int RanNum=ran.nextInt(1000);
		
		Excel_Utility elib=new Excel_Utility();
		String data = elib.getDataFromExcel("Sheet1", 0, 0)+RanNum;
		
		//FileInputStream fis1 = new FileInputStream("./Book4.xlsx");
		//Workbook book = WorkbookFactory.create(fis1);
		//Sheet sh = book.getSheet("Sheet1");

		//Row row = sh.getRow(0);
		//Cell cel = row.getCell(0);
		//String data = cel.getStringCellValue()+RanNum;
		//System.out.println(data);
		
		driver.findElement(By.name("campaignname")).sendKeys(data);
		
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		Thread.sleep(1000);
		String actData=driver.findElement(By.cssSelector("span.dvHeaderText")).getText();
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
