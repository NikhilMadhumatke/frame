package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	//Initialization
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Declaration
	
	@FindBy(name="user_name")
	private WebElement userNameTextField;
	
	@FindBy(name="user_password")
	private WebElement passwrodTextField;
	
	@FindBy(id="submitButton")
	private WebElement submitbutton;
	
	//getter methods

	public WebElement getUserNameTextField() {
		return userNameTextField;
	}

	public WebElement getPasswrodTextField() {
		return passwrodTextField;
	}

	public WebElement getSubmitbutton() {
		return submitbutton;
	}
	
	//Business logics
	/**
	 * this method is used to login the app
	 * @param userName
	 * @param password
	 */
	
	public void login(String userName,String password)
	{
		userNameTextField.sendKeys(userName);
		passwrodTextField.sendKeys(password);
		submitbutton.click();
		
	}
	
	

}
