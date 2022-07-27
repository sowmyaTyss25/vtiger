package org.vtiger.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.tyss.genericUtility.ThreadSafeClass;

public class OrganizationInformationPage {
	public OrganizationInformationPage(){
		PageFactory.initElements(ThreadSafeClass.getDriver(), this);
	}
	
	@FindBy(xpath = "//span[@class='small']")
	private WebElement updatedConformationText;
	
	@FindBy(xpath = "//td[@id='mouseArea_Organization Name']")
	private WebElement actualOrganizationNameText;
	
	@FindBy(xpath = "//span[@id='dtlview_Industry']")
	private WebElement actualIndustryNameText;
	
	@FindBy(xpath = "//span[@id='dtlview_Type']")
	private WebElement actualTypeNameText;
	/**
	 * This method is used to get the actual organization name
	 * @return
	 */
	 public String getActualOrganizationName() {
	    	return actualOrganizationNameText.getText();
	    }
	/**
	 * This method is used get conformation page
	 * @return
	 */
	public WebElement OrganizationConformationText() {
		return updatedConformationText;
		
		
	}
	/**
	 * This method is used to get the actual industry name
	 * @return
	 */
	 public String getActualIndustryName() {
	    	return actualIndustryNameText.getText();
	    }
	 /**
	  * This method is used to get the actual type name
	  * @return
	  */
	 public String getActualTypeName() {
	    	return actualTypeNameText.getText();
	    }

}
