package org.vtiger.practice;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BirthdayBeauty {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		//Birthday wishes
		System.out.println("Wish U Happy Birthday To u Rachana ");
		System.out.println(" ");
		System.out.println("Beauty Queen,Always be happy and keep smile in your face di");
		System.out.println("  ");
		System.out.println("Sending you smiles for every moment of your special day…Have a wonderful time and a very happy birthday!.Hope your special day brings you all that your heart desires!");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		driver.get("https://youtu.be/_z-1fTlSDF0");
		driver.findElement(By.xpath("//div[text()='Skip Ad']")).click();
		driver.findElement(By.xpath("//button[@title='Play (k)']")).click();
		

	}

}
