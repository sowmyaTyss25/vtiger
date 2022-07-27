package org.vtiger.Contacts;

import org.testng.annotations.Test;
import org.tyss.genericUtility.BaseClass;
import org.tyss.genericUtility.IPathContants;
import org.vtiger.pom.ContactInformationPage;
import org.vtiger.pom.ContactPage;
import org.vtiger.pom.CreateNewContactsPage;

public class CreateContactTest extends BaseClass {
	@Test
	public void createContactTest() {

		//fetch the data from excel file
		String sheetName = "contactmodule";
		String expectedContactName = excelutility.getDataFromExcel(2, 1,sheetName )+randomNumber;

		//Creating object for the pom repo classes
		ContactPage contactpage=new ContactPage();
		CreateNewContactsPage createnewcontactspage=new CreateNewContactsPage();
		ContactInformationPage contactinformationpage=new ContactInformationPage();

		//Create the contact name
		commonpage.ClickContact();
		contactpage.ClickOnCreateContactsBtn();
		createnewcontactspage.createContact(expectedContactName);
		createnewcontactspage.clickSavebtn();

		//validation
		String actualContactName = contactinformationpage.getActualContactLastName();
		if(actualContactName.trim().equals(expectedContactName)) {
			javautility.printStatement("The contact name is created ===>The test case is pass");
			excelutility.setDataIntoExcel(sheetName,2,3,IPathContants.VTIGERSTATUS1);
			excelutility.saveOutputIntoExcel(IPathContants.VTIGEREXCELFILEPATH);
			javautility.printStatement("The data is entered");
		}
		else {
			javautility.printStatement("the contact name is not created ===>The test case is fail");
			excelutility.setDataIntoExcel(sheetName,2,3,IPathContants.VTIGERSTATUS2);
			excelutility.saveOutputIntoExcel(IPathContants.VTIGEREXCELFILEPATH);
			javautility.printStatement("The data is entered");
		}


	}

}
