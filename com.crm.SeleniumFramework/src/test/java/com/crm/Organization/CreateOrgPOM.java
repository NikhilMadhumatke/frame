package com.crm.Organization;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
import com.crm.ObjectRepository.OrganizationPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrgPOM {
	public static void main(String[] args) throws Throwable {
		
		WebDriver driver = null;	
	
		
			//create object of utilities
			File_Utility1 pUtil= new File_Utility1();
			Java_Utility jUtil=new Java_Utility();
			Excel_Utility eUtil= new Excel_Utility();
			WebDriver_Utility wUtil= new WebDriver_Utility();
			
			//read the necessary data
			String BROWSER= pUtil.getPropertyKeyValue("browser");
			String URL= pUtil.getPropertyKeyValue("url");
			String USERNAME= pUtil.getPropertyKeyValue("un");
			String PASSWORD= pUtil.getPropertyKeyValue("pw");
			String OrgName= eUtil.getDataFromExcel("Sheet1", 0, 0)+jUtil.getRanDomNum();
					
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
					
			wUtil.maximiseWindow(driver);
			wUtil.waitForElementInDOM(driver);
		
			// Login to App
			driver.get(URL);
			
			LoginPage login=new LoginPage(driver);
			login.login(USERNAME, PASSWORD);
			
			//click on organization link
			
			HomePage home=new HomePage(driver);
			home.clickOnOrganization();
			
			//click on org lookup img
			
			OrganizationPage org=new OrganizationPage(driver);
			org.clickOnPlus();
			
			//enter OrgNAme
			
			org.typeAccountName(OrgName);
			
			//Save 
			
			org.clickOnSave();
			
			//Validate
			CampaignPage camp=new CampaignPage(driver);
			String actData=camp.validateHeaderText();
		//	String actData=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
			if(actData.contains(OrgName))
			{
				System.out.println("Org Created");
			}
			else
			{
				System.out.println("Org Not Created");
			}		
			//logOut
			
			home.clickMyReference();
			home.clickOnSignOut();
			
			
}

}
