package Practice;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class Priorities {
	
	public class PrioritiesOfTestCases {
		
		@Test(priority=2)
		public void calls() {
			Reporter.log("calls",true);
		}

		
		@Test(priority=-1)
		public void chats() {
			Reporter.log("chats",true);
		}
		
		@Test(priority=1)
		public void settings() {
			Reporter.log("settings",true);
		}
	}

}
