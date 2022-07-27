package org.vtiger.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.tyss.genericUtility.ThreadSafeClass;

public class CreateNewContactsPage {
	public CreateNewContactsPage(){
		PageFactory.initElements(ThreadSafeClass.getDriver(), this);
	}
	
	@FindBy(xpath = "//input[@name='lastname']")
	private WebElement contactlastNameTextField;
	
	@FindBy(xpath = "//input[@class='crmButton small save']")
	private WebElement saveBtn;
	
	@FindBy(xpath = "//td[text()='Organization Name 			']/following-sibling::td[@class='dvtCellInfo']/img")
	private WebElement OrganizationBtn;
	
	@FindBy(xpath ="//input[@id='search_txt']")
	private WebElement searchText;
	
	@FindBy(xpath ="//input[@name='search']")
	private WebElement searchbtn;
	

	//Business library
	/**
	 * This method is used to set the expected contact name in last name text field
	 * @param expectedContactName
	 */
	public void createContact(String expectedContactName) {
		contactlastNameTextField.sendKeys(expectedContactName);
		
	}
	/**
	 * This method is used to click on the save button
	 */
	public void clickSavebtn() {
		saveBtn.click();
	}
	/**
	 * This method is used to click on the organization button
	 */
	public void clickOnOrganizationbtn() {
		OrganizationBtn.click();
	}
    /**
     * This method is used to get the expected organization name
     * @param expectedOrganizationName
     * @param driver
     */
	public void SearchExpectedOrganizationName(String expectedOrganizationName,WebDriver driver) {
		searchText.sendKeys(expectedOrganizationName);
		searchbtn.click();
		driver.findElement(By.xpath("//a[text()='"+expectedOrganizationName+"']")).click();
	}

}
