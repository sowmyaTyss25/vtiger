package org.vtiger.organisations;

import org.testng.annotations.Test;
import org.tyss.genericUtility.BaseClass;
import org.tyss.genericUtility.IPathContants;
import org.vtiger.pom.CreateNewOrganizationPage;
import org.vtiger.pom.OrganizationInformationPage;
import org.vtiger.pom.OrganizationPage;

public class CreateOrganizationTest extends BaseClass {
	@Test
	public void createOrganizationTest() {

		//fetch the data from excel file
		String sheetName = "organizationmodule";
		String expectedOrganizationName = excelutility.getDataFromExcel(2, 1,sheetName )+randomNumber;

		//Creating object for the pom repo classes
		OrganizationPage organizationpage=new OrganizationPage();
		CreateNewOrganizationPage createneworganizationpage=new CreateNewOrganizationPage();
		OrganizationInformationPage organizationinformationpage =new OrganizationInformationPage();

		//create organization name
		commonpage.ClickOrganization();
		organizationpage.ClickOnCreateOrganizationBtn();
		javautility.printStatement("The Expected Organization name is "+expectedOrganizationName);
		createneworganizationpage.createOrganization(expectedOrganizationName);
		createneworganizationpage.clickSavebtn();

		//validation
		String actualOrganizationName = organizationinformationpage.getActualOrganizationName();
		javautility.printStatement("The Actual Organization name is "+actualOrganizationName);
		if(actualOrganizationName.trim().equals(expectedOrganizationName)) {
			javautility.printStatement("The organization name is created ===>Test case is pass");
			excelutility.setDataIntoExcel(sheetName,2,4,IPathContants.VTIGERSTATUS1);
			excelutility.saveOutputIntoExcel(IPathContants.VTIGEREXCELFILEPATH);
			javautility.printStatement("The data is entered");
		}
		else {
			javautility.printStatement("The organization name is not created ===>Test case is fail");
			excelutility.setDataIntoExcel(sheetName,2,4,IPathContants.VTIGERSTATUS2);
			excelutility.saveOutputIntoExcel(IPathContants.VTIGEREXCELFILEPATH);
			javautility.printStatement("The data is entered");
		}


	}

}
