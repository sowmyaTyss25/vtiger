package org.vtiger.practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.tyss.genericUtility.JavaUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CalenderPopUp {

	public static void main(String[] args) {
		JavaUtility javaUtility=new JavaUtility();
		WebDriverManager.chromedriver().setup();
		WebDriver driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.hyrtutorials.com/p/calendar-practice.html");
		driver.findElement(By.xpath("//input[@id='first_date_picker']")).click();
		
	    WebElement currentMonthYear = driver.findElement(By.xpath("//div[@class='ui-datepicker-title']"));
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(currentMonthYear));
		String currentMonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
	    String currentYear = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
		System.out.println(currentMonth);
		System.out.println(currentYear);
		String reqDate = "24-November-2022";
		int currentMonthValue = javaUtility.convertMonthFromStringToInt("MMMM", currentMonth);
		int requiredMonthValue=javaUtility.convertMonthFromStringToInt("MMMM", reqDate.split("-")[1]);
		int currentYearValue=Integer.parseInt(currentYear);
		int requiredYearValue=Integer.parseInt(reqDate.split("-")[2]);
		System.out.println(currentMonthValue);
		System.out.println(requiredMonthValue);
		System.out.println(currentYearValue);
		System.out.println(requiredYearValue);
		try {
		while(requiredMonthValue>currentMonthValue||requiredYearValue>currentYearValue) {
			driver.findElement(By.xpath("//span[.='Next']")).click();
			currentMonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
		    currentYear = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
		    currentMonthValue = javaUtility.convertMonthFromStringToInt("MMMM", currentMonth);
		    currentYearValue=Integer.parseInt(currentYear);
			
		}
		while(requiredMonthValue<currentMonthValue||requiredYearValue<currentYearValue) {
			driver.findElement(By.xpath("//span[.='Prev']")).click();
			currentMonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
		    currentYear = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
		    currentMonthValue = javaUtility.convertMonthFromStringToInt("MMMM", currentMonth);
		    currentYearValue=Integer.parseInt(currentYear);
		}
		
		driver.findElement(By.xpath("//a[.='"+reqDate.split("-")[0]+"']")).click();
	}
		catch(Exception e) {
		System.out.println("please enter the proper format(dd-MMMM-yyyy)or please enter the valid date");
		}
		driver.quit();
	}

}
