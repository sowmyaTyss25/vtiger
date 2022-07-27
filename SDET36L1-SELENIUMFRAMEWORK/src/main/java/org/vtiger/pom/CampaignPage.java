package org.vtiger.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.tyss.genericUtility.ThreadSafeClass;

public class CampaignPage {
	
	public CampaignPage(){
		PageFactory.initElements(ThreadSafeClass.getDriver(), this);
	}
	
	@FindBy(xpath = "//img[@alt='Create Campaign...']")
	private WebElement createCampaignbtn;
	
	
	//business library
	/**
	 * This method is used to click on the create campaign button
	 * @return 
	 */
	public CreateNewCampaignPage ClickOnCreateCampaignBtn() {
		createCampaignbtn.click();
		return new CreateNewCampaignPage();
	}
	

}
