package com.sybetech.presentation;

import com.sybetech.business.TicTacToeGame;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAccessor;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * System Test.
 * Works only after deployment
 */
//@Ignore
public class TicTacToeGamePT {

	private WebDriver driver;

	@Before
	public void setUp() {
		driver = new HtmlUnitDriver();
	}

	@Test
	public void stressTest() throws Exception {
		LocalDateTime ldtb = LocalDateTime.now();
		System.out.println("Testing 1000 round. Begin at: "+ ldtb);
		driver.get(Constants.APP_URL);

		assertThat(driver.getTitle(), equalTo(Constants.APP_TITLE));
		for(int i=0; i < 100; i++) {
			playAndCheckARound();
		}

		LocalDateTime ldte = LocalDateTime.now();
		System.out.println("Testing 1000 round. Begin at: "+ ldte +". Total duration: "+ Duration.between(ldtb, ldte));
	}

	public void playAndCheckARound() throws Exception {

		assertThat(play(1,1), equalTo("X"));
		assertThat(play(1,2), equalTo("O"));
		assertThat(play(2,1), equalTo("X"));
		assertThat(play(2,3), equalTo("O"));
		assertThat(play(3,1), equalTo("X"));

		WebElement result = driver.findElement(By.name("f:result"));
		assertThat(result.getAttribute("value"), equalTo(String.format(TicTacToeGame.RESULT_WINNER, "X")));

		WebElement resetBtn = driver.findElements(By.name("f:resett")).get(0);
		resetBtn.submit(); // click
	}

	private String play(int x, int y) {
		WebElement btn = driver.findElement(By.name(String.format("f:btn%s_%s", x, y)));
		btn.submit(); // click
		btn = driver.findElement(By.name(String.format("f:btn%s_%s", x, y)));
		return btn.getAttribute("value");
	}

	// TODO test vertical and 2 diagonals and draw
}
