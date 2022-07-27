package org.vtiger.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.tyss.genericUtility.ThreadSafeClass;

public class DocumentPage {
	
	public DocumentPage(){
		PageFactory.initElements(ThreadSafeClass.getDriver(), this);
	}
	
	@FindBy(xpath = "//img[@alt='Create Document...']")
	private WebElement createDocumentbtn;
	
	
	//business library
	/**
	 * This method is used to click on the create document button
	 * @return 
	 */
	public CreateNewDocumentPage ClickOnCreateDocumentBtn() {
		createDocumentbtn.click();
		return new CreateNewDocumentPage();
	}
	

}
