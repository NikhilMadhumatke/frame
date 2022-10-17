package com.crm.Generic_Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class File_Utility1 {
	
	/**
	 * This method is used to launch the application
	 * @param Key
	 * @return
	 * @throws Throwable
	 * @author Nikhil Madhumatke
	 */
	
	public String getPropertyKeyValue(String Key) throws Throwable
	{
	//	FileInputStream fis=new FileInputStream("./Common_Data.properties");
		FileInputStream fis=new FileInputStream(ipathConstant.PROPERTYFILE_PATH);
		Properties pro=new Properties();
		pro.load(fis);
		String value = pro.getProperty(Key);
		return value;
	}

}
