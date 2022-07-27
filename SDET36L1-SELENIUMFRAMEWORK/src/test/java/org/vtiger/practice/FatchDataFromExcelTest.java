package org.vtiger.practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FatchDataFromExcelTest {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		Random ran=new Random();
		int randomNumber = ran.nextInt(1000);
		FileInputStream fis=new FileInputStream("./src/test/resources/testdata.xlsx");
		Workbook workbook = WorkbookFactory.create(fis);
		String data = workbook.getSheet("contactmodule").getRow(2).getCell(1).getStringCellValue()+randomNumber;
		System.out.println(data);
		workbook.close();

	}

}
