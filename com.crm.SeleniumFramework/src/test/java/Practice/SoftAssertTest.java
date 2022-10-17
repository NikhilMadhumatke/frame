package Practice;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertTest {
	
	@Test
	public void createCustomerTest()
	{
		System.out.println("Step1");
		System.out.println("Step2");
		SoftAssert soft=new SoftAssert();
		soft.assertEquals("A", "B");
		System.out.println("Step3");
		System.out.println("Step4");
		soft.assertAll();
	}

@Test
	public void modifyCustomerTest()
	{
	System.out.println("-----------------------");
	System.out.println("Step1");
	System.out.println("Step2");
	System.out.println("Step3");
	}


}
