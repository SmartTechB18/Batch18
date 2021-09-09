package com.genericLibrary;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.PageObjectModel.HomePageFactory;

public class BaseLogin {
	
	WebDriver driver;
	HomePageFactory pf;
	
	public WebDriver openURL() {		
		System.setProperty("webdriver.chrome.driver", 
				"C:\\Users\\Urmi\\eclipse-workspaceUrmi\\Batch_18_Selenium\\All_Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		pf = new HomePageFactory(driver);
		driver.get(pf.getUrl());
		return driver;
	}
	
	public void signInPage() throws InterruptedException {	
		JavascriptExecutor js = (JavascriptExecutor) driver; // type casting polymorphism
		js.executeScript("arguments[0].setAttribute('style', 'background: blue; border: 2px solid red;');", pf.getSignButn());
		Thread.sleep(5000);
		pf.getSignButn().click();
		if(driver.getTitle().contains("Login - My Store")) {
			System.out.println("Landed to the signin page successfully...");
		}
		else {
			System.out.println("Sign in page verifucation failed.");
		}
	}
	
	public void login() {	
		JavascriptExecutor js = (JavascriptExecutor) driver; // type casting polymorphism
		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 4px solid red;');", pf.getEmail());
		
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		pf.getEmail().sendKeys(pf.getUserName());	
		
		js.executeScript("arguments[0].setAttribute('style', 'background: green; border: 4px solid blue;');", pf.getEmail());
		
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		pf.getPass().sendKeys(pf.getPassword());	
		pf.getSignBtn2().click();	
		if(pf.getSt().getText().contains("Smart Tech")) {
			System.out.println("User successfully logged in.");
		}
		else {System.out.println("User is not logged in. But the Credential is valid");}
	}
	
	public void tearDown() {
		driver.close();
	}
}
