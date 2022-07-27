package org.tyss.genericUtility;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.vtiger.pom.CommonPage;
import org.vtiger.pom.LoginPage;

public class BaseClass extends instanceClass
{
	//@Parameters("browser")
	@BeforeClass(groups = "common")
	//public void classSetup(String browser) {
		
		public void classSetup() {
		//creating object for the class
		System.out.println("Before Class "+Thread.currentThread().getId());
		fileutility=new FileUtility();
		webdriver=new WebDriverUtility();
		javautility=new JavaUtility();
		excelutility=new ExcelUtility();
		
		ThreadSafeClass.setDriver1(webdriver);
		ThreadSafeClass.setDriver2(javautility);

		//intialize data from property file
		fileutility.IntiallizePropertyFile(IPathContants.VTIGERPROPERTYFILEPATH);

		//get the control for the particular sheet in excel
		excelutility.intiallizeExcelFile(IPathContants.VTIGEREXCELFILEPATH);

		//Fatching the data from property
		url = fileutility.getDataFromProperty("url");
		username = fileutility.getDataFromProperty("username");
		password = fileutility.getDataFromProperty("password");
		browser = fileutility.getDataFromProperty("browser");
		String timeout = fileutility.getDataFromProperty("timeout");

		//converting string to long
		longTimeout = javautility.convertStringToLong(timeout);


		//launching the browser based on browser key
		driver = webdriver.setupDriver(browser);
		//call the setter method from driver class in order to set driver instance
		ThreadSafeClass.setDriver(driver);


		//pre-setting for the browser
		webdriver.maximizeBrowser();
		webdriver.implicitWait(longTimeout);
		webdriver.initializeExplicitWait(longTimeout);

		//initialize the explicit wait,Actions
		webdriver.initializeAction();

		//Creating object for the common pom repo classes
		
		commonpage=new CommonPage();

		//navigating to the application
		webdriver.openApplication(url);
	}
	
	@BeforeMethod(groups = "common")
	public void methodSetUp() {
		System.out.println("Before Method "+Thread.currentThread().getId());
		//Generate the random number
		randomNumber = javautility.getRandomNumber();
		//login to the application
		loginpage=new LoginPage();
		loginpage.loginAction(username, password);

	}
	
	@AfterMethod(groups = "common")
	public void methodTearDown() {

		//Mouse hover action for sign out
		commonpage.logoutAction(webdriver);


	}
	
	@AfterClass(groups = "common")
	public void classTearDown() {

		//workbook close for saving the data in the excel
		excelutility.workbookClose();

		//closing the browser
		webdriver.closeBrowser();

	}


}
