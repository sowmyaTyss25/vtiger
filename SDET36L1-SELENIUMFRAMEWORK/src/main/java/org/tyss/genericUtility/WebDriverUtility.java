package org.tyss.genericUtility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * This class contains all the webdriver actions
 * @author Sivasubramaniam.M
 *
 */
public final class WebDriverUtility {
	private WebDriver driver;
	private Actions act;
	private Select select;
	private WebDriverWait wait;


	/**
	 * This method is used to setup the driver instance
	 * @param browser
	 */
	public WebDriver setupDriver(String browser) {

		switch (browser) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			break;

		default:
			System.out.println("The browser is not working");
			break;
		}
		return driver;
	}



	/**
	 * This method is used to maximize the browser
	 */
	public void maximizeBrowser() {

		driver.manage().window().maximize();
	}

	/**
	 * This method is used to wait by using implicitwait
	 * @param longTimeout
	 */
	public void implicitWait(long longTimeout) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(longTimeout));
	}
	/**
	 * This method is used to initialize the explict wait or webDriverWait
	 * @param longtimeout
	 */
	public void initializeExplicitWait(long longtimeout) {
		wait=new WebDriverWait(driver, Duration.ofSeconds(longtimeout));
	}
	/**
	 * This method is used to wait the page until the element is visible
	 * @param element
	 */
	public void explicitWaitByVisbilityOf(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	/**
	 * This method is used to wait the page until the element is invisible
	 * @param element
	 */
	public void explicitWaitByInvisbilityOf(WebElement element) {
		wait.until(ExpectedConditions.invisibilityOf(element));
	}
	/**
	 * This method is used for accepting the alert popup
	 */
	public void jsPopupaccept() {
		driver.switchTo().alert().accept();
	}
	/**
	 * This method is used for delete the alert pupup
	 */
	public void jsPopupdecline() {
		driver.switchTo().alert().dismiss();
	}
	/**
	 * This method is used to send some msg in the alert popup
	 * @param data
	 */
	public void jsPopupSendData(String data) {
		driver.switchTo().alert().sendKeys(data);
	}
	/**
	 * This method is used to get text in the alert popup
	 */
	public void jsPopupGetText() {
		driver.switchTo().alert().getText();
	}
	/**
	 * This method is used to wait the page until the element is clickable(Custom wait)
	 * @param totalDuration
	 * @param element
	 * @param pollingTime
	 */
	public  void waitTillElementClickable(int totalDuration,WebElement element,int pollingTime) {
		int currentTime=0;
		while(currentTime<=totalDuration)
		{
			try 
			{
				element.click();
				break;
			}catch(Exception e)
			{
				try
				{
					Thread.sleep(pollingTime);
				} catch (InterruptedException e1)
				{
					e1.printStackTrace();
				}
				currentTime++;
			}
		}
	}

	/**
	 * This method is used to navigate the application
	 * @param url
	 */
	public void openApplication(String url) {
		driver.get(url);
	}
	/**
	 * This method is used to initialize the action class
	 */
	public void initializeAction() {
		act=new Actions(driver);
	}
	/**
	 * This method is used to mouse hover on the element
	 * @param element
	 */
	public void mouseHoverOnElement(WebElement element) {
		act.moveToElement(element).perform();

	}

	/**
	 * This method is used to perform right click action on currentmouse location
	 */
	public void rightClickAction() {
		act.contextClick().perform();
	}
	/**
	 * This method is used to perform right click action on webelement
	 * @param element
	 */
	public void rightClickAction(WebElement element) {
		act.contextClick(element).perform();
	}

	/**
	 * This method is used to switch frame based on index
	 * @param indexNumber
	 */
	public void switchFrameByIndex(int indexNumber) {
		driver.switchTo().frame(indexNumber);
	}

	/**
	 * This method is used to switch frame based on nameOrId
	 * @param nameOrId
	 */
	public void switchFrameByWebElement(String nameOrId){
		driver.switchTo().frame(nameOrId);
	}
	/**
	 * This method is used to switch frame based on webelement
	 * @param webelement
	 */
	public void switchFrameByWebElement(WebElement webelement ){
		driver.switchTo().frame(webelement);
	}
	/**
	 * This method is used to switch back frame by using default or parent
	 * @param strategy
	 */
	public void switchBackFromFrame(String strategy){
		switch (strategy.toLowerCase().trim()) {
		case "default":
			driver.switchTo().defaultContent();
			break;
		case "parent":
			driver.switchTo().parentFrame();
			break;

		default:
			System.out.println("please enter valid strategy either default or parent");
		}

	}  
	/**
	 * This method is used to handle select tag dropdown by using visibleText 
	 * @param dropDownElement
	 * @param visibleText
	 */
	public void handleSelectDropDownByVisibleText(WebElement dropDownElement,String visibleText) {
		select = new Select(dropDownElement);
		select.selectByVisibleText(visibleText);

	}
	/**
	 * This method is used to handle select tag dropdown by using value
	 * @param value
	 * @param dropDownElement
	 */
	public void handleSelectDropDownByValue(String value,WebElement dropDownElement) {
		select = new Select(dropDownElement);
		select.selectByValue(value);
	}
	/**
	 * This method is used to handle select tag dropdown by using index number
	 * @param dropDownElement
	 * @param indexNumber
	 */
	public void handleSelectDropDownByIndex(WebElement dropDownElement,int indexNumber) {
		select = new Select(dropDownElement);
		select.selectByIndex(indexNumber);
	}

	/**
	 * This method is used to switch the window by using url or title
	 * @param partialText
	 * @param strategy
	 */
	public void SwitchWindow(String partialText,String strategy) {
		Set<String> windIds = driver.getWindowHandles();
		for(String id:windIds) {
			driver.switchTo().window(id);
			if(strategy.equalsIgnoreCase("url")) {
				if(driver.getCurrentUrl().contains(partialText)) {
					break;	
				}
			}

			else if(strategy.equalsIgnoreCase("title")) {
				if(driver.getTitle().contains(partialText)) {
					break;	
				}
			}
		}
	}

	/**
	 * This method is used to take screenshot of the entire webpage
	 * @param currentClass
	 * @param javaUtility
	 */
	public void TakesScreenShot(Object currentClass,JavaUtility javaUtility)
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		File trg=new File("./errorshots/"+currentClass.getClass().getSimpleName()+javaUtility.getCurrentDate("dd_MM_yyyy_HH_mm_sss")+".png");
		try 
		{
			FileUtils.copyFile(src, trg);
		} catch (IOException e) 
		{
			e.printStackTrace();
		}

	}
	/**
	 * This method is used to take the screenshot of particular webelement
	 * @param currentClass
	 * @param javaUtility
	 * @param element
	 */
	public void TakesScreenShot(Object currentClass,JavaUtility javaUtility,WebElement element)
	{
		File src=element.getScreenshotAs(OutputType.FILE);
		File trg=new File("./errorshots/"+currentClass.getClass().getSimpleName()+"_"+javaUtility.getCurrentDate("dd_MM_yyyy_HH_mm_sss")+".png");
		try 
		{
			FileUtils.copyFile(src, trg);
		} catch (IOException e) 
		{
			e.printStackTrace();
		}

	}

	/**
	 * This method is used to close the browser
	 */
	public void closeBrowser() {
		driver.quit();
	}

	/**
	 * This method is used to close the tab
	 */
	public void closeTab() {
		driver.close();
	}
	
	public String takescreenshot(WebDriver driver) {
		TakesScreenshot ts=(TakesScreenshot) driver;
		String fullimage = ts.getScreenshotAs(OutputType.BASE64);
		return fullimage;
		
	}
}
