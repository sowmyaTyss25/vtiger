package org.vtiger.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.tyss.genericUtility.ThreadSafeClass;

public class ContactInformationPage {
	
	public ContactInformationPage(){
		PageFactory.initElements(ThreadSafeClass.getDriver(), this);
	}
	
	@FindBy(xpath = "//td[@id='mouseArea_Last Name']")
	private WebElement actualContactLastNameText;
	/**
	 * This method is used to get the actual contact name 
	 * @return
	 */
	 public String getActualContactLastName() {
	    	return actualContactLastNameText.getText();
	    }

}
