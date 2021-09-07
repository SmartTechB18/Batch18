package com.seleniumBasic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.genericLibrary.BaseLogin;

public class Selenium_first {

	public static void main(String[] args) throws InterruptedException {
		BaseLogin obj = new BaseLogin();
		
		WebDriver driver = obj.openURL();
		WebElement dressTab = driver.findElement(By.xpath("(//a[@class='sf-with-ul'])[4]"));
		dressTab.click();
		
		
		List<WebElement> allDress = new ArrayList<WebElement>();
		allDress = driver.findElements(By.xpath("//div[@class='right-block']//div//span[@itemprop='price']"));
		
		List<Double> allPrices = new ArrayList<Double>();
		
		for(int i=0; i<allDress.size(); i++) {
		System.out.println(allDress.get(i).getText());
		String x = allDress.get(i).getText().replace("$", "").replace(" ", "");
		double priceConvert = Double.parseDouble(x);
		allPrices.add(priceConvert);
		}
		
		double max = Collections.max(allPrices);
		System.out.println("Highest price is : "+max);
		
		String MaxPrice = String.valueOf(max);
//div[@class='right-block']//div//span[contains(text(),'50.99')]/parent::div/following-sibling::div/a/span[contains(text(),'Add to cart')]
		String HighXpath = "//div[@class='right-block']//div//span[contains(text(),'"+MaxPrice+"')]/parent::div/following-sibling::div/a/span[contains(text(),'More')]";

		WebElement sd = driver.findElement(By.xpath(HighXpath));
	//	sd.click();
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", sd);
		
		WebElement qty = driver.findElement(By.xpath("//input[@name='qty']"));
		qty.clear();
		qty.sendKeys("3");
		
		
		
		
		//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a/span
//		WebElement PrcdChckot = driver.findElement(By.xpath("//div[@class='layer_cart_cart col-xs-12 col-md-6']//span[contains(text(),'Proceed to checkout')]//i"));		
//		PrcdChckot.click();
//		executor.executeScript("arguments[0].click();", PrcdChckot);
		
	//	driver.close();
		
		
		
		//sd.click();
		
//String HighXpath = "//div[@class='right-block']//div//span[contains(text(),'"+MaxPrice+"')]/parent::div/following-sibling::div/a/span[contains(text(),'Add to cart')]"));
//div[@class='right-block']//div//span[contains(text(),'50.99')]/parent::div/parent::div/preceding-sibling::div		
		
/*		WebElement HighXpath = driver.findElement(By.xpath("//div[@class='right-block']//div//span[contains(text(),'"+MaxPrice+"')]/parent::div/parent::div/preceding-sibling::div"));
			
		HighXpath.click();
		
		Thread.sleep(5000);
		driver.switchTo();
		WebElement qty = driver.findElement(By.xpath("//*[@id='quantity_wanted']"));
		qty.sendKeys("3");
*/	
	//	driver.close();
	}

}
