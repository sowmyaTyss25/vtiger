package org.vtiger.documents;

import org.testng.annotations.Test;
import org.tyss.genericUtility.BaseClass;
import org.tyss.genericUtility.IPathContants;
import org.vtiger.pom.CreateNewDocumentPage;
import org.vtiger.pom.DocumentInformationPage;
import org.vtiger.pom.DocumentPage;

public class CreateDocumentTest extends BaseClass {
	
     @Test
	public void createDocumentTest() {

		//fetch the data from excel file
		String sheetName = "documentmodule";
		String expectedTitle = excelutility.getDataFromExcel(2, 1,sheetName )+randomNumber;
		String expectedNote = excelutility.getDataFromExcel(2, 2,sheetName );
		String filePath = excelutility.getDataFromExcel(2, 3,sheetName );

    	//Creating object for the pom repo classes
		DocumentPage documentpage=new DocumentPage();
		CreateNewDocumentPage createnewdocumentpage=new CreateNewDocumentPage();
		DocumentInformationPage documentInformationpage=new DocumentInformationPage();
		
		//Creating the document
		commonpage.ClickDocument();
		documentpage.ClickOnCreateDocumentBtn();
		createnewdocumentpage.createTitle(expectedTitle);
		createnewdocumentpage.switchFrameAndWriteNotes(expectedNote, webdriver);
		webdriver.switchBackFromFrame("default");
		String expectedFilePath = System.getProperty("user.dir")+filePath;
		createnewdocumentpage.ChooseFileAndSave(expectedFilePath);
		//validation
		String actualTitle = documentInformationpage.getActualtitleName();
		String actualNote =documentInformationpage.getActualnotes();
		String actualFileName = documentInformationpage.getActualfileName();
		String[] splitFilePath=expectedFilePath.split("/");
		String expectedFileName = splitFilePath[splitFilePath.length-1];
		if(actualTitle.trim().equals(expectedTitle) && actualNote.trim().equals(expectedNote) && actualFileName.trim().equals(expectedFileName)) {
			javautility.printStatement("The Document created successfully ===>Test case is pass");
			excelutility.setDataIntoExcel(sheetName,2,4,IPathContants.VTIGERSTATUS1);
			excelutility.saveOutputIntoExcel(IPathContants.VTIGEREXCELFILEPATH);
			javautility.printStatement("The data is entered");

		}
		else {
			javautility.printStatement("The Document is not created ===>Test case is fail");
			excelutility.setDataIntoExcel(sheetName,2,4,IPathContants.VTIGERSTATUS2);
			excelutility.saveOutputIntoExcel(IPathContants.VTIGEREXCELFILEPATH);
			javautility.printStatement("The data is entered");
		}


	}

}
