package org.vtiger.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.tyss.genericUtility.ThreadSafeClass;
import org.tyss.genericUtility.WebDriverUtility;

public class CreateNewOrganizationPage {
	public CreateNewOrganizationPage(){
		PageFactory.initElements(ThreadSafeClass.getDriver(), this);
	}
	
	@FindBy(xpath = "//input[@name='accountname']")
	private WebElement organizationNameTextField;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	@FindBy(xpath = "//select[@name='industry']")
	private WebElement industryDropDownBox;
	
	@FindBy(xpath = "//select[@name='accounttype']")
	private WebElement typeDropDownBox ;
	
	@FindBy(xpath = "//input[@value='T']")
	private WebElement assignToRadiobtn ;

	//Business library
	/**
	 * This method is used to create the organization
	 * @param expectedOrganizationName
	 */
	public void createOrganization(String expectedOrganizationName) {
		organizationNameTextField.sendKeys(expectedOrganizationName);
	}
	/**
	 * This method is used to select the industry
	 * @param webdriver
	 * @param expectedIndustryName
	 */
	public void industryListBox(WebDriverUtility webdriver,String expectedIndustryName) {
		webdriver.handleSelectDropDownByValue(expectedIndustryName, industryDropDownBox);
	}
	/**
	 * This method is used to select the type
	 * @param webdriver
	 * @param expectedTypeName
	 */
	public void typeDropDownBox(WebDriverUtility webdriver,String expectedTypeName ) {
		webdriver.handleSelectDropDownByValue(expectedTypeName,typeDropDownBox);
	}
	/**
	 * This method is used to click on the radio button
	 */
	public void clickOnRadiobtn() {
		assignToRadiobtn.click();
	}
	/**
	 * This method is used to click on the save button
	 */
	public void clickSavebtn() {
	saveBtn.click();
	}
}
