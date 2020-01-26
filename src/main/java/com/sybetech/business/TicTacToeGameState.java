package com.sybetech.business;

import com.mongodb.MongoClient;
import org.jongo.Jongo;
import org.jongo.MongoCollection;

public class TicTacToeGameState {

    static final String DB_NAME = "tic-tac-toe-db";
    static final String COLLECTION_NAME = "tic-tac-toe-collection";
    private MongoCollection mongoCollection;

    public TicTacToeGameState() {
        // use new Jongo (MongoClient().getDB).getCollection to initialize mongoCollection
        mongoCollection = new Jongo(new MongoClient().getDB(DB_NAME)).getCollection(COLLECTION_NAME);
    }

    public boolean save(TicTacToeGameMove move) {
        try {
            getMongoCollection().save(move);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public boolean clear() {
        try {
            getMongoCollection().drop();
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public TicTacToeGameMove findById(int id) {
        mongoCollection.findOne("{_id:#}", id).as(TicTacToeGameMove.class);
        return null;
    }

    public MongoCollection getMongoCollection() {
        return mongoCollection;
    }
}
