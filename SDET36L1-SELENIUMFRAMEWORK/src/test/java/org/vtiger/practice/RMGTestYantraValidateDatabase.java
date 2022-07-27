package org.vtiger.practice;


import java.sql.SQLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.tyss.genericUtility.DataBaseUtility;
import org.tyss.genericUtility.ExcelUtility;
import org.tyss.genericUtility.FileUtility;
import org.tyss.genericUtility.IPathContants;
import org.tyss.genericUtility.JavaUtility;
import org.tyss.genericUtility.WebDriverUtility;

public class RMGTestYantraValidateDatabase {

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
		String projectName = excelutility.getDataFromExcel(2, 1,sheetName )+randomNumber;

		//launching the browser based on browser key
		WebDriver driver = webdriver.setupDriver(browser);


		//converting string to long
		long longTimeout = javautility.convertStringToLong(timeout);

		//pre-setting for the browser
		webdriver.maximizeBrowser();
		webdriver.implicitWait(longTimeout);

		javautility.printStatement("Browser launched successfully");

		//navigating to the application
		webdriver.openApplication(url);


		javautility.printStatement("Project Name ==> "+projectName);
		driver.findElement(By.xpath("//input[@id='usernmae']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@id='inputPassword']")).sendKeys(password);
		driver.findElement(By.xpath("//button[text()='Sign in']")).click();
		javautility.printStatement("Successfully login");
		driver.findElement(By.xpath("//a[text()='Projects']")).click();
		driver.findElement(By.xpath("//span[text()='Create Project']")).click();
		driver.findElement(By.xpath("//input[@name='projectName']")).sendKeys(projectName);
		driver.findElement(By.xpath("//input[@name='createdBy']")).sendKeys("Sivasubramaniam");
		WebElement statusListBox = driver.findElement(By.xpath("//label[text()='Project Status ']/following-sibling::select"));
		//Use xpath axes siblings only(dont use //label[text()='Project Status ']/../select[@name='status'])
		webdriver.handleSelectDropDownByVisibleText(statusListBox, "On Goging");
		driver.findElement(By.xpath("//input[@class='btn btn-success']")).click();
		javautility.printStatement("Successfully created project");

		databaseutility.getConnectionWithDB(rmgconnectionurl+database,rmgconnectionusername,rmgconnectionpassword);
		String query = "select * from project;";
        boolean status = databaseutility.verifyDataInDatabase(query, "project_name", projectName);

			if(status==true) {
				javautility.printStatement("The project is present in the database");
				javautility.printStatement("ActualProjectName ==> "+projectName);
			}
			else
				javautility.printStatement("Project is not present in Database");
		
		//closing the connection
		databaseutility.closeDatabaseConnection();
		
		//closing the browser
		webdriver.closeBrowser();

	}
}
