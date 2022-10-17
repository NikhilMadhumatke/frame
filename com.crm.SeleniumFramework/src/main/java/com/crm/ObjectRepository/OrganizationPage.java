package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationPage {

		//Initialization
	
		public OrganizationPage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}
		
		//Declaration
		
		@FindBy(xpath="//img[@alt='Create Organization...']")
		private WebElement orgLookUpImage;
		
		@FindBy(name="accountname")
		private WebElement accountName;
		
		@FindBy(name="button")
		private WebElement button;
		
		//getter methods

		public WebElement getOrgLookUpImage() {
			return orgLookUpImage;
		}

		public WebElement getAccountName() {
			return accountName;
		}

		public WebElement getButton() {
			return button;
		}
		
		//Business logics
		
		public void clickOnPlus()
		{
			orgLookUpImage.click();
		}
		
		public void typeAccountName(String OrgName)
		{
			accountName.sendKeys(OrgName);
		}
		
		public void clickOnSave()
		{
			button.click();
		}
		
}
