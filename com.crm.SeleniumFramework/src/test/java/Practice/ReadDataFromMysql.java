package Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class ReadDataFromMysql {

	public static void main(String[] args) throws Throwable {
		
		Driver driverRef=new Driver(); //--- this is mysql driver
	    
		//Step 1: Register the Driver/database
		DriverManager.registerDriver(driverRef);
		
		//Step 2: get the connection with database - use database name
Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test_yantra", "root", "root");
		
		//Step 3: issue create statement
		Statement state = conn.createStatement();
		
		String selectQuery ="select * from student";
		
		//Step 4: execute the query - use table name
		 ResultSet result = state.executeQuery(selectQuery);
	
		while(result.next())
		{
			System.out.println(result.getString(1)+"\t"+result.getString(2)+"\t"+result.getString(3)+"\t"+result.getString(4));
		}
		
		//Step 5: close the database
		conn.close();

	}

}
