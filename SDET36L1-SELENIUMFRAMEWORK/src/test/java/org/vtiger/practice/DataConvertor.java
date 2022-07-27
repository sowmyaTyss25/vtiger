package org.vtiger.practice;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;

public class DataConvertor {

	public static void main(String[] args) {
		String s="24-11-1996"; //dd-MM-yyyy
		DateTimeFormatter dtf=DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate month=LocalDate.parse(s,dtf);
		//System.out.println(month.getMonth());//November
	    //System.out.println(month.getDayOfMonth());//24
		//System.out.println(month.getDayOfYear());//329
       //System.out.println(month.getMonthValue());//11
		//System.out.println(month.getDayOfWeek());//sunday
		System.out.println(month.get(ChronoField.MONTH_OF_YEAR));//11
		System.out.println(month.get(ChronoField.DAY_OF_MONTH));
	}

}
