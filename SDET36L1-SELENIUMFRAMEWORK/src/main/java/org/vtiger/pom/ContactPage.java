package org.vtiger.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.tyss.genericUtility.ThreadSafeClass;

public class ContactPage {
	public ContactPage(){
		PageFactory.initElements(ThreadSafeClass.getDriver(), this);
	}
	
	@FindBy(xpath = "//img[@alt='Create Contact...']")
	private WebElement createContactbtn;
	
	
	//business library
	/**
	 * This method is used to click on the create contact button
	 * @return 
	 */
	public CreateNewContactsPage ClickOnCreateContactsBtn() {
		createContactbtn.click();
		return new CreateNewContactsPage();
	}
}
