package Practice;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Sample {

	public static void main(String[] args) throws Throwable {
		
		String Key="webdriver.chrome.driver";
		String value="C:\\Users\\Nikhil Madhumatke\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe";
		System.setProperty(Key, value);
		WebDriver driver=new ChromeDriver();
		
		FileInputStream fis= new FileInputStream("./Common_Data.properties");
		Properties pro=new Properties();
		pro.load(fis);
		String URL =pro.getProperty("url");
		String UserName=pro.getProperty("un");
		String PassWord=pro.getProperty("pw");
		
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(UserName);
		driver.findElement(By.name("user_password")).sendKeys(PassWord);
		driver.findElement(By.id("submitButton")).click();
        
		
		
		

	}

}
