package org.vtiger.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.tyss.genericUtility.ThreadSafeClass;
import org.tyss.genericUtility.WebDriverUtility;

public class CreateNewDocumentPage {
	
	public CreateNewDocumentPage(){
		PageFactory.initElements(ThreadSafeClass.getDriver(), this);
	}
	
	@FindBy(xpath = "//input[@name='notes_title']")
	private WebElement titleTextBox;
	
	@FindBy(xpath = "//iframe")
	private WebElement childFrame;
	
	@FindBy(xpath = "//body[@class='cke_show_borders']")
	private WebElement notes;
	
	@FindBy(xpath = "//input[@id='filename_I__']")
	private WebElement fileName;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement savebtn;
	/**
	 * This method is used to create title
	 * @param expectedTitle
	 */
	public void createTitle(String expectedTitle) {
		titleTextBox.sendKeys(expectedTitle);
	}
	/**
	 * This method is used to write the notes 
	 * @param expectedNote
	 * @param webdriver
	 */
	public void switchFrameAndWriteNotes(String expectedNote,WebDriverUtility webdriver) {
		webdriver.switchFrameByWebElement(childFrame);
		notes.sendKeys(expectedNote);
	}
	/**
	 * This method is used to choose the file
	 * @param expectedFilePath
	 */
	public void ChooseFileAndSave(String expectedFilePath) {
		fileName.sendKeys(expectedFilePath);
		savebtn.click();
	}
	

}
