package com.crm.Campaign;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import com.crm.Generic_Utilities.Excel_Utility;
//import com.crm.Generic_Utilities.File_Utility;
import com.crm.Generic_Utilities.File_Utility1;
import com.crm.Generic_Utilities.Java_Utility;
import com.crm.Generic_Utilities.WebDriver_Utility;
import com.crm.ObjectRepository.CampaignPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateCampaignPOM {

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
			System.out.println(" By Default Chrome browser launched successfully");			
		}
				
		wlib.maximiseWindow(driver);
		wlib.waitForElementInDOM(driver);
		
		driver.get(URL);
		
		//Login
		
		LoginPage login=new LoginPage(driver);
		login.login(UserName, PassWord);
		
		//Mouse over on more
		
		HomePage home=new HomePage(driver);
		home.mouseHoverOnMore(driver);
		
		//Click on Campaign
		
		home.clickOnCampaign();
		
		CampaignPage camp=new CampaignPage(driver);
		camp.clickOnPlus();
		camp.typeCampaignName(data);
		camp.clickOnSave();
		
		Thread.sleep(1000);
		
		//Validation
		 String actData=camp.validateHeaderText();

		  if(actData.contains(data))
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
