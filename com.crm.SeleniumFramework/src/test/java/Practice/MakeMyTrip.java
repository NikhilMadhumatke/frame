package Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Actions;

public class MakeMyTrip {

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
		
		FileInputStream fis3 = new FileInputStream("./Book4.xlsx");
		Workbook book = WorkbookFactory.create(fis3);
		Sheet sh = book.getSheet("Sheet1");

		Row row = sh.getRow(2);
		Cell cel = row.getCell(1);
		String data = cel.getStringCellValue();
		System.out.println(data);
		
		//FileInputStream fis4 = new FileInputStream("./Book4.xlsx");
		//Workbook book1 = WorkbookFactory.create(fis4);
		//Sheet sh1 = book1.getSheet("Sheet1");

		Row row1 = sh.getRow(2);
		Cell cel1 = row1.getCell(2);
		String data1 = cel1.getStringCellValue();
		System.out.println(data1);
		
		driver.findElement(By.xpath("//label[@for='fromCity']")).click();
		driver.findElement(By.xpath("//input[@autocomplete='off']")).sendKeys(data);
		driver.findElement(By.xpath("//p[text()='Nagpur, India']")).click();
		
		driver.findElement(By.xpath("//input[@placeholder='To']")).sendKeys(data1);
		driver.findElement(By.xpath("//p[text()='Pune, India']")).click();
		
		//Actions a=new Actions(driver);
	  //  WebElement date = driver.findElement(By.xpath("//div[@aria-label='Fri Oct 07 2022']"));
	//	a.moveToElement(date).click().perform();
		
		// driver.findElement(By.xpath("//div[@aria-label='Fri Oct 07 2022']")).click();
		
		driver.findElement(By.xpath("//span[@class='langCardClose']")).click();
		driver.findElement(By.xpath("//span[text()='DEPARTURE']")).click();
		
		Thread.sleep(1000);
		String month="October 2022";
		String date= "15";
		driver.findElement(By.xpath("//div[text()='"+month+"']"
				+"/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='"+date+"']")).click();
		



	}

}
