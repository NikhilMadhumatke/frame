package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignPage {
	
	//Initialization
	
		public CampaignPage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}
		
				//Declaration
		
				@FindBy(xpath="//img[@alt='Create Campaign...']")
				private WebElement orgLookUpImage;
				
				@FindBy(name="campaignname")
				private WebElement campaignName;
				
				@FindBy(xpath="//input[@title='Save [Alt+S]']")
				private WebElement save;
				
				@FindBy(xpath="//img[@title='Select']")
				private WebElement select;
				
				@FindBy(id="search_txt")
				private WebElement searchText;
				
				@FindBy(name="search")
				private WebElement search;
				
				@FindBy(xpath="//span[@class='dvHeaderText']")
				private WebElement headerText;
				
				
				
				

				//getter methods
				
				

				public WebElement getHeaderText() {
					return headerText;
				}

				public WebElement getOrgLookUpImage() {
					return orgLookUpImage;
				}

				public WebElement getSelect() {
					return select;
				}

				public WebElement getSearchText() {
					return searchText;
				}

				public WebElement getSearch() {
					return search;
				}

				public WebElement getCampaignName() {
					return campaignName;
				}

				public WebElement getSave() {
					return save;
				}
				
				//Business logics
				
				public void clickOnPlus()
				{
					orgLookUpImage.click();
				}
				
				public void typeCampaignName(String data)
				{
					campaignName.sendKeys(data);
				}
				
				public void clickOnSave()
				{
					save.click();
				}
				
				public void clickOnSelect()
				{
					select.click();
				}
				
				public void searchTextData(String data)
				{
					searchText.sendKeys(data);
				}
				
				public void clickOnSearch()
				{
					search.click();
				}
				
				public String validateHeaderText()
				{
					String headertext=headerText.getText();
					return headertext;
				}

}
