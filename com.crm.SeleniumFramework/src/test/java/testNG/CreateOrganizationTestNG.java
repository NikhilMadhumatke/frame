package testNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.Generic_Utilities.BaseClass;
import com.crm.Generic_Utilities.Excel_Utility;
import com.crm.Generic_Utilities.File_Utility1;
import com.crm.Generic_Utilities.Java_Utility;
import com.crm.Generic_Utilities.WebDriver_Utility;
import com.crm.ObjectRepository.CampaignPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;
import com.crm.ObjectRepository.OrganizationPage;
import com.crm.ObjectRepository.ValidationAndVerificationPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrganizationTestNG extends BaseClass {
//@Test(retryAnalyzer=com.crm.Generic_Utilities.RetryAnalyser1.class)	
@Test(groups = {"smokeTest"})
	public void createOrganizationTestNG() throws Throwable
	{	
	
	//create object of utilities
	Java_Utility jUtil=new Java_Utility();
	Excel_Utility eUtil= new Excel_Utility();
	WebDriver_Utility wUtil= new WebDriver_Utility();  

	String OrgName= eUtil.getDataFromExcel("Sheet1", 0, 0)+jUtil.getRanDomNum();
			
	//Launch the browser

			
	wUtil.maximiseWindow(driver);
	wUtil.waitForElementInDOM(driver);

	// Login to App
	
	//click on organization link
	
	HomePage home=new HomePage(driver);
	home.clickOnOrganization();
	
	//click on org lookup img
	
	OrganizationPage org=new OrganizationPage(driver);
	org.clickOnPlus();
	
//	Assert.assertEquals(true, false);
	//enter OrgNAme
	
	org.typeAccountName(OrgName);
	
	//Save 
	
	org.clickOnSave();
	
	//Validate
	
	ValidationAndVerificationPage validate=new ValidationAndVerificationPage(driver);
	validate.organizationValidation(driver, OrgName);
/*	CampaignPage camp=new CampaignPage(driver);
	String actData=camp.validateHeaderText();
//	String actData=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
	if(actData.contains(OrgName))
	{
		System.out.println("Org Created");
	}
	else
	{
		System.out.println("Org Not Created");
	}		*/
	//logOut
	
	home.clickMyReference();
	home.clickOnSignOut();
	
	driver.close();
}

	/*@Test
	public void modifyOrg()
	{	
		System.out.println("modified");

	}

	
	@Test
	public void modifyOrg2()
	{	
		System.out.println("modified2");
	}   */
}
