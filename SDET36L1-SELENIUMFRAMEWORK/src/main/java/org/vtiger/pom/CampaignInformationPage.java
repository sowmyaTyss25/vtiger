package org.vtiger.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.tyss.genericUtility.ThreadSafeClass;

public class CampaignInformationPage {
	
	public CampaignInformationPage(){
		PageFactory.initElements(ThreadSafeClass.getDriver(), this);
	}
	
	@FindBy(xpath = "//span[@id='dtlview_Campaign Name']")
	private WebElement actualCampaignNameText;
	
	@FindBy(xpath = "//span[@id='dtlview_Product']")
	private WebElement actualProductNameText;
	
	//Business library
	/**
	 * This method is used to get the actual campaign name
	 * @return
	 */
    public String getActualCampaignName() {
    	return actualCampaignNameText.getText();
    }
    /**
     * This method is used to get the actual product name
     * @return
     */
    public String getActualProductName() {
    	return actualProductNameText.getText();
    }
}
