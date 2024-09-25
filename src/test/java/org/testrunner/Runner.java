package org.testrunner;

import org.baseclass.JvmReport;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

@RunWith(Cucumber.class)
@CucumberOptions(features="C:\\Users\\USER\\Desktop\\WS\\Cucumber\\src\\test\\resources\\FeatureFile\\Login.feature",
glue="org.stepdefinition",dryRun=false,strict=true,snippets=SnippetType.UNDERSCORE,tags="@regression",
plugin={"html:C:\\Users\\USER\\Desktop\\WS\\Cucumber\\AllReport\\HTMLReport",
"junit:C:\\Users\\USER\\Desktop\\WS\\Cucumber\\AllReport\\JunitReport\\fb.xml",
"json:C:\\Users\\USER\\Desktop\\WS\\Cucumber\\AllReport\\JsonReport\\facebook.json",
"rerun:C:\\Users\\USER\\Desktop\\WS\\Cucumber\\Failed\\Fail.txt"})
public class Runner {
	
	@AfterClass
	public static void after() {
		JvmReport.generateJvmReport("C:\\Users\\USER\\Desktop\\WS\\Cucumber\\AllReport\\JsonReport");

	}

}
