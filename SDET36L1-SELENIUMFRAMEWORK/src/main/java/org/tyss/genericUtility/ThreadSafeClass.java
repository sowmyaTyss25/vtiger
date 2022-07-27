package org.tyss.genericUtility;

import org.openqa.selenium.WebDriver;

public class ThreadSafeClass {
	
	private static ThreadLocal<WebDriver> driver=new ThreadLocal<>();
	private static ThreadLocal<WebDriverUtility> driver1=new ThreadLocal<>();
	private static ThreadLocal<JavaUtility> driver2=new ThreadLocal<>();
	
	public static WebDriver getDriver() {
		return driver.get();
	}

	public static WebDriverUtility getDriver1() {
		return driver1.get();
	}

	public static JavaUtility getDriver2() {
		return driver2.get();
	}
	

	public static void setDriver2(JavaUtility javdriver) {
		driver2.set(javdriver);
	}
	
	public static void setDriver1(WebDriverUtility webdriver) {
		driver1.set(webdriver);
	}

	public static void setDriver(WebDriver actdriver) {
		driver.set(actdriver);
	}
	
	

}
