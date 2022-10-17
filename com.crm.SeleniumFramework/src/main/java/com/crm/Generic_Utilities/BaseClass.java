package com.crm.Generic_Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.crm.ObjectRepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public WebDriver driver;
	public static WebDriver sDriver;
	@BeforeSuite(groups = {"smokeTest","RegressionTest"})
	
	public void BS()
	{
		System.out.println("DataBase Connection");
	}
	
	@BeforeTest(groups = {"smokeTest","RegressionTest"})
	public void BT()
	{
		System.out.println("Execute in Parallel mode");
	}
	
	
	
	@Parameters("BROWSER")
	@BeforeClass(groups = {"smokeTest","RegressionTest"})
	public void BC() throws Throwable
	{
		File_Utility1 pUtil= new File_Utility1();
		String Browser= pUtil.getPropertyKeyValue("browser"); 

		if(Browser.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			System.out.println("Chrome browser launched successfully");
		}
		else if(Browser.equalsIgnoreCase("Firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			System.out.println("Firefox browser launched successfully");
		}
		else if(Browser.equalsIgnoreCase("edge"))
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
		
		sDriver=driver;
		System.out.println("Launching the Browser");

	}
	
	@BeforeMethod(groups = {"smokeTest","RegressionTest"})
	public void BM() throws Throwable
	{
		File_Utility1 pUtil= new File_Utility1();
		String URL= pUtil.getPropertyKeyValue("url");
		String USERNAME= pUtil.getPropertyKeyValue("un");
		String PASSWORD= pUtil.getPropertyKeyValue("pw");
		System.out.println("Login to Application");
		driver.get(URL);
		
		LoginPage login=new LoginPage(driver);
		login.login(USERNAME, PASSWORD);
	}
	
	@AfterMethod(groups = {"smokeTest","RegressionTest"})
	public void AM()
	{
		System.out.println("Logout to Application");
	}
	
	@AfterClass(groups = {"smokeTest","RegressionTest"})
	public void AC()
	{
		System.out.println("Close the Browser");
	}
	
	@AfterTest(groups = {"smokeTest","RegressionTest"})
	public void AT()
	{
		System.out.println("Executed successfully");
	}
	
	@AfterSuite(groups = {"smokeTest","RegressionTest"})
	public void AS()
	{
		System.out.println("DataBase Close");
	}
	
}
