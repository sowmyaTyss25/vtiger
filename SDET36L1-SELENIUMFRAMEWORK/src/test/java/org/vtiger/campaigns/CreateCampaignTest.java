package org.vtiger.campaigns;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.tyss.genericUtility.BaseClass;
import org.tyss.genericUtility.IPathContants;


@Listeners(org.tyss.genericUtility.ListenerImplementation.class)
public class CreateCampaignTest extends BaseClass {

	//@Test(groups = "sanity",retryAnalyzer = org.tyss.genericUtility.ListenerImplementation.class)
	@Test(groups="sanity")
	public void createCampaignTest()  {

		System.out.println("Create compaign Class "+Thread.currentThread().getId());
		//fetch the data from excel file
		String sheetName = "campaignmodule";
		String expectedCampaignName = excelutility.getDataFromExcel(2, 1,sheetName )+randomNumber;
		Assert.fail();

		String actualCampaignName =commonpage.ClickCampaign(webdriver).ClickOnCreateCampaignBtn().createCampaign(expectedCampaignName).SaveCampaign().getActualCampaignName();
	
		//validation
		if(actualCampaignName.equals(expectedCampaignName)) {
			javautility.printStatement("The Campaign is created ===>Test case is pass");
			excelutility.setDataIntoExcel(sheetName,2,3,IPathContants.VTIGERSTATUS1 );
			excelutility.saveOutputIntoExcel(IPathContants.VTIGEREXCELFILEPATH);
			javautility.printStatement("The data is entered");

		}
		else {
			javautility.printStatement("The Campaign is not created ===>Test case is fail");
			excelutility.setDataIntoExcel(sheetName,2,3,IPathContants.VTIGERSTATUS2);
			excelutility.saveOutputIntoExcel(IPathContants.VTIGEREXCELFILEPATH);
			javautility.printStatement("The data is entered");
		}
		//Assert.fail();



	}

}
