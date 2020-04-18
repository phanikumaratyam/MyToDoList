package com.phanikumaratyam.mytodoapp;

import java.util.*;
import com.mongodb.MongoClient;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import java.net.UnknownHostException;

public class DBManager {
    private static DB db;

    public static DB getDB(String name) throws UnknownHostException{
//        Mongo mongo = new Mongo();

        MongoClient mongo = new MongoClient("127.0.0.1", 27017);

        if (db == null) {
            db = mongo.getDB(name);
        }

        return db;
    }
}