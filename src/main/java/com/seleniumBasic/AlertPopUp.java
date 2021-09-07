package com.seleniumBasic;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class AlertPopUp {
//	(//a[@data-toggle='modal'])[1]
	public static void main(String[] args) throws InterruptedException {
	
			System.setProperty("webdriver.chrome.driver", 
					"C:\\Users\\Urmi\\eclipse-workspaceUrmi\\Batch_18_Selenium\\All_Driver\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://chercher.tech/practice/practice-pop-ups-selenium-webdriver");
			
			WebElement pop = driver.findElement(By.xpath("//*[@id=\"page-top\"]/div/div/div/div/div/div[2]/input[1]"));
			pop.click();
			
			Thread.sleep(4000);
			Alert al = driver.switchTo().alert();
			System.out.println(al.getText());
			
			Thread.sleep(4000);
			al.dismiss();
			
			
			Thread.sleep(4000);
			WebElement hover = driver.findElement(By.xpath("//*[@id='sub-menu']"));
			
			Actions ac = new Actions(driver);
			ac.moveToElement(hover);
	
	}

}
