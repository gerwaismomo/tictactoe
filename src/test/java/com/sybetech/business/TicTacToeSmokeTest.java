package com.sybetech.business;

import org.hamcrest.CoreMatchers;
import org.junit.Test;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

public class TicTacToeSmokeTest {

    @Test
    public void test() throws IOException {
        URL url = new URL("http://localhost:8080/tictactoe");
        URLConnection connection = url.openConnection();
        assertThat(connection.getContent(),  CoreMatchers.notNullValue());
    }

    @Test
    public void whenDeployed_ThenDatabaseReachable() {
        TicTacToeGameState state = new TicTacToeGameState();
        state.findById(4711);
    }
}
