package com.sybetech.presentation;

import com.sun.xml.internal.bind.v2.runtime.reflect.opt.Const;
import com.sybetech.business.TicTacToeGame;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * System Test.
 * Works only after deployment
 */
//@Ignore
public class TicTacToeGameUiST {

	private WebDriver driver;

	@Before
	public void setUp() {
		driver = new HtmlUnitDriver();
	}

	@Test
	public void whenPlayAndWholeHorizontalLineFilled_ThenWinner() throws Exception {
		driver.get(Constants.APP_URL);
		assertThat(driver.getTitle(), equalTo(Constants.APP_TITLE));

		assertThat(play(1,1), equalTo("X"));
		assertThat(play(1,2), equalTo("O"));
		assertThat(play(2,1), equalTo("X"));
		assertThat(play(2,3), equalTo("O"));
		assertThat(play(3,1), equalTo("X"));

		WebElement result = driver.findElement(By.name("f:result"));
		assertThat(result.getAttribute("value"), equalTo(String.format(TicTacToeGame.RESULT_WINNER, "X")));
	}

	private String play(int x, int y) {
		WebElement btn = driver.findElement(By.name(String.format("f:btn%s_%s", x, y)));
		btn.submit(); // click
		btn = driver.findElement(By.name(String.format("f:btn%s_%s", x, y)));
		return btn.getAttribute("value");
	}

	// TODO test vertical and 2 diagonals and draw
}
