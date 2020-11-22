package com.sybetech.presentation.bdd.jbehave;

import com.sybetech.business.TicTacToeGame;
import cucumber.api.java.Before;
import org.hamcrest.CoreMatchers;
import org.jbehave.core.annotations.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Acceptance test
 * steps matching those in scenarios in story file
 * works only after deployment
 */
public class JbehaveSteps {
    WebDriver driver;

    @BeforeStory
    public void setUp() {
        driver = new HtmlUnitDriver();
    }

    @Given("user browses to $url")
    public void givenUserBrowsesToHttplocalhost8080tictactoe(String url) {
        driver.get(url);
        WebElement btn = driver.findElement(By.name("f:resett"));
        btn.submit(); // click

    }

    @When("first move X is ($x,$y)")
    public void whenFirstMoveXIs11(int x, int y) {
        assertThat(play(x,y), equalTo("X"));
    }

    @When("second move O is ($x,$y)")
    public void whenSecondMoveOIs12(int x, int y) {
        assertThat(play(x,y), equalTo("O"));
    }

    @When("third move X is ($x,$y)")
    public void whenThirdMoveXIs21(int x, int y) {
        assertThat(play(x,y), equalTo("X"));
    }

    @When("fourth move O is ($x,$y)")
    public void whenFourthMoveOIs23(int x, int y) {
        assertThat(play(x,y), equalTo("O"));
    }

    @When("fifth move X is ($x,$y)")
    public void whenFifthMoveXIs31(int x, int y) {
        assertThat(play(x,y), equalTo("X"));
    }

    @Then("winner is X")
    public void thenWinnerIsX() {
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
