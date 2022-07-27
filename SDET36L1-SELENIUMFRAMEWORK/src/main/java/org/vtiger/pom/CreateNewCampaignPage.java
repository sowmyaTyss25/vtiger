package org.vtiger.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import org.tyss.genericUtility.ThreadSafeClass;

public class CreateNewCampaignPage {
	public CreateNewCampaignPage(){
		PageFactory.initElements(ThreadSafeClass.getDriver(), this);
	}
	
	@FindBy(xpath = "//input[@name='campaignname']")
	private WebElement campaignNameTextField;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	@FindBy(xpath ="//input[@id='search_txt']")
	private WebElement searchText;
	
	@FindBy(xpath ="//input[@name='search']")
	private WebElement searchbtn;
	
	@FindBy(xpath = "//img[@alt='Select']")
	private WebElement SelectProduct;
	
	String expectedProductelement="//a[text()='%s']";
	

	//Business library
	/**
	 * This method is used to set the expected campaign name
	 * @param expectedCampaignName
	 * @return 
	 */
	public CreateNewCampaignPage createCampaign(String expectedCampaignName) {
		campaignNameTextField.sendKeys(expectedCampaignName);
		return this;
		
	}
	public WebElement convertdynamicxpathtoWebElement(String elementPartialXpath,String replaceData)
	{
		String xpath=String.format(elementPartialXpath, replaceData);
		return ThreadSafeClass.getDriver().findElement(By.xpath(xpath));
	}
	/**
	 * This method is used get the expected product name
	 * @param expectedProductName
	 * @param driver
	 * @return 
	 */
	public CreateNewCampaignPage SearchExpectedProductName(String expectedProductName,String replaceData) {
		searchText.sendKeys(expectedProductName);
		searchbtn.click();
		convertdynamicxpathtoWebElement(expectedProductelement,replaceData).click();
		return this;
	}
	/**
	 * This method is used to select the product
	 * @return 
	 */
	public CreateNewCampaignPage SelectProduct() {
		SelectProduct.click();
		return this;
	}
	/**
	 * This method is used save the data
	 * @return 
	 */
	public CampaignInformationPage SaveCampaign() {
		saveBtn.click();
		return new CampaignInformationPage();
	}
	
}
