package testNG;

import org.testng.annotations.Test;

import com.crm.Generic_Utilities.BaseClass;
import com.crm.Generic_Utilities.Excel_Utility;
import com.crm.Generic_Utilities.Java_Utility;
import com.crm.Generic_Utilities.WebDriver_Utility;
import com.crm.ObjectRepository.CampaignPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.ValidationAndVerificationPage;

public class CreateCampaignTestNG extends BaseClass{
	
	@Test(groups = {"smokeTest","RegressionTest"})
	public void createCampaignTestNG() throws Throwable
	{	
		//create object of utilities
		Java_Utility jUtil=new Java_Utility();
		Excel_Utility eUtil= new Excel_Utility();
		WebDriver_Utility wUtil= new WebDriver_Utility();  

		String OrgName= eUtil.getDataFromExcel("Sheet1", 0, 0)+jUtil.getRanDomNum();
		
		wUtil.maximiseWindow(driver);
		wUtil.waitForElementInDOM(driver);

		//Mouse over on more
		
				HomePage home=new HomePage(driver);
				home.mouseHoverOnMore(driver);
				
				//Click on Campaign
				
				home.clickOnCampaign();
				
				CampaignPage camp=new CampaignPage(driver);
				camp.clickOnPlus();
				camp.typeCampaignName(OrgName);
				camp.clickOnSave();
				
				Thread.sleep(1000);
				
				//Validation
				
				ValidationAndVerificationPage validate=new ValidationAndVerificationPage(driver);
				validate.organizationValidation(driver, OrgName);
			/*	 String actData=camp.validateHeaderText();

				  if(actData.contains(OrgName))
				     {
				      System.out.println("pass");
				     }
				     else
				     {
				      System.out.println("fail");
				     }  */
				  
				//logOut
					
					home.clickMyReference();
					home.clickOnSignOut();
					
					driver.close();
			}

		
		
}
