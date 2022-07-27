package org.vtiger.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.tyss.genericUtility.ThreadSafeClass;

public class CreateNewProductsPage {
	public CreateNewProductsPage(){
		PageFactory.initElements(ThreadSafeClass.getDriver(), this);
	}
	
	@FindBy(xpath = "//input[@name='productname']")
	private WebElement productsNameTextField;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;

	//Business library
	/**
	 * This method is used to create product
	 * @param expectedProductName
	 * @return 
	 */
	public CreateNewProductsPage createProduct(String expectedProductName) {
		productsNameTextField.sendKeys(expectedProductName);
		return this;
		
	}
	/**
	 * This method is used to click on the save button
	 * @return 
	 */
	public ProductInformationPage clickOnSavebtn() {
		saveBtn.click();
		return new ProductInformationPage();
	}

}
