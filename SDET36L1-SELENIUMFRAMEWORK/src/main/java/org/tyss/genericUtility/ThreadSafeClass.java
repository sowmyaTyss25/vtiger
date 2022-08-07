package org.tyss.genericUtility;

import org.openqa.selenium.WebDriver;

public class ThreadSafeClass {
	
	private static ThreadLocal<WebDriver> driver=new ThreadLocal<>();
	private static ThreadLocal<WebDriverUtility> webdriverUtility=new ThreadLocal<>();
	private static ThreadLocal<JavaUtility> javaUtility=new ThreadLocal<>();
	
	public static WebDriver getDriver() {
		return driver.get();
	}

	public static WebDriverUtility getDriver1() {
		return webdriverUtility.get();
	}

	public static JavaUtility getDriver2() {
		return javaUtility.get();
	}
	

	public static void setDriver2(JavaUtility javadriver) {
		javaUtility.set(javadriver);
	}
	
	public static void setDriver1(WebDriverUtility webdriver) {
		webdriverUtility.set(webdriver);
	}

	public static void setDriver(WebDriver actdriver) {
		driver.set(actdriver);
	}
	
	

}
