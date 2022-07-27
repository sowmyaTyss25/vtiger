package org.vtiger.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class DatabaseUpdatePractice {

	public static void main(String[] args) throws SQLException {
		//create the object for driver class which is given by database vendor
				Driver driver=new Driver();
				
				//register the driver to jdbc
				DriverManager.registerDriver(driver);
				
				//establish the connection
				Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ty_siva","root","root");
				
				//create statement
				Statement statement = connection.createStatement();
				
				//execute query
				int result = statement.executeUpdate("insert into sdet36(empId,empName) values(104,'dinesh');");
				
				//validate the data
				if(result==1) {
					System.out.println("Data enter into database");
				}
				
			
				ResultSet res = statement.executeQuery("select * from sdet36");
				
			
				while(res.next()) {
					System.out.println(res.getString(1)+"   "+res.getString("empName"));
				}
				
				//close the connection
				connection.close();
				
				
	}

}
 