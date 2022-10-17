package com.crm.Generic_Utilities;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerImplementationClass implements ITestListener {

	public void onTestFailure(ITestResult result) {
		String data=result.getMethod().getMethodName();
		
		EventFiringWebDriver edriver=new EventFiringWebDriver(BaseClass.sDriver);
		File src=edriver.getScreenshotAs(OutputType.FILE);
		
		try {
			File des =new File("./com.crm.SeleniumFramework/ScreenShot/"+data+".png");
			FileUtils.copyFile(src, des);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	

}
