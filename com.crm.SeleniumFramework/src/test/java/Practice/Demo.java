package Practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo {

	public static void main(String[] args) throws Throwable, IOException {
		
		String Key="webdriver.chrome.driver";
		String value="C:\\Users\\Nikhil Madhumatke\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe";
		System.setProperty(Key, value);
		//WebDriver driver=new ChromeDriver();
		
		FileInputStream fis = new FileInputStream("./Book4.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		Sheet sh = book.getSheet("Sheet1");

		Row row = sh.getRow(0);
		Cell cel = row.getCell(0);
		String data = cel.getStringCellValue();
		System.out.println(data);

	}

}
