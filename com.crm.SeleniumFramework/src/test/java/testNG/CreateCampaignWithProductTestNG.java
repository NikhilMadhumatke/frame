package testNG;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.crm.Generic_Utilities.BaseClass;
import com.crm.Generic_Utilities.Excel_Utility;
import com.crm.Generic_Utilities.Java_Utility;
import com.crm.Generic_Utilities.WebDriver_Utility;
import com.crm.ObjectRepository.CampaignPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.ProductPage;
import com.crm.ObjectRepository.ValidationAndVerificationPage;

public class CreateCampaignWithProductTestNG extends BaseClass {
	
	@Test(groups = {"RegressionTest"})
	public void createCampaignWithProductTestNG() throws Throwable
	{	
		//create object of utilities
		Java_Utility jUtil=new Java_Utility();
		Excel_Utility eUtil= new Excel_Utility();
		WebDriver_Utility wUtil= new WebDriver_Utility();  

		String OrgName= eUtil.getDataFromExcel("Sheet1", 0, 0)+jUtil.getRanDomNum();
		
		wUtil.maximiseWindow(driver);
		wUtil.waitForElementInDOM(driver);
		
		 //product data
			HomePage home=new HomePage(driver);
			home.clickOnProduct();
			
			ProductPage pro=new ProductPage(driver);
			pro.clickOnPlus();
			pro.typeProductName(OrgName);
			pro.clickOnSave();
			
		
		     //Navigate to Campaign
			
			home.mouseHoverOnMore(driver);
			
			home.clickOnCampaign();
			
			CampaignPage camp=new CampaignPage(driver);
			camp.clickOnPlus();
			
			Excel_Utility elib1=new Excel_Utility();
			String data1 = elib1.getDataFromExcel("Sheet1", 0, 0)+jUtil.getRanDomNum();
			camp.typeCampaignName(data1);
			camp.clickOnSelect();
			 
			  
			  //Window Switching
			  
			String actData1="Products&action";
			wUtil.swithToWindow(driver, actData1);
			
			camp.searchTextData(OrgName);
			camp.clickOnSearch();
		
			  
			  //Dynamic Xpath
			  driver.findElement(By.xpath("//a[text()='"+OrgName+"']")).click();
			
			  
			  //Switch back Window
			  String actData2="Campaigns&action";
			  wUtil.swithToWindow(driver, actData2);
			  
			  camp.clickOnSave();
			   
			  Thread.sleep(1000);

			  ValidationAndVerificationPage validate=new ValidationAndVerificationPage(driver);
				validate.organizationValidation(driver, OrgName);
			 /* String actData=camp.validateHeaderText();

			  if(actData.contains(data1))
			     {
			      System.out.println("pass");
			     }
			     else
			     {
			      System.out.println("fail");
			     }   */
			  
			//logOut
				
				home.clickMyReference();
				home.clickOnSignOut();
				
				driver.close();
	}

}
