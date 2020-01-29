package com.sybetech.presentation.bdd.cucumber;


import com.sybetech.business.TicTacToeGame;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.hamcrest.CoreMatchers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Acceptance test
 * steps matching those in scenarios in feature file
 * works only after deployment
 */
public class TicTacToeCucumberSteps {
    WebDriver driver;

    @Before
    public void setUp() {
        driver = new HtmlUnitDriver();
    }

    //@Given("^user browses to http://localhost:(\\d+)/tictactoe/$")
    @Given("^user browses to (.*)$")
    public void givenUser_browses_to_http_localhost_tictactoe(String url) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        driver.get(url);
    }

    @When("^first move X is \\((\\d+),(\\d+)\\)$")
    public void first_move_X_is(int x, int y) throws Throwable {
        assertThat(play(x,y), equalTo("X"));
    }

    @When("^second move O is \\((\\d+),(\\d+)\\)$")
    public void second_move_O_is(int x, int y) throws Throwable {
        assertThat(play(x,y), equalTo("O"));
    }

    @When("^third move X is \\((\\d+),(\\d+)\\)$")
    public void third_move_X_is(int x, int y) throws Throwable {
        assertThat(play(x,y), equalTo("X"));
    }

    @When("^fourth move O is \\((\\d+),(\\d+)\\)$")
    public void fourth_move_O_is(int x, int y) throws Throwable {
        assertThat(play(x,y), equalTo("O"));
    }

    @When("^fifth move X is \\((\\d+),(\\d+)\\)$")
    public void fifth_move_X_is(int x, int y) throws Throwable {
        assertThat(play(x,y), equalTo("X"));
    }

    @Then("^winner is X$")
    public void winner_is_X() throws Throwable {
        WebElement result = driver.findElement(By.name("f:result"));
        assertThat(result.getAttribute("value"), CoreMatchers.equalTo(String.format(TicTacToeGame.RESULT_WINNER, "X")));
    }

    private String play(int x, int y) {
        WebElement btn = driver.findElement(By.name(String.format("f:btn%s_%s", x, y)));
        btn.submit(); // click
        btn = driver.findElement(By.name(String.format("f:btn%s_%s", x, y)));
        return btn.getAttribute("value");
    }
}
