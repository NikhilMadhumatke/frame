package testNG;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest {
	
	@Test(dataProvider="dataProvider_test")
	
	public void companyDetails(String name,String phnum,String email) throws Throwable 
	{
/*String Key="webdriver.chrome.driver";
		String value="C:\\Users\\Nikhil Madhumatke\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe";
		System.setProperty(Key, value);     */
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		driver.get("http://localhost:8888/");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		
		driver.findElement(By.name("accountname")).sendKeys(name);
		driver.findElement(By.id("phone")).sendKeys(phnum);
		driver.findElement(By.id("email")).sendKeys(email);
		driver.findElement(By.xpath("//input[@title='Save [Alt+s]']")).click();
		
		driver.quit();
		Thread.sleep(2000);
	}
	
		@DataProvider
		public Object[][] dataProvider_test()
		{
			Object[][] objArr=new Object[3][3];
			objArr[0][0]="AAA";
			objArr[0][1]="123456789";
			objArr[0][2]="agsjfj@gmail.com";
			
			
			objArr[1][1]="BBB";
			objArr[1][1]="455632265";
			objArr[1][2]="mangsgs@gmail.com";
			
			objArr[2][0]="CCC";
			objArr[2][1]="652532262";
			objArr[2][2]="Bangshs@gmail.com";
			
			return objArr;
			
		}


		

		
	}
