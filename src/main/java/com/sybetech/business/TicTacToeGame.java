package com.sybetech.business;

public class TicTacToeGame {
    private static final char UNOCCUPIED = '\0';

    public static final String RESULT_IN_PROGRESS = "In progress";
    static final String RESULT_DRAW = "Draw";
    public static final String RESULT_WINNER = "Winner is %s";

    public static final String COORDINATE_ERR_MSG = "Coordinate must be between 1 and 3";
    public static final String FIELD_OCCUPIED_ERR_MSG = "Field is already occupied!";
    public static final String SAVE_STATE_ERR_MSG = "Could not save state to DB!";
    public static final String DROP_DB_ERR_MSG = "Could not drop DB collection!";

    private Character[][] board = {
        {UNOCCUPIED, UNOCCUPIED, UNOCCUPIED}
        , {UNOCCUPIED, UNOCCUPIED, UNOCCUPIED}
        , {UNOCCUPIED, UNOCCUPIED, UNOCCUPIED}
    };
    private char lastPlayer = UNOCCUPIED;

    private int move = 0;
    private static final int SIZE = 3;

    private int counter = 0;
    private TicTacToeGameState state;

    public TicTacToeGame() {
        this(new TicTacToeGameState());
    }

    public TicTacToeGame(TicTacToeGameState ticTacToeGameState) {
        this.state = ticTacToeGameState;
        if( !this.state.clear()) {
            throw  new RuntimeException(DROP_DB_ERR_MSG);
        }
    }

    public char getLastPlayer() {
        return lastPlayer;
    }

    /**
     *
        1     2     3
     |-----|-----|-----|-->x
    1|(1,1)|(2,1)|(3,1)|
    2|(1,2)|(2,2)|(3,2)|
    3|(1,3)|(2,3)|(3,3)|
     |-----|-----|-----|
     |
     y
     *
     * Hint: you may use the players ascii values: 'X'=88*3 = 264 => X wins, 'O'=79*3 = 237 => O wins
     **/
    private boolean isWin(int x, int y) {
        // TODO set return value
        int prod1 = 1, prod2 = 1, prod3 = 1, prod4 = 1;
        for(int i=0; i<3; i++) {
            prod1 *= (int) board[i][y-1];
            prod2 *= (int) board[x-1][i];
            if( x == y ) {
                prod3 *= (int) board[i][i];
                prod4 *= (int) board[2-i][i];
            }
        }
        return prod1 == 264 || prod1 == 237
            || prod2 == 264|| prod2 == 237
            || prod3 == 264 || prod3 == 237
            || prod4 == 264 || prod4 == 237;
    }

    // Hint: if one cell is UNOCCUPIED false, else true
    private boolean isDraw() {
        for (int x = 0; x < SIZE; x++) {
            for (int y = 0; y < SIZE; y++) {
                if (board[x][y] == UNOCCUPIED) {
                    return false;
                }
            }
        }
        return true;
    }

    public String play(int x, int y) {
        checkCoordinate(x);
        checkCoordinate(y);
        lastPlayer = getNextPlayer();
        TicTacToeGameMove move = new TicTacToeGameMove(++counter, lastPlayer, x, y);
        setField(x, y);
        if(!state.save(move)) {
            throw new RuntimeException(SAVE_STATE_ERR_MSG);
        }
        if( isWin(x, y)) {
            return String.format(RESULT_WINNER, lastPlayer);
        }
        else if(isDraw()) {
            return RESULT_DRAW;
        }
        else
            return RESULT_IN_PROGRESS;
    }

    private void setField(int x, int y) {
        if(board[x-1][y-1] != UNOCCUPIED ) {
            throw new RuntimeException(FIELD_OCCUPIED_ERR_MSG);
        }

        board[x-1][y-1] = lastPlayer;
    }

    private void checkCoordinate(int x) {
        if (x < 1 || 3 < x) {
            throw new RuntimeException(COORDINATE_ERR_MSG);
        }
    }

    public char getNextPlayer() {
        return lastPlayer == 'X' ? 'O' : 'X';
    }

    public TicTacToeGameState getState() {
        return state;
    }
}
