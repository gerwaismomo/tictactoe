package com.sybetech.business;
import com.mongodb.DB;
import com.mongodb.MongoClient;
import org.jongo.Jongo;
import org.jongo.MongoCollection;

public class TicTacToeGameState {

    static final String DB_NAME = "tic-tac-toe-db";
    static final String COLLECTION_NAME = "tic-tac-toe-collection";
    private MongoCollection mongoCollection;

    public TicTacToeGameState() {
        // use new Jongo (MongoClient().getDB).getCollection to initialize mongoCollection
    }

    public boolean save(TicTacToeGameMove move) {
        return false;
    }

    public boolean clear() {
        return false;
    }

    public TicTacToeGameMove findById(int id) {
        return null;
    }

    public MongoCollection getMongoCollection() {
        return mongoCollection;
    }
}
