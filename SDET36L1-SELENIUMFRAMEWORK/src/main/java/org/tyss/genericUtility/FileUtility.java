package org.tyss.genericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
/**
 * This class contains reusable method for csv file and property file
 * @author Sivasubramaniam.M
 *
 */
public final class FileUtility {
	Properties properties;
	/**
	 * This method is used for intiallize the property file
	 * @param filePath
	 */
	public void IntiallizePropertyFile(String filePath) {
	FileInputStream fis=null;
	try {
		fis = new FileInputStream(filePath);
	} catch (FileNotFoundException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	properties=new Properties();
	try {
		properties.load(fis);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	}
	
	
	/**
	 * This method is used to fetch the data from property file
	 * @param key
	 * @return
	 */
	public String getDataFromProperty(String key) {
		
	return	properties.getProperty(key);
	}
	/**
	 * This method is used to fetch data from CSV File
	 * @param csvFilePath
	 * @param rowNumber
	 * @param cellNumber
	 * @return
	 */
	public String getDataFromCSV(String csvFilePath,int rowNumber,int cellNumber ) {
		CSVReader reader = null;
		String allData=null;
		try {
			reader = new CSVReader(new FileReader(csvFilePath));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			 allData = reader.readAll().get(rowNumber)[cellNumber];
		} catch (IOException e) {
			e.printStackTrace();
		} catch (CsvException e) {
			e.printStackTrace();
		}
		
		return allData;
	}
	
}
