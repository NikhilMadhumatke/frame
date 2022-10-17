package com.crm.Campaign;

import java.util.Iterator;
import java.util.Set;

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
import com.crm.ObjectRepository.CampaignPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;
import com.crm.ObjectRepository.ProductPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateCampaignWithProductPOM {

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
			System.out.println(" By Default Chrome browser launched successfully");			
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
		
	
	     //Navigate to Campaign
		
		home.mouseHoverOnMore(driver);
		
		home.clickOnCampaign();
		
		CampaignPage camp=new CampaignPage(driver);
		camp.clickOnPlus();
		
		Excel_Utility elib1=new Excel_Utility();
		String data1 = elib1.getDataFromExcel("Sheet1", 0, 0)+jlib.getRanDomNum();
		camp.typeCampaignName(data1);
		camp.clickOnSelect();
		 
		  
		  //Window Switching
		  
		String actData1="Products&action";
		wlib.swithToWindow(driver, actData1);
		
		camp.searchTextData(data);
		camp.clickOnSearch();
	
		  
		  //Dynamic Xpath
		  driver.findElement(By.xpath("//a[text()='"+data+"']")).click();
		
		  
		  //Switch back Window
		  String actData2="Campaigns&action";
		  wlib.swithToWindow(driver, actData2);
		  
		  camp.clickOnSave();
		   
		  Thread.sleep(1000);

		  
		  String actData=camp.validateHeaderText();

		  if(actData.contains(data1))
		     {
		      System.out.println("pass");
		     }
		     else
		     {
		      System.out.println("fail");
		     }
		  
		//logOut
			
			home.clickMyReference();
			home.clickOnSignOut();
		
	}

	}



