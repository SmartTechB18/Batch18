package com.genericLibrary;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import com.PageObjectModel.HomePageFactory;
import com.cofigLibrary.Credentials;
import com.utility.Highlight;
import com.utility.TestScreenShot;
import com.utility.Wait;

public class BaseLogin {
	
	WebDriver driver;
	HomePageFactory pf;
	
	public WebDriver openURL() throws Exception {		
		System.setProperty("webdriver.chrome.driver", 
				"./All_Driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		pf = new HomePageFactory(driver);
		driver.get(Credentials.getConfig("url"));
		return driver;
	}
	
	public void signInPage() throws InterruptedException {	
		Highlight.getcolor(driver, pf.getSignButn());
		
		pf.getSignButn().click();
		if(driver.getTitle().contains("Login - My Store")) {
			System.out.println("Landed to the signin page successfully...");
			TestScreenShot.captureScreenShot(driver, "HomePgae");
		}
		else {
			System.out.println("Sign in page verifucation failed.");
		}
	}
	
	public void login() throws Exception {	
	
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		
		Highlight.getcolor(driver, pf.getEmail(), "blue");
			
		pf.getEmail().sendKeys(Credentials.getConfig("userName"));		
		Highlight.getcolor(driver, pf.getEmail());	
		pf.getPass().sendKeys(Credentials.getConfig("password"));
		
		Wait.getExplicitWaitClicable(driver, pf.getSignBtn2());
		pf.getSignBtn2().click();	
		if(pf.getSt().getText().contains("Smart Tech")) {
			System.out.println("User successfully logged in.");
			TestScreenShot.captureScreenShot(driver, "User logged in");
		}
		else {System.out.println("User is not logged in. But the Credential is valid");}
	
	//Assert.assertEquals(pf.getSt().getText(), "Smart Tech");
	}
	
	public void tearDown() {
		driver.close();
	}
}
