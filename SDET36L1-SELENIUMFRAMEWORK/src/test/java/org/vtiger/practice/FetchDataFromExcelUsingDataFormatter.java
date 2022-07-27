package org.vtiger.practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchDataFromExcelUsingDataFormatter {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
     DataFormatter dataformat=new DataFormatter();
     FileInputStream fis=new FileInputStream("./src/test/resources/testdata.xlsx");
     Workbook workbook = WorkbookFactory.create(fis);
    Sheet sheet = workbook.getSheet("contactmodule");
    for(int i=0;i<=sheet.getLastRowNum();i++) {
    	String data = dataformat.formatCellValue(sheet.getRow(i).getCell(1));
    	if(data.equalsIgnoreCase("organizationName")) {
    		System.out.println(sheet.getRow(i+1).getCell(1));
    		break;
  
    	}
    }
    workbook.close();


	}

}
