package com.PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageFactory {
	
	public HomePageFactory(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	private String userName = "jacksonheights2021@gmail.com";
	private String password = "Smarttech18";
	private String url = "http://automationpractice.com/index.php";
	
	@FindBy (className =  "login")
	private WebElement signButn;
	@FindBy (id = "email")
	private WebElement email;
	@FindBy (xpath = "//input[@type='password']")
	private WebElement pass;
	@FindBy(xpath = "//i[@class='icon-lock left']")
	private WebElement signBtn2;
	@FindBy (xpath = "//span[contains(text(),'Smart Tech')]")
	private WebElement st;
	
	public WebElement getSignButn() {
		return signButn;
	}
	public WebElement getEmail() {
		return email;
	}
	public WebElement getPass() {
		return pass;
	}
	public WebElement getSignBtn2() {
		return signBtn2;
	}
	public WebElement getSt() {
		return st;
	}
	public String getUserName() {
		return userName;
	}
	public String getPassword() {
		return password;
	}
	public String getUrl() {
		return url;
	}
	
	
}
