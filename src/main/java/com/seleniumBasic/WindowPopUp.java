package com.seleniumBasic;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowPopUp {
	
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./All_Driver/chromedriver.exe");
		WebDriver dr = new ChromeDriver();
		
		dr.get("https://demoqa.com/browser-windows");
		WebElement newTab = dr.findElement(By.xpath("//button[contains(text(),'New Tab')]"));
		Thread.sleep(3000);
		newTab.click();
		String pw = dr.getWindowHandle();
		newTab.click();
		newTab.click();
		System.out.println(pw);
		Set<String> aw = dr.getWindowHandles();
		System.out.println(aw);
		
		Iterator<String> it = aw.iterator();
		String mw = it.next();
		
		while(it.hasNext()) {
			String tw = it.next();
			if(mw != tw) {
				dr.switchTo().window(tw);
				Thread.sleep(3000);
				System.out.println(dr.getCurrentUrl());
				dr.close();
			}
		}
		
		Thread.sleep(2000);
		dr.switchTo().window(pw);
		dr.close();
		
	}

}
