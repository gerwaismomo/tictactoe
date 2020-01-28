package com.sybetech.presentation;

import com.sybetech.business.TicTacToeGame;
import com.sybetech.business.TicTacToeGameMove;
import com.sybetech.business.TicTacToeGameState;
import org.junit.Before;
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
public class TicTacToeGameE2ETest {

	private WebDriver driver;

	@Before
	public void setUp() {
		driver = new HtmlUnitDriver();
	}

	@Test
	public void whenPlayAndWholeHorizontalLineFilled_ThenWinner() throws Exception {
		driver.get(Constants.APP_URL);
		assertThat(driver.getTitle(), equalTo(Constants.APP_TITLE));


		TicTacToeGameState db = new TicTacToeGameState();

		assertThat(play(1,1), equalTo("X"));
		TicTacToeGameMove persistedMove1 = db.findById(1);
		TicTacToeGameMove expectedMove1 = new TicTacToeGameMove(1, 'X', 1, 1);
		assertThat(persistedMove1, equalTo(expectedMove1));

		assertThat(play(1,2), equalTo("O"));
		TicTacToeGameMove persistedMove2 = db.findById(2);
		TicTacToeGameMove expectedMove2 = new TicTacToeGameMove(2, 'O', 1, 2);
		assertThat(persistedMove2, equalTo(expectedMove2));

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
