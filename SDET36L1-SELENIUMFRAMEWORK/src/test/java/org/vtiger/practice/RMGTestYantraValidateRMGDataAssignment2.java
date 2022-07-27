package org.vtiger.practice;

import java.sql.SQLException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.tyss.genericUtility.DataBaseUtility;
import org.tyss.genericUtility.ExcelUtility;
import org.tyss.genericUtility.FileUtility;
import org.tyss.genericUtility.IPathContants;
import org.tyss.genericUtility.JavaUtility;
import org.tyss.genericUtility.WebDriverUtility;

public class RMGTestYantraValidateRMGDataAssignment2 {

	public static void main(String[] args) throws SQLException {
		
		//creating object for the class
		WebDriverUtility webdriver=new WebDriverUtility();
		JavaUtility javautility=new JavaUtility();
		FileUtility fileutility=new FileUtility();
		DataBaseUtility databaseutility=new DataBaseUtility();
		ExcelUtility excelutility=new ExcelUtility();
		
		//intialize data from property file
		fileutility.IntiallizePropertyFile(IPathContants.VTIGERPROPERTYFILEPATH);


		//Fatching the data from property
		String browser = fileutility.getDataFromProperty("browser");
		String timeout = fileutility.getDataFromProperty("timeout");
		String url = fileutility.getDataFromProperty("rmgurl");
		String username = fileutility.getDataFromProperty("rmgusername");
		String password = fileutility.getDataFromProperty("rmgpassword");
		String rmgconnectionusername = fileutility.getDataFromProperty("rmgdatabaseconnectionusername");
		String rmgconnectionpassword = fileutility.getDataFromProperty("rmgdatabaseconnectionpassword");
		String rmgconnectionurl = fileutility.getDataFromProperty("rmgdatabaseconnectionurl");
		String database = fileutility.getDataFromProperty("database");

		//Generate the random number
		int randomNumber = javautility.getRandomNumber();

		//get the control for the particular sheet in excel
		excelutility.intiallizeExcelFile(IPathContants.RMGEXCELFILEPATH);


		//fetch the data from excel file
		String sheetName = "rmg";
		String  expectedProjectName = excelutility.getDataFromExcel(2, 1,sheetName )+randomNumber;

		//launching the browser based on browser key
		WebDriver driver = webdriver.setupDriver(browser);
		javautility.printStatement("Browser launched successfully");


		//converting string to long
		long longTimeout = javautility.convertStringToLong(timeout);

		//pre-setting for the browser
		webdriver.maximizeBrowser();
		webdriver.implicitWait(longTimeout);


        //Get connection with Database
		databaseutility.getConnectionWithDB(rmgconnectionurl+database,rmgconnectionusername, rmgconnectionpassword);
		//update data into database
		String query = "insert into project(project_id,created_by,project_name,team_size) values('TY_PROJ_7"+randomNumber+"','amar','"+expectedProjectName+"',0);";
		databaseutility.updateDataIntoDatabase(query);
		javautility.printStatement("The project added into database sucessfully");


		//navigating to the application
		webdriver.openApplication(url);
       
		//Login to the application
		driver.findElement(By.xpath("//input[@id='usernmae']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@id='inputPassword']")).sendKeys(password);
		driver.findElement(By.xpath("//button[text()='Sign in']")).click();
		javautility.printStatement("Successfully login");
		driver.findElement(By.xpath("//a[text()='Projects']")).click();
		List<WebElement> listOfProjects= driver.findElements(By.xpath("//table[@class='table table-striped table-hover']/tbody/tr/td[2]"));
		for(WebElement project:listOfProjects) {
			String actualProjectName = project.getText();
			if(actualProjectName.equals(expectedProjectName)) {

				javautility.printStatement("The project is present in the list of project page and Given test script is pass");
				javautility.printStatement("ActualProjectName ==> "+actualProjectName);

			}

		}

		//closing the connection
		databaseutility.closeDatabaseConnection();
		
		//closing the browser
		webdriver.closeBrowser();



	}

}
