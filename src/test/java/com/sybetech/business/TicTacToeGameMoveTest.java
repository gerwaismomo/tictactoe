package com.sybetech.business;

import org.junit.*;
import org.junit.rules.TestName;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

/**
 * JUnit Demo
 * use assertEquals, assertTrue (with and without message
 */
public class TicTacToeGameMoveTest {

    private TicTacToeGameMove move;
    private final int id = 3;
    private final int x = 1;
    private final int y = 1;
    private final char player = 'X';

    // https://github.com/junit-team/junit4/wiki/rules (JUnit interceptors)
//    @Rule
    public final TestName name = new TestName();

//    @BeforeClass
    public static void beforeClass() {
        // called once on class initialization time
    }

//    @AfterClass
    public static void afterClass() {
        // called once after all methods are executed
    }

//    @Before
    public void before() {
        // called before each method execution
        // init a move
    }

//    @After
    public void after() {
        // called after each method execution
    }

    // check id is set after instantiation
    //@Test
    public void whenInstantiated_ThenIdIsSet() {

    }

    // check x is set after instantiation
    //@Test
    public void whenInstantiated_ThenXIsSet() {

    }

    // check y is set after instantiation
    //@Test
    public void whenInstantiated_ThenYIsSet() {

    }

    // check player is set after instantiation
    //@Test
    public void whenInstantiated_ThenPlayerIsSet() {

    }

    // check allowedChars are O and X after instantiation
    //@Test
    public void whenInstantiated_ThenAllowedCharsAreOandX() {

    }

    // check Rule TestName.getMethodName
    //@Test
    public void whenGetMethodNameOfTestNameRuleInvoked_ThenReturnNameOfThisTest() {

    }

}