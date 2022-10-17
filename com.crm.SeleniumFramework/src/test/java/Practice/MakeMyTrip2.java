package Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MakeMyTrip2 {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		String Key="webdriver.chrome.driver";
		String value="C:\\Users\\Nikhil Madhumatke\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe";
		System.setProperty(Key, value);
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		FileInputStream fis= new FileInputStream("./Common_Data.properties");
		Properties pro=new Properties();
		pro.load(fis);
		String URL =pro.getProperty("url1");
		driver.get(URL);
        
		driver.findElement(By.xpath("//span[@class='langCardClose']")).click();
		
		//from
		String srcCity= "Nagpur, India";
		WebElement src=driver.findElement(By.xpath("//input[@id='fromCity']"));
		src.sendKeys("'"+srcCity+"'");
		driver.findElement(By.xpath("//p[text()='"+srcCity+"']")).click();
		
		//To
		String desCity= "Pune, India";
		WebElement des=driver.findElement(By.xpath("//input[@id='toCity']"));
		des.sendKeys("'"+desCity+"'");
		driver.findElement(By.xpath("//p[text()='"+desCity+"']")).click();
		
		driver.findElement(By.xpath("//span[text()='DEPARTURE']")).click();
		
		Thread.sleep(1000);
		String month= "October 2022";
		String date= "15";
		WebElement data = driver.findElement(By.xpath("//div[text()='"+month+"']"+"/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='"+date+"']"));
		
		data.click();
		driver.findElement(By.xpath("//span[text()='RETURN']")).click();
		
		Thread.sleep(1000);
		String monthR= "October";
		String dateR= "18";
		WebElement data1 = driver.findElement(By.xpath("//div[text()='"+monthR+"']"+"/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='"+dateR+"']"));
		
		data1.click();
		
		WebElement trav = driver.findElement(By.id("travellers"));
		Actions a=new Actions(driver);
		a.moveToElement(trav).click().perform();
		
		String adults="adults-3";
		String children="children-3";
		String infants="infants-3";
		
		WebElement ele=driver.findElement(By.xpath("//li[@data-cy='"+adults+"']"));
		a.moveToElement(ele).click().perform();
		
		driver.findElement(By.xpath("//li[@data-cy='"+children+"']")).click();
		
		driver.findElement(By.xpath("//li[@data-cy='"+infants+"']")).click();
		
		driver.findElement(By.xpath("//button[text()='APPLY']")).click();
		driver.close();
		

		
		
	}

}
