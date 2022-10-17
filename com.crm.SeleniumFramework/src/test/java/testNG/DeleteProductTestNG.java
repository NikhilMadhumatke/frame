package testNG;

import org.testng.annotations.Test;

import com.crm.Generic_Utilities.BaseClass;
import com.crm.Generic_Utilities.Excel_Utility;
import com.crm.Generic_Utilities.Java_Utility;
import com.crm.Generic_Utilities.WebDriver_Utility;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.ProductPage;
import com.crm.ObjectRepository.ValidationAndVerificationPage;

public class DeleteProductTestNG extends BaseClass {
	
	@Test
	public void DeleteProductTestNG() throws Throwable
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
		
		Thread.sleep(1000);
		//Validation
		
	//	ValidationAndVerificationPage validate=new ValidationAndVerificationPage(driver);
	//	validate.organizationValidation(driver, OrgName);
		String actData=pro.validateHeaderText();

		  if(actData.contains(OrgName))
		     {
		      System.out.println("pass");
		     }
		     else
		     {
		      System.out.println("fail");
		     }   
		  
	    pro.deleteProduct();
		wUtil.swithToAlertWindowAndAccpect(driver, actData);
		  
		//logOut
			
		home.clickMyReference();
		home.clickOnSignOut();
		
		driver.close();
		
		

}
}
