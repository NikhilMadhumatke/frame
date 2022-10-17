package com.crm.Product;

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
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;
import com.crm.ObjectRepository.ProductPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateProductPOM {
	
	public static void main(String[] args) throws Throwable {

			WebDriver driver = null;	
			
			
			//create object of utilities
			File_Utility1 flib= new File_Utility1();
			Java_Utility jlib=new Java_Utility();
			Excel_Utility elib= new Excel_Utility();
			WebDriver_Utility wlib= new WebDriver_Utility();
			
			
			String BROWSER= flib.getPropertyKeyValue("browser");
			String URL=flib.getPropertyKeyValue("url");
			String UserName=flib.getPropertyKeyValue("un");
			String PassWord=flib.getPropertyKeyValue("pw");
			
		
			String data = elib.getDataFromExcel("Sheet1", 0, 0)+jlib.getRanDomNum();
			
			
			//Launch the browser
			if(BROWSER.equalsIgnoreCase("chrome"))
			{
				WebDriverManager.chromedriver().setup();
				driver=new ChromeDriver();
				System.out.println("Chrome browser launched successfully");
			}
			else if(BROWSER.equalsIgnoreCase("Firefox"))
			{
				WebDriverManager.firefoxdriver().setup();
				driver=new FirefoxDriver();
				System.out.println("Firefox browser launched successfully");
			}
			else if(BROWSER.equalsIgnoreCase("edge"))
			{
				WebDriverManager.edgedriver().setup();
				driver= new EdgeDriver();
				System.out.println("Edge browser launched successfully");
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
			
			LoginPage login=new LoginPage(driver);
			login.login(UserName, PassWord);
			
			 //product data
			HomePage home=new HomePage(driver);
			home.clickOnProduct();
			
			ProductPage pro=new ProductPage(driver);
			pro.clickOnPlus();
			pro.typeProductName(data);
			pro.clickOnSave();
			
			Thread.sleep(1000);
			
			String actData=pro.validateHeaderText();

		//	String actData=driver.findElement(By.cssSelector("span.lvtHeaderText")).getText();
			if(actData.contains(data))
			{
				System.out.println("pass");
				
			}
			else
			{
				System.out.println("fail");
			}
			
			//log out
			
			home.clickMyReference();
			home.clickOnSignOut();
			
		/*	driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
			driver.findElement(By.xpath("//a[text()='Sign Out']")).click();    */

}

}


