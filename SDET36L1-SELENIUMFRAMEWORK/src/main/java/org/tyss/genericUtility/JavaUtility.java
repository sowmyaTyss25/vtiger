package org.tyss.genericUtility;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

/**
 * This class contains java reusable methods
 * @author Sivasubramaniam.M
 *
 */
public final class JavaUtility {
	/**
	 * This method is used to generate the random number
	 * @return
	 */
	public int getRandomNumber() {
		return new Random().nextInt(1000);
	}
	/**
	 * This method is used to generate the random number
	 * @param Limit
	 * @return
	 */
	public int getRandomNumber(int Limit) {
		return new Random().nextInt(Limit);
	}
	
	/**
	 * This method is used to convert string to long datatype
	 * @param stringData
	 * @return
	 */
	public long convertStringToLong(String stringData) {
		return Long.parseLong(stringData);
	}
	/**
	 * This method  is used to get the current date in simple date format
	 */
	public String getCurrentDate(String strategy) {
		
		return new SimpleDateFormat(strategy).format(new Date());
	}
	/**
	 * The method is used to split the string based on value and strategy
	 * @param value
	 * @param strategy
	 * @return
	 */
	public String[] splitString(String value ,String strategy) {
		return value.split(strategy);
	}
	/**
	 * This method is used to print the values in the console
	 * @param value
	 */
	public void printStatement(String value) {
		System.out.println(value);
	}
	/**
	 * This method is to convert month string to integer
	 * @param Strategy
	 * @param monthName
	 * @return
	 */
	public int convertMonthFromStringToInt(String Strategy,String monthName) {
		return DateTimeFormatter.ofPattern(Strategy).withLocale(Locale.ENGLISH).parse(monthName).get(ChronoField.MONTH_OF_YEAR);
	}

}
