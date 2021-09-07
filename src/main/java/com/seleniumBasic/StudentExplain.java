package com.seleniumBasic;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.genericLibrary.BaseLogin;

public class StudentExplain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
BaseLogin obj = new BaseLogin();
		
		WebDriver driver = obj.openURL();
		WebElement dressTab = driver.findElement(By.xpath("(//a[@class='sf-with-ul'])[4]"));
		dressTab.click();
		
		List<WebElement> allDress = new ArrayList<WebElement>();
		allDress = driver.findElements(By.xpath("//div[@class='right-block']//div//span[@itemprop='price']"));
		
		int counter =0;
		for(int i=0; i<allDress.size(); i++) {
			System.out.println(allDress.get(i).getText());
			counter++;
		}
		
		System.out.println(counter);
		
	//	System.out.println(allDress.get(0).getText());
	}

}
