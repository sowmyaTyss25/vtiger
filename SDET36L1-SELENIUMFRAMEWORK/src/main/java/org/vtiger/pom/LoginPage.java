package org.vtiger.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.tyss.genericUtility.ThreadSafeClass;

public class LoginPage {
	@FindBy(xpath = "//input[@name='user_name']")
	private WebElement Username;
	
	@FindBy(xpath = "//input[@name='user_password']")
	private WebElement Password;
	
	@FindBy(xpath = "//input[@id='submitButton']")
	private WebElement Loginbtn;
	
	
	public LoginPage(){
		PageFactory.initElements(ThreadSafeClass.getDriver(), this);
	}
	//Business Libarary
	/**
	 * This method is used to login to the application
	 * @param userName
	 * @param password
	 * @return 
	 */
	public CommonPage loginAction(String userName,String password) {
		Username.sendKeys(userName);
		Password.sendKeys(password);
		Loginbtn.click();
		return new CommonPage();
	}

}
