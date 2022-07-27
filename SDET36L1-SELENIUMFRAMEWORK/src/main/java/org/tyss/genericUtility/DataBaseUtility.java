package org.tyss.genericUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.jdbc.Driver;

/**
 * This class contains only database related reusable methods
 * @author Sivasubramaniam.M
 *
 */
public final class DataBaseUtility {
	private Driver dbDriver;
	private Connection connection;
	private Statement statement;
	
	/**
	 * This method is used to get Database Connection 
	 * @param url
	 * @param username
	 * @param password
	 */
	public void getConnectionWithDB(String url,String username,String password) {

		try {
			dbDriver = new Driver();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	    try {
			DriverManager.registerDriver(dbDriver);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	    try {
		connection=DriverManager.getConnection(url,username,password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	    
	}
    
	/**
	 * This method is used to get the data from the database
	 * @param sqlSelectQuery
	 * @param coloumNameOrColumnIndex
	 * @return
	 */
	public  List<String>  getDataFromDatabase(String sqlSelectQuery,String coloumNameOrColumnIndex) {
	     ResultSet result=null;
		List<String>    list = new ArrayList<>();
		String s1="";
		for(int i=0;i<coloumNameOrColumnIndex.length();i++) {
			if(Character.isDigit(coloumNameOrColumnIndex.charAt(i))) {
				s1=s1+coloumNameOrColumnIndex.charAt(i);
			}
			else
			{
				break;
			}
		}
		 try {
			 result = connection.createStatement().executeQuery(sqlSelectQuery);
			 System.out.println("Data entered into Database");
		}
		 catch (SQLException e) {
			e.printStackTrace();
		}
		 try {
			 while(result.next()) {
				 if(coloumNameOrColumnIndex.length()==s1.length()) {
					 list.add(result.getString(Integer.parseInt(s1)));
				 }
				 else
				 {
					 list.add(result.getString(coloumNameOrColumnIndex));
				 }
			 }
		 }
		 catch (SQLException e) {
				e.printStackTrace();
			}
		
		return list;
	}
	
	/**
	 * This method is used to verify data in the database
	 * @param sqlSelectQuery
	 * @param coloumNameOrColumnIndex
	 * @param expectedData
	 * @return
	 */
	public boolean verifyDataInDatabase(String sqlSelectQuery,String coloumNameOrColumnIndex,String expectedData) {
		List<String> list =getDataFromDatabase(sqlSelectQuery, coloumNameOrColumnIndex);
		boolean flag = false;
		for(String data:list)
		{
			if(data.equals(expectedData)) {
				flag=true;
				break;
			}
		}
		return flag;
	}
	/**
	 * This method is used to update the data into database
	 * @param sqlSelectQuery
	 * @return
	 */
	public int updateDataIntoDatabase(String sqlSelectQuery) {
		int result=0;
	     try {
			statement = connection.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			result=statement.executeUpdate(sqlSelectQuery);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	/**
	 * This method is used to close the connection
	 */
	public void closeDatabaseConnection() {
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}

















































