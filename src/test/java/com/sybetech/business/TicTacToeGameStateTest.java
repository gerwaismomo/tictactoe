package com.sybetech.business;

import org.jongo.MongoCollection;
import org.junit.Before;
import org.junit.Test;

import java.net.UnknownHostException;


/**
 * Demo for mocking framework Mockito
 * - spy (partial mocking): real object using real methods, unless specified otherwise
 */
//@RunWith(MockitoJUnitRunner.class) // creates required mocks and inject them in the test class
//@Ignore
public class TicTacToeGameStateTest {
    /*****************************************************************************************
     * R5: use MongoDB as persistent storage for the game state.
     ****************************************************************************************/

    /**
     * R5.1: implement bean for storage representation TicTacToeGameState
     */

    private TicTacToeGameState state;
    private MongoCollection mongoCollection;
    private TicTacToeGameMove move;

    @Before
    public void setUp() throws UnknownHostException {
        // init move

        // use method spy() to partial mock class to test

        // use method mock(Class) to mock db dependency mongoCollection (all methods are shallow).

    }

    /**
     * R5.2: specify DB-Name
     */
    @Test
    public void whenInstantiated_ThenMongoHasDbName() throws Exception {

    }

    /**
     * R5.2: specify the mongo collection-name
     */
    @Test
    public void whenInstantiated_ThenMongoCollectionHasName() throws Exception {

    }

    /**
     * R5.3: save data to mongo-db and return true
     * use doReturn(mockObj).when(classToMock).methodToMock(), verify()
     */
    @Test
    public void whenSave_ThenInvokeMongoCollectionSaveAndReturnTrue() throws Exception {

    }

    /**
     * R5.4: return false if MongoException occurs while saving
     * use doReturn, doThrow
     */
    @Test
    public void givenMongoException_WhenSave_ThenReturnFalse() {

    }

    /**
     * R5.5: specify droping data
     */
    @Test
    public void whenClear_ThenInvokeMongoCollectionDrop() {

    }

    /**
     * R5.6: return false if MongoException occurs while dropping
     * use doReturn, doThrow
     * check when exception occurs during clear, then clear returns false
     */
    @Test
    public void givenMongoException_WhenClear_ThenReturnFalse() {

    }
}