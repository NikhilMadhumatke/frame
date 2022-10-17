package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
	
	//Initialization
	
			public ProductPage(WebDriver driver)
			{
				PageFactory.initElements(driver, this);
			}

			
			//Declaration
			

			@FindBy(xpath="//img[@alt='Create Product...']")
			private WebElement orgLookUpImage;
			
			@FindBy(name="productname")
			private WebElement productName;
			
			@FindBy(xpath="//input[@title='Save [Alt+S]']")
			private WebElement save;
			
			@FindBy(xpath="//input[@title='Delete [Alt+D]']")
			private WebElement delete;
			
			@FindBy(xpath="//span[@class='lvtHeaderText']")
			private WebElement headerTextProduct;

			//getter
			public WebElement getDelete() {
				return delete;
			}

			public WebElement getOrgLookUpImage() {
				return orgLookUpImage;
			}

			public WebElement getProductName() {
				return productName;
			}

		
			public WebElement getSave() {
				return save;
			}
			
			
			public WebElement getHeaderTextProduct() {
				return headerTextProduct;
			}

			//Business logics
			public void clickOnPlus()
			{
				orgLookUpImage.click();
			}
			
			public void typeProductName(String data)
			{
				productName.sendKeys(data);
			}
			
			public void clickOnSave()
			{
				save.click();
			}
			
			public void deleteProduct()
			{
				delete.click();
			}
			
			public String validateHeaderText()
			{
				String headertext=headerTextProduct.getText();
				return headertext;
			}
}
