package org.vtiger.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.tyss.genericUtility.ThreadSafeClass;

public class DocumentInformationPage {
	
	public DocumentInformationPage(){
		PageFactory.initElements(ThreadSafeClass.getDriver(), this);
	}
	
	@FindBy(xpath = "//span[@id='dtlview_Title']")
	private WebElement titleTextBox;
	
	@FindBy(xpath = "//p")
	private WebElement notesTextBox;
	
	@FindBy(xpath = "//td[@class='dvtCellInfo']/a")
	private WebElement fileNameTextBox;
	  /**
	   * This method is used to get the actual title
	   * @return
	   */
	  public String getActualtitleName() {
	    	return titleTextBox.getText();
	    }
	  /**
	   * This method is used to get the actual notes 
	   * @return
	   */
	  public String getActualnotes() {
	    	return notesTextBox.getText();
	    }
	  /**
	   * This method is used to get the actual file name
	   * @return
	   */
	  public String getActualfileName() {
	    	return fileNameTextBox.getText();
	    }

}
