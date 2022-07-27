package org.vtiger.practice;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class AWSPractice
{

	public static void main(String[] args) throws MalformedURLException
	{
		
		//step 1 : load the url
		URL url=new URL("http://localhost:4444/wd/hub");
		
		//step 2: set desired capabilities
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setBrowserName("chrome");
		cap.setPlatform(Platform.WINDOWS);
		
		//step 3: load remote webdriver
		RemoteWebDriver driver=new RemoteWebDriver(url, cap);
		
		driver.manage().window().maximize();
		
		//step 4: load the application
		driver.get("https://gmail.com");

	}

}
