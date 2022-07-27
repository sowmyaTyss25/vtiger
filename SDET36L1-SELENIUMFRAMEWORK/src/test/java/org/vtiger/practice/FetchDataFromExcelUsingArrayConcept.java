package org.vtiger.practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchDataFromExcelUsingArrayConcept {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		 DataFormatter dataformat=new DataFormatter();
	     FileInputStream fis=new FileInputStream("./src/test/resources/testdata.xlsx");
	     Workbook workbook = WorkbookFactory.create(fis);
	     Sheet sheet = workbook.getSheet("Sheet1");
	     int rowNum = sheet.getLastRowNum();
	     short cellNum = sheet.getRow(0).getLastCellNum();
	     String[][] str=new String[rowNum][cellNum];
         for(int i=1;i<=rowNum;i++) {
        	 for(int j=0;j<cellNum;j++) {
        		 str[i-1][j]=dataformat.formatCellValue(sheet.getRow(i).getCell(j));
        	 }
         }
         System.out.println(str[5][1]);
         workbook.close();
	}

}
