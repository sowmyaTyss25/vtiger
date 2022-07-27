package org.vtiger.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.tyss.genericUtility.ThreadSafeClass;

public class OrganizationPage {
	
	public OrganizationPage(){
		PageFactory.initElements(ThreadSafeClass.getDriver(), this);
	}
	
	@FindBy(xpath = "//img[@alt='Create Organization...']")
	private WebElement createOrganizationbtn;
	
	
	//business library
	/**
	 * This method is used to click on the create Organization button
	 * @return 
	 */
	public CreateNewOrganizationPage ClickOnCreateOrganizationBtn() {
		createOrganizationbtn.click();
		return new CreateNewOrganizationPage();
	}

}
