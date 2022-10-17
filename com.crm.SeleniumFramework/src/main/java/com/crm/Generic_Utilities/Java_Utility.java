package com.crm.Generic_Utilities;

import java.util.Random;

public class Java_Utility {
	
	/**
	 * This method is used to avoid Duplicate value
	 * @return
	 * @author Nikhil Madhumatke
	 */
	
	public int getRanDomNum()
	{
		Random ran=new Random();
		int RanNum =ran.nextInt(1000);
		return RanNum;
	}

}
