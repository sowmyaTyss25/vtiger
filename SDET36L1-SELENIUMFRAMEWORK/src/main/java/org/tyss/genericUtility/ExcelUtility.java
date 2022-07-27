package org.tyss.genericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 *This class contains reusable method of excel file 
 * @author Sivasubramaniam.M
 *
 */
public final class ExcelUtility {
	private Workbook workbook;
	Sheet sheet;
	/**
	 * This method is used to intiallize the excel file
	 * @param excelPath
	 */
	public void intiallizeExcelFile(String excelPath) {
		FileInputStream file;
		try {
			file = new FileInputStream(excelPath);
			workbook = WorkbookFactory.create(file);
		} catch (FileNotFoundException e1) {
		
			e1.printStackTrace();
		}
		 catch (EncryptedDocumentException e) {
		
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}
	
	/**
	 * This method is used for fecthing the data from the excel
	 * @param rowNumber
	 * @param cellNumber
	 * @param sheetName
	 * @return
	 */
	public String getDataFromExcel(int rowNumber,int cellNumber,String sheetName) {
		sheet = workbook.getSheet(sheetName);
	return new DataFormatter().formatCellValue(sheet.getRow(rowNumber).getCell(cellNumber));
		
	}
	/**
	 * This method is used to save data into excel
	 * @param excelpath
	 */
	public void saveOutputIntoExcel(String excelpath) {
		FileOutputStream fos=null;
		try {
			fos = new FileOutputStream(excelpath);
			workbook.write(fos);
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		catch (IOException e) {

			e.printStackTrace();
		}
		
	}
	/**
	 * This method is used to set the data into excel
	 * @param setExcelData
	 * @param rowNumber
	 * @param CreatecellNumber
	 * @param sheetName
	 */
	public void setDataIntoExcel(String sheetName,int rowNumber,int CreatecellNumber,String status) {
        workbook.getSheet(sheetName);
        sheet.getRow(rowNumber).createCell(CreatecellNumber).setCellValue(status);
	}

	/**
	 * This method is used to close the workbook
	 */
	public void workbookClose() {
		try {
			workbook.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
