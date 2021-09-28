package com.Cucumber;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
		strict = true,		// Finds pending steps and fail if find
	//	plugin = 
		features = {"Feature"},
		tags = {"@positiveTC"},  // We can run or tag scenarios to execute
		monochrome = true,
		glue = {"com.Cucumber"},  // pass stepdefinition
		dryRun = false			// it checks if any pending scripts but will not fail execution
		)

public class Runner extends AbstractTestNGCucumberTests{

}
