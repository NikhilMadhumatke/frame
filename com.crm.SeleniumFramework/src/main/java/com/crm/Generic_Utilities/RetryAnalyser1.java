package com.crm.Generic_Utilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyser1 implements IRetryAnalyzer {

	int count=0;
	int retrylimit=3;
	public boolean retry(ITestResult result) {
		
		if(count<retrylimit)
		{
			count++;
			return true;
		}
		
		return false;
	}

	

	   

}
