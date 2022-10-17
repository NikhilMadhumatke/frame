package Practice;

import org.testng.annotations.Test;

public class SampleTestNg {
	@Test
	public void createCustomerTest()
	{
		System.out.println("Customer details Created");
	}
	
	@Test(dependsOnMethods="createCustomerTest")
	public void modifyCustomerTest()
	{
		System.out.println("Customer details modified");
	}
	
	@Test(dependsOnMethods="createCustomerTest")
	public void deleteCustomerTest()
	{
		System.out.println("Customer details deleted");
	}
}
	