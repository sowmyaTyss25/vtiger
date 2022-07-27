package org.tyss.genericUtility;

import org.openqa.selenium.WebDriver;
import org.vtiger.pom.CommonPage;
import org.vtiger.pom.LoginPage;

public class instanceClass {
	public FileUtility fileutility;
	public WebDriverUtility webdriver;
	public JavaUtility javautility;
	public ExcelUtility excelutility;
	protected String url;
	protected String username;
	protected String password ;
	public String browser;
	protected long longTimeout;
	protected LoginPage loginpage;	
	public CommonPage commonpage;
	public int randomNumber;
	public  WebDriver driver;

}
