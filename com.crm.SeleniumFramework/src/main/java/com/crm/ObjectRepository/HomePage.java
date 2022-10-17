package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.Generic_Utilities.WebDriver_Utility;

public class HomePage {
	
	
	//Initialization
	
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Declaration
	
		@FindBy(linkText="Products")
		private WebElement productLinkText;
		
		@FindBy(linkText="More")
		private WebElement moreLink;
		
		@FindBy(linkText="Campaigns")
		private WebElement campaignsLinkText;
		
		@FindBy(linkText="Organizations")
		private WebElement organizationLinkText;
		
		@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
		private WebElement myReference;
		
		
		@FindBy(xpath="//a[text()='Sign Out']")
		private WebElement signOut;
		
		

		
		//Gettters
		

		public WebElement getProductLinkText() {
			return productLinkText;
		}

		public WebElement getMyReference() {
			return myReference;
		}

		public WebElement getSignOut() {
			return signOut;
		}

		public WebElement getMoreLink() {
			return moreLink;
		}

		public WebElement getCampaignsLinkText() {
			return campaignsLinkText;
		}

		public WebElement getOrganizationLinkText() {
			return organizationLinkText;
		}

		//Business 
		
		public void clickOnOrganization()
		{
			organizationLinkText.click();
		
		}
		
		
		public void clickMyReference()
		{
			myReference.click();
		}
		
		
		public void clickOnSignOut()
		{
			signOut.click();
		}
		
		public void clickOnCampaign()
		{
			campaignsLinkText.click();
		}
		
		public void mouseHoverOnMore(WebDriver driver)
		{
			WebDriver_Utility wlib= new WebDriver_Utility();
			wlib.mouseOverOnElement(driver, moreLink);
		}
		
		
		public void clickOnProduct()
		{
			productLinkText.click();
		}
		
	
	

}
