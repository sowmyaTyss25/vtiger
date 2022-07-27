package org.vtiger.organisations;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.tyss.genericUtility.ExcelUtility;
import org.tyss.genericUtility.FileUtility;
import org.tyss.genericUtility.IPathContants;
import org.tyss.genericUtility.JavaUtility;
import org.tyss.genericUtility.WebDriverUtility;
import org.vtiger.pom.CommonPage;
import org.vtiger.pom.CreateNewOrganizationPage;
import org.vtiger.pom.LoginPage;
import org.vtiger.pom.OrganizationInformationPage;
import org.vtiger.pom.OrganizationPage;

public class DeleteOrganizationTest {

	public static void main(String[] args) throws IOException {
		//creating object for the class
		FileUtility fileutility=new FileUtility();
		WebDriverUtility webdriver=new WebDriverUtility();
		JavaUtility javautility=new JavaUtility();
		ExcelUtility excelutility=new ExcelUtility();


		//intialize data from property file
		fileutility.IntiallizePropertyFile(IPathContants.VTIGERPROPERTYFILEPATH);

		//Generate the random number
		int randomNumber = javautility.getRandomNumber();


		//get the control for the particular sheet in excel
		excelutility.intiallizeExcelFile(IPathContants.VTIGEREXCELFILEPATH);


		//Fatching the data from property
		String url = fileutility.getDataFromProperty("url");
		String username = fileutility.getDataFromProperty("username");
		String password = fileutility.getDataFromProperty("password");
		String browser = fileutility.getDataFromProperty("browser");
		String timeout = fileutility.getDataFromProperty("timeout");

		//fetch the data from excel file
		String sheetName = "organizationmodule";
		String expectedOrganizationName = excelutility.getDataFromExcel(6, 1,sheetName )+randomNumber;

		//launching the browser based on browser key
		WebDriver driver = webdriver.setupDriver(browser);
		
		//Creating object for the pom repo classes
		LoginPage loginpage=new LoginPage();
		CommonPage commonpage=new CommonPage();
		OrganizationPage organizationpage=new OrganizationPage();
		CreateNewOrganizationPage createneworganizationpage=new CreateNewOrganizationPage();
		OrganizationInformationPage organizationinformationpage =new OrganizationInformationPage();

		//converting string to long
		long longTimeout = javautility.convertStringToLong(timeout);

		//pre-setting for the browser
		webdriver.maximizeBrowser();
		webdriver.implicitWait(longTimeout);

		//initialize the explicit wait,Actions
		webdriver.initializeAction();


		//navigating to the application
		webdriver.openApplication(url);

		//login to the application
		loginpage.loginAction(username, password);
		javautility.printStatement("Successfully login");
		//create organization
		commonpage.ClickOrganization();
		organizationpage.ClickOnCreateOrganizationBtn();
		javautility.printStatement(expectedOrganizationName);
		createneworganizationpage.createOrganization(expectedOrganizationName);
		createneworganizationpage.clickSavebtn();

		//explicit wait		
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(longTimeout));
		WebElement visibleText = driver.findElement(By.xpath("//span[@class='small']"));
		wait.until(ExpectedConditions.visibilityOf(visibleText));
		//Deleting the expectedOrganization name
		driver.findElement(By.xpath("//a[@class='hdrLink']")).click();
		String[] pagecount = driver.findElement(By.xpath("//span[@name='Accounts_listViewCountContainerName']")).getText().split(" ");
		String page = pagecount[pagecount.length-1];
		driver.findElement(By.xpath("//input[@class='small']")).clear();
		driver.findElement(By.xpath("//input[@class='small']")).sendKeys(page,Keys.ENTER);
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath("//div[@id='status']"))));
		List<WebElement> listOrganization = driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr/td[3]/a"));
		for(int i=0;i<listOrganization.size();i++)
		{
			String organization = listOrganization.get(i).getText();
			if(organization.equals(expectedOrganizationName)) 
			{
				driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr["+(i+2)+"]/td[1]/input")).click();
				break;
			}
		}
		driver.findElement(By.xpath("//input[@class='crmbutton small delete']")).click();
		driver.switchTo().alert().accept();

		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath("//div[@id='status']"))));

		List<WebElement> listOrganization1 = driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr/td[3]/a"));

		for(WebElement org:listOrganization1)
		{

			String organization = org.getText();
			if(!organization.equals(expectedOrganizationName)) 
			{

				javautility.printStatement("Test case is pass");
				excelutility.setDataIntoExcel(sheetName,6,4,IPathContants.VTIGERSTATUS1);
				excelutility.saveOutputIntoExcel(IPathContants.VTIGEREXCELFILEPATH);
				javautility.printStatement("The data is entered");
				break;
			}
			else
			{
				javautility.printStatement("Test case is failed");
				excelutility.setDataIntoExcel(sheetName,6,4,IPathContants.VTIGERSTATUS2);
				excelutility.saveOutputIntoExcel(IPathContants.VTIGEREXCELFILEPATH);
				javautility.printStatement("The data is entered");
			}

		}

		/* int count=0;
       for(int i=0;i<listOrganization1.size();i++)
       {
    	   String organization = listOrganization1.get(i).getText();
    	   if(organization.equals(expectedOrganizationName)) 
    	   {
    		   count++;
    		   break;
    	   }
       }
       if(count==0) {
    	   System.out.println("Test case is pass");
       }*/

		//Mouse hover action for sign out
		WebElement administratorModule= driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		webdriver.mouseHoverOnElement(administratorModule);
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();

		//workbook close for saving the data in the excel
		excelutility.workbookClose();

		//closing the browser
		webdriver.closeBrowser();

	}

}
