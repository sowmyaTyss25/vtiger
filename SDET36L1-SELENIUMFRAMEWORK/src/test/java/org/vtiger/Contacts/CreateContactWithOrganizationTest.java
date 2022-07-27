package org.vtiger.Contacts;

import org.testng.annotations.Test;
import org.tyss.genericUtility.BaseClass;
import org.tyss.genericUtility.IPathContants;
import org.tyss.genericUtility.ThreadSafeClass;
import org.vtiger.pom.ContactInformationPage;
import org.vtiger.pom.ContactPage;
import org.vtiger.pom.CreateNewContactsPage;
import org.vtiger.pom.CreateNewOrganizationPage;
import org.vtiger.pom.OrganizationInformationPage;
import org.vtiger.pom.OrganizationPage;

public class CreateContactWithOrganizationTest extends BaseClass {

	@Test
	public void createContactWithOrganizationTest() {


		//fetch the data from excel file
		String sheetName = "contactmodule";
		String expectedOrganizationName = excelutility.getDataFromExcel(4, 1,sheetName )+randomNumber;
		String expectedContactName = excelutility.getDataFromExcel(4, 2,sheetName )+randomNumber;



		//Creating object for the pom repo classes
		ContactPage contactpage=new ContactPage();
		CreateNewContactsPage createnewcontactspage=new CreateNewContactsPage();
		ContactInformationPage contactinformationpage=new ContactInformationPage();
		OrganizationPage organizationpage=new OrganizationPage();
		CreateNewOrganizationPage createneworganizationpage=new CreateNewOrganizationPage();
		OrganizationInformationPage organizationinformationpage =new OrganizationInformationPage();

		//Create organization name		
		commonpage.ClickOrganization();
		organizationpage.ClickOnCreateOrganizationBtn();
		javautility.printStatement("The Expected Organization name is "+expectedOrganizationName);
		createneworganizationpage.createOrganization(expectedOrganizationName);
		createneworganizationpage.clickSavebtn();

		//explicitwait 

		webdriver.explicitWaitByVisbilityOf(organizationinformationpage.OrganizationConformationText());

		//Organization created
		javautility.printStatement("The organization name is created");

		//Create contact name
		commonpage.ClickContact();
		contactpage.ClickOnCreateContactsBtn();
		javautility.printStatement("The Expected contact name is "+expectedContactName);
		createnewcontactspage.createContact(expectedContactName);
		createnewcontactspage.clickOnOrganizationbtn();
		webdriver.SwitchWindow("Organization", "url");


		createnewcontactspage.SearchExpectedOrganizationName(expectedOrganizationName, ThreadSafeClass.getDriver());
		webdriver.SwitchWindow("Campaigns","url");
		createnewcontactspage.clickSavebtn();

		//Validation

		String actualContactName =contactinformationpage.getActualContactLastName();
		javautility.printStatement("The actual contact name is "+actualContactName);
		String actualOrganizationName =organizationinformationpage.getActualOrganizationName();
		javautility.printStatement("The actual Organization name is "+actualOrganizationName);
		if(expectedContactName.equals(actualContactName.trim()) && actualOrganizationName.trim().equals(expectedOrganizationName)) {
			javautility.printStatement("The expected Organization name is "+expectedOrganizationName);
			javautility.printStatement("The Contact with organization name is created ===> Test case is pass");
			excelutility.setDataIntoExcel(sheetName,4,3,IPathContants.VTIGERSTATUS1);
			excelutility.saveOutputIntoExcel(IPathContants.VTIGEREXCELFILEPATH);
			javautility.printStatement("The data is entered");
		}
		else {
			javautility.printStatement("The contact with organization name is not created===>Test case is fail");
			excelutility.setDataIntoExcel(sheetName,4,3,IPathContants.VTIGERSTATUS2);
			excelutility.saveOutputIntoExcel(IPathContants.VTIGEREXCELFILEPATH);
			javautility.printStatement("The data is entered");
		}


	}

}
