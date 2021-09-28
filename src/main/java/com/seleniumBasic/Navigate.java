package com.seleniumBasic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Navigate {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./All_Driver/chromedriver.exe");
		WebDriver dr = new ChromeDriver();
		dr.get("http://automationpractice.com/index.php");
		
		WebElement si = dr.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a"));
		si.click();
		Thread.sleep(3000);
		dr.navigate().back();

	}

}
