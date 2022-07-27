package org.vtiger.campaigns;

import org.testng.annotations.Test;
import org.tyss.genericUtility.BaseClass;
import org.tyss.genericUtility.IPathContants;
import org.vtiger.pom.CampaignInformationPage;
import org.vtiger.pom.CreateNewCampaignPage;

public class CreateCampaignWithProductTest extends BaseClass {

	@Test(groups = "sanity")
	public void createCampaignWithProductTest() {

		System.out.println("create campaign with product Class "+Thread.currentThread().getId());
		//fetch the data from excel file
		String sheetName = "campaignmodule";
		String expectedProductName = excelutility.getDataFromExcel(4, 1,sheetName )+randomNumber;
		String expectedCampaignName = excelutility.getDataFromExcel(4, 2,sheetName )+randomNumber;

		//Creating object for the pom repo classes
		CreateNewCampaignPage createnewcampaignpage=new CreateNewCampaignPage();
		CampaignInformationPage campaigninformationpage=new CampaignInformationPage();


		//Creating the product name
		commonpage.ClickProduct().ClickOnCreateProductBtn().createProduct(expectedProductName).clickOnSavebtn();

		//mouse hover action for selecting campaign module
		commonpage.ClickCampaign(webdriver).ClickOnCreateCampaignBtn().createCampaign(expectedCampaignName).SelectProduct();

		//Creating campaign name
		webdriver.SwitchWindow("Products", "url");
		createnewcampaignpage.SearchExpectedProductName(expectedProductName,expectedProductName);
		webdriver.SwitchWindow("Campaigns","url");
		createnewcampaignpage.SaveCampaign();

		//validation
		String actualCampaignName = campaigninformationpage.getActualCampaignName();
		String actualProductName = campaigninformationpage.getActualProductName();
		if(actualCampaignName.trim().equals(expectedCampaignName) && actualProductName.trim().equals(expectedProductName)) {
			javautility.printStatement("The Campaign with product is created ===> Test case is pass");
			excelutility.setDataIntoExcel(sheetName, 4, 3, IPathContants.VTIGERSTATUS1);
			excelutility.saveOutputIntoExcel(IPathContants.VTIGEREXCELFILEPATH);
			javautility.printStatement("The data is entered");
		}
		else {
			javautility.printStatement("The Campaign with product is not created ===> Test case is fail");
			excelutility.setDataIntoExcel(sheetName, 4, 3, IPathContants.VTIGERSTATUS2);
			excelutility.saveOutputIntoExcel(IPathContants.VTIGEREXCELFILEPATH);
			javautility.printStatement("The data is entered");

		}



	}

}
