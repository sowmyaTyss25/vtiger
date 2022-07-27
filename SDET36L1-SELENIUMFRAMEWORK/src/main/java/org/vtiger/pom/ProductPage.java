package org.vtiger.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.tyss.genericUtility.ThreadSafeClass;

public class ProductPage {
	public ProductPage(){
		PageFactory.initElements(ThreadSafeClass.getDriver(), this);
	}
	
	@FindBy(xpath = "//img[@alt='Create Product...']")
	private WebElement createProductbtn;
	
	//business library
		/**
		 * This method is used to click on the create product button
		 * @return 
		 */
		public CreateNewProductsPage ClickOnCreateProductBtn() {
			createProductbtn.click();
			return new CreateNewProductsPage();
		}
	

}
