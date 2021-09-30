package com.Cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(publish = true,
plugin = { "pretty", 
		"html:target/site/cucumber-pretty", 
		"rerun:target/rerun.txt",
	    "json:target/cucumber.json",
	},

	features = { "./Feature/Login.feature",}, 
	glue = { "com.Cucumber" }, // step def package name
	//tags= "@ScenarioTwo",
	monochrome = true,// remove all ?? & console will be easily readable 
	dryRun = false,//check feature file 
	strict = true //stepdef>>every step has code or not
	
)
public class Runner extends AbstractTestNGCucumberTests{

}
