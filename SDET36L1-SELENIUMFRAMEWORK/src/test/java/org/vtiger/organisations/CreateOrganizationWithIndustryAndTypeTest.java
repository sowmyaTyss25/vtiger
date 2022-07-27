package org.vtiger.organisations;

import org.testng.annotations.Test;
import org.tyss.genericUtility.BaseClass;
import org.tyss.genericUtility.IPathContants;
import org.vtiger.pom.CreateNewOrganizationPage;
import org.vtiger.pom.OrganizationInformationPage;
import org.vtiger.pom.OrganizationPage;

public class CreateOrganizationWithIndustryAndTypeTest extends BaseClass {
    
	@Test
	public void createOrganizationWithIndustryAndTypeTest(){


		//fetch the data from excel file
		String sheetName = "organizationmodule";
		String expectedOrganizationName = excelutility.getDataFromExcel(4, 1,sheetName )+randomNumber;
		String expectedIndustryName = excelutility.getDataFromExcel(4, 2,sheetName );
		String expectedTypeName = excelutility.getDataFromExcel(4, 3,sheetName );

		//Creating object for the pom repo classes
		OrganizationPage organizationpage=new OrganizationPage();
		CreateNewOrganizationPage createneworganizationpage=new CreateNewOrganizationPage();
		OrganizationInformationPage organizationinformationpage =new OrganizationInformationPage();

		//create organization name
		commonpage.ClickOrganization();
		organizationpage.ClickOnCreateOrganizationBtn();
		createneworganizationpage.createOrganization(expectedOrganizationName);
		createneworganizationpage.industryListBox(webdriver, expectedIndustryName);
		createneworganizationpage.typeDropDownBox(webdriver, expectedTypeName);
		createneworganizationpage.clickOnRadiobtn();
		createneworganizationpage.clickSavebtn();
		//validation
		String actualOrganizationName =organizationinformationpage.getActualOrganizationName();
		String actualIndustryName=organizationinformationpage.getActualIndustryName();
		String actualTypeName=organizationinformationpage.getActualTypeName();
		if(actualOrganizationName.trim().equals(expectedOrganizationName) && actualIndustryName.trim().equals(expectedIndustryName) && actualTypeName.equals(expectedTypeName))
		{
			javautility.printStatement("The Organization with industry and type is created ===> Test case is pass");
			excelutility.setDataIntoExcel(sheetName,4,4,IPathContants.VTIGERSTATUS1);
			excelutility.saveOutputIntoExcel(IPathContants.VTIGEREXCELFILEPATH);
			javautility.printStatement("The data is entered");
		}
		else {
			javautility.printStatement("The Organization with industry and type is not created ===> Test case is fail");
			excelutility.setDataIntoExcel(sheetName,2,3,IPathContants.VTIGERSTATUS2);
			excelutility.saveOutputIntoExcel(IPathContants.VTIGEREXCELFILEPATH);
			javautility.printStatement("The data is entered");
		}


	}

}
