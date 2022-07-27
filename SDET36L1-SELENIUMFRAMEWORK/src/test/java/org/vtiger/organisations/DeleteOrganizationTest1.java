package org.vtiger.organisations;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.tyss.genericUtility.ExcelUtility;
import org.tyss.genericUtility.FileUtility;
import org.tyss.genericUtility.IPathContants;
import org.tyss.genericUtility.JavaUtility;
import org.tyss.genericUtility.WebDriverUtility;

public class DeleteOrganizationTest1 {

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

			

				//launching the browser based on browser key
				WebDriver driver = webdriver.setupDriver(browser);

				//converting string to long
				long longTimeout = javautility.convertStringToLong(timeout);

				//pre-setting for the browser
				webdriver.maximizeBrowser();
				webdriver.implicitWait(longTimeout);
				WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(longTimeout));

				//initialize the explicit wait,Actions
				webdriver.initializeAction();


				//navigating to the application
				webdriver.openApplication(url);

				//login to the application
				driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(username);
				driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(password);
				driver.findElement(By.xpath("//input[@id='submitButton']")).click();
				javautility.printStatement("Successfully login");
				
		
		driver.findElement(By.xpath("//td[@class='tabUnSelected']/a[text()='Organizations']")).click();
		String expectedOrganizationName = "gbjb";
		String[] pagecount = driver.findElement(By.xpath("//span[@name='Accounts_listViewCountContainerName']")).getText().split(" ");
		String page = pagecount[pagecount.length-1];
	    int pages = Integer.parseInt(page);
	    System.out.println(pages);
		List<WebElement> listOrganization = driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr/td[3]/a"));
		WebElement nextBtn = driver.findElement(By.xpath("//a[@alt='Next']"));
		//boolean flag = true;
		for(int j=0;j<pages;j++) {
			 for(int i=0;i<listOrganization.size();i++)
			 {
				 
		    	   if(listOrganization.get(i).getText().equals(expectedOrganizationName)) 
		    	   {
		    		   driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr["+(i+2)+"]/td[1]/input")).click();
		    		  // flag=false;
		    		   break;
		    	   }   
			 }
			 nextBtn.click();
			 wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath("//div[@id='status']"))));
		}
		
//		driver.findElement(By.xpath("//input[@class='crmbutton small delete']")).click();
//		driver.switchTo().alert().accept();
//		
//		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath("//div[@id='status']"))));
		

	}

}
