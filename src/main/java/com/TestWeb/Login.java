package com.TestWeb;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.genericLibrary.BaseLogin;

public class Login {
	
	public static void main(String[] args) throws InterruptedException {
		BaseLogin obj = new BaseLogin();
		obj.openURL();
		obj.signInPage();
		obj.login();
		obj.tearDown();
	}

}
