package com.sybetech.business.frameworks;

import com.sybetech.business.TicTacToeGameMove;

import org.testng.annotations.*;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

//import java.util.List;
//import java.util.Arrays;

import java.util.Arrays;
import java.util.List;

/**
* TestNG demo
 * To run with eclipse install plugin TestNG for eclipse (with M2E integration)
* use assertEquals, assertTrue (with and without message)
*/
@Test
public class TicTacToeGameMoveTestngTest {
    private TicTacToeGameMove move;
    private TicTacToeGameMove move2;
    private final int id = 3;
    private final int x = 1;
    private final int y = 1;
    private final char player = 'X';
////
//    // No Rules, can be emulated using beforeclass and afterclass. e.g. createTmpFolder before and deleteTmpFolder after
//
    @BeforeClass
    public void beforeClass() {
        // called once on class initialization time
    }

    @AfterClass
    public void afterClass() {
        // called once after all methods are executed
    }

    @BeforeMethod
    public void before() {
        // called before each method execution
        move = new TicTacToeGameMove(id, player, x, y);
        move2 = new TicTacToeGameMove(id, player, x, y);
    }

    @AfterMethod
    public void after() {
        // called after each method execution
    }

    // check id is set after instantiation
    public void whenInstantiated_ThenIdIsSet() {
        assertEquals(move.getId(), 3);
    }

    // check x is set after instantiation
    public void whenInstantiated_ThenXIsSet() {
        assertEquals(move.getX(), x);
    }

    // check y is set after instantiation
    public void whenInstantiated_ThenYIsSet() {
        assertEquals(move.getY(), y);
    }

    // check player is set after instantiation
    //@Test(enabled = false)
    public void whenInstantiated_ThenPlayerIsSet() {
        assertEquals(move.getPlayer(), player);
    }

    // check allowedChars are O and X after instantiation
    public void whenInstantiated_ThenAllowedCharsAreOandX() {
        List<Character> expectedChars = Arrays.asList('X', 'O');
        assertTrue(move.getAllowedChars().containsAll(expectedChars));
        assertEquals(2, move.getAllowedChars().size());
    }

    public void whenEqualsMethodInvokedOnNull_ThenReturnFalse() {
        assertNotEquals(move, null);
        assertFalse(move.equals(null));
        assertEquals(move, move2);
    }
}
