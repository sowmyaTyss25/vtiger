package org.vtiger.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.tyss.genericUtility.ThreadSafeClass;
import org.tyss.genericUtility.WebDriverUtility;

public class CommonPage {


	public CommonPage(){
		PageFactory.initElements(ThreadSafeClass.getDriver(), this);
	}


	@FindBy(xpath = "//a[text()='More']")
	private WebElement moreTab;

	@FindBy(xpath = "//a[@name='Campaigns']")
	private WebElement campaignsTab;

	@FindBy(xpath = "//a[text()='Products']")
	private WebElement productsTab;

	@FindBy(xpath = "//a[text()='Documents']")
	private WebElement documentTab;


	@FindBy(xpath = "//td[@class='tabUnSelected']/a[text()='Organizations']")
	private WebElement organizationTab;

	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement adminstratoricon;

	@FindBy(xpath = "//a[text()='Sign Out']")
	private WebElement signOutLink;

	@FindBy(xpath = "//a[text()='Contacts']")
	private WebElement contactTab;

	/**
	 * This method is used to click on campaign tab
	 * @param webdriver
	 * @return 
	 */
	public CampaignPage ClickCampaign(WebDriverUtility webdriver) {
		webdriver.mouseHoverOnElement(moreTab);
		campaignsTab.click();
		return	new CampaignPage();
	}
	/**
	 * This method is used to click on the product tab
	 * @return 
	 */
	public ProductPage ClickProduct() {
		productsTab.click();
		return new ProductPage();
	}
	/**
	 * This method is used to click on the contact tab
	 * @return 
	 */
	public ContactPage ClickContact() {
		contactTab.click();
		return new ContactPage();
	}
	/**
	 * This method is used to click on the organization tab
	 * @return 
	 */
	public OrganizationPage ClickOrganization() {
		organizationTab.click();
		return new OrganizationPage();
	}
	/**
	 * This method is used to click on the document tab
	 * @return 
	 */
	public DocumentPage ClickDocument() {
		documentTab.click();
		return new DocumentPage();
	}
	/**
	 * This method is used to signout from the application
	 * @param webdriverutility
	 */
	public void logoutAction(WebDriverUtility webdriverutility) {
		webdriverutility.mouseHoverOnElement(adminstratoricon);
		signOutLink.click();
	}
}
