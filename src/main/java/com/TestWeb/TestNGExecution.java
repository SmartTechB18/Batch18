package com.TestWeb;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.genericLibrary.BaseLogin;

public class TestNGExecution {
	
	BaseLogin obj = new BaseLogin();
	
	@BeforeTest
	public void getURL() throws Exception {
		obj.openURL();
	}
	
	@Test
	public void getSignPage() throws InterruptedException {
		obj.signInPage();
	}
	
	@Test(dependsOnMethods = {"TestNGExecution.getSignPage"})
	public void getLogin() throws Exception {
		obj.login();
	}
	
	@AfterTest
	public void getTear() {
		obj.tearDown();
	}

}
