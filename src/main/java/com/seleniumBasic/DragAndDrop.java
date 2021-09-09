package com.seleniumBasic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDrop {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", 
				"C:\\Users\\Urmi\\eclipse-workspaceUrmi\\Batch_18_Selenium\\All_Driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.com/");
		
		WebElement tab = driver.findElement(By.xpath("(//a[@class='nav-a nav-a-2   nav-progressive-attribute'])[1]"));
		Actions ac = new Actions(driver);
		ac.moveToElement(tab).build().perform();
		
	//	WebElement tab = driver.findElement(By.xpath("//*[@id=\"post-2669\"]/div[2]/div/div/h2[2]"));
	//	JavascriptExecutor executor = (JavascriptExecutor)driver;
	//	executor.executeScript("arguments[0].click();", tab);
	//	WebElement Drag = driver.findElement(By.xpath("//p[contains(text(),'Drag me to my target')]"));
	//	WebElement Drop = driver.findElement(By.xpath("//*[@id=\"droppable\"]"));
		
		
	}

}
