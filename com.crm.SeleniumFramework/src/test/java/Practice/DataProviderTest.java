package Practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest {
	
@Test(dataProvider="dataProvider_test")

	public void bookTicket(String src,String dst)
	{
		System.out.println("Book tickets from "+src+" to "+dst+"");
	}

	@DataProvider
	public Object[][] dataProvider_test()
	{
		Object[][] objArr=new Object[5][2];
		objArr[0][0]="Banglore";
		objArr[0][1]="goa";
		
		objArr[1][0]="Banglore";
		objArr[1][1]="mysore";
		
		objArr[2][0]="Banglore";
		objArr[2][1]="manglore";
		
		objArr[3][0]="Banglore";
		objArr[3][1]="mumbai";
		
		objArr[4][0]="Banglore";
		objArr[4][1]="kerala";
		
		return objArr;
		
	}

}
