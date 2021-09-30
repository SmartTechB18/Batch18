package com.Cucumber;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import com.PageObjectModel.HomePageFactory;
import com.cofigLibrary.Credentials;
import com.utility.Highlight;
import com.utility.TestScreenShot;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;



public class StepDef {
	HomePageFactory pf;
	WebDriver driver;
	
	@Given("user is in the appliation homepage")
	public void user_is_in_the_appliation_homepage() throws Exception {
		System.setProperty("webdriver.chrome.driver", 
				"./All_Driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		pf = new HomePageFactory(driver);
		driver.get(Credentials.getConfig("url"));
		//return driver;
	}

	@Given("click on sign in button and land in signin page")
	public void click_on_sign_in_button_and_land_in_signin_page() throws InterruptedException {
		Highlight.getcolor(driver, pf.getSignButn());
		
		pf.getSignButn().click();
		if(driver.getTitle().contains("Login - My Store")) {
			System.out.println("Landed to the signin page successfully...");
			TestScreenShot.captureScreenShot(driver, "HomePgae");
		}
		else {
			System.out.println("Sign in page verifucation failed.");
		}
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
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Assert.assertEquals(pf.getSt().getText(), "Smart Tech");
	}

	@When("enter the invalid {string}")
	public void enter_the_invalid(String string) {
	    
	}

	@When("enter the invalid {string} and click sign in button")
	public void enter_the_invalid_and_click_sign_in_button(String string) {
	   
	}

}
