package com.sybetech.presentation.bdd.cucumber;

import com.sybetech.business.TicTacToeGame;
import cucumber.api.CucumberOptions;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;
import org.hamcrest.CoreMatchers;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;


/**
 * CucumberRunner: parse features, run CucumberSteps and generate reports
 */
@RunWith(Cucumber.class)
@CucumberOptions(
	features = {"stories"}, // Features path
	glue = {"com.sybetech.presentation.bdd.cucumber"}, // Steps package
	plugin = {"pretty", "html:target/cucumber"} // Reports output path
)
public class CucumberRunner {

}
