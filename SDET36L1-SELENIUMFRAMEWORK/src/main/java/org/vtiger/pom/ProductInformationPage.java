package org.vtiger.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.tyss.genericUtility.ThreadSafeClass;

public class ProductInformationPage {
	
	public ProductInformationPage(){
		PageFactory.initElements(ThreadSafeClass.getDriver(), this);
	}

	@FindBy(xpath = "//span[@id='dtlview_Product Name']")
	private WebElement actualProductNameText;
	/**
	 * This method is used to get the actual product name
	 * @return
	 */
	 public String getActualProductName() {
	    	return actualProductNameText.getText();
	    }
	
	
}
