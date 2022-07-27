package org.vtiger.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class DatabaseQueryPractice {

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
		ResultSet result = statement.executeQuery("select * from sdet36");
		
		//iterate the data
		while(result.next()) {
			System.out.println(result.getString(1)+"   "+result.getString("empName"));
		}
		
		//validate the data
	/*	int count=0;
		while(result.next()) {
			if(result.getString("empname").equals("siva")) {
				System.out.println("Data is present");
				count++;
				break;
			}
	    }
		if(count==0) {
			System.out.println("Data is not present");
		}*/
		
		//close the connection
		connection.close();
		
		

	}

}
