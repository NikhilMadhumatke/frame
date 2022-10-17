package Practice;

import java.sql.Connection;
import java.sql.DriverManager;
//import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class JDBCMysqlNonQuerySelect {

	public static void main(String[] args) throws SQLException {
		
		Driver driverRef=new Driver();
		DriverManager.registerDriver(driverRef);
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test_yantra", "root", "root");
		
        Statement state = conn.createStatement();
		
	    String query="insert into student(first_name,last_name,address)value('raju','BN','INDIA')";
		
	    int result = state.executeUpdate(query);
	
		 if(result==1)
			{
				System.out.println("the data is inserted");
			}
			else
			{
				System.out.println("data is not inserted");
			}
		 
		 conn.close();


	}

}
