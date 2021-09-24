package com.Cucumber;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.PageObjectModel.HomePageFactory;
import com.cofigLibrary.Credentials;
import com.genericLibrary.BaseLogin;
import com.utility.Highlight;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDef {
	BaseLogin bl;
	HomePageFactory pf;
	WebDriver driver;
	
	@Given("user is in the appliation homepage")
	public void user_is_in_the_appliation_homepage() throws Exception {
		bl = new BaseLogin();
		bl.openURL();
	}

	@Given("click on sign in button and land in signin page")
	public void click_on_sign_in_button_and_land_in_signin_page() throws InterruptedException {
	    bl.signInPage();
	    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@When("enter the valid userName")
	public void enter_the_valid_userName() throws Exception {
		Highlight.getcolor(driver, pf.getEmail(), "blue");	
		pf.getEmail().sendKeys(Credentials.getConfig("userName"));
	}

	@When("enter the valid password and click sign in button")
	public void enter_the_valid_password_and_click_sign_in_button() throws Exception {
		Highlight.getcolor(driver, pf.getEmail());	
		pf.getPass().sendKeys(Credentials.getConfig("password"));
		pf.getSignBtn2().click();
	}

	@Then("user is logged in to account homePage")
	public void user_is_logged_in_to_account_homePage() {
		Assert.assertEquals(pf.getSt().getText(), "Smart Tech");
	}

	@When("enter the invalid name{int}")
	public void enter_the_invalid_name(Integer int1) {
	    
	}

	@When("enter the invalid {int} and click sign in button")
	public void enter_the_invalid_and_click_sign_in_button(Integer int1) {
	    
	}
}
