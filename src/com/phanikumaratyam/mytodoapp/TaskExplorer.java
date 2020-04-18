package com.phanikumaratyam.mytodoapp;

import java.util.*;
import com.mongodb.*;
import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.*;

import javax.management.monitor.CounterMonitor;
import java.net.UnknownHostException;

public class TaskExplorer {
    private static final String DB_NAME = "test";
    private static final String COLLECTION_NAME = "myToDoApp";

    public static void saveTask(Todo toDo) throws UnknownHostException{
        DBObject dbObject = BasicDBObjectBuilder.start().add("taskName", toDo.getTaskName())
                .add("taskDescription", toDo.getDescription())
                .add("dateAdded", toDo.getAddedDate())
                .add("isTaskDone", toDo.isTaskDone()).get();

        DB db = DBManager.getDB(DB_NAME);

        DBCollection dbCollection = db.getCollection(COLLECTION_NAME);

        dbCollection.save(dbObject);
    }

    public static List getTasksList() throws UnknownHostException {
        DB db = DBManager.getDB(DB_NAME);

        DBCollection dbCollection = db.getCollection(COLLECTION_NAME);

        DBCursor dbCursor = dbCollection.find();

        List tasks = new ArrayList();

        while (dbCursor.hasNext()) {
            DBObject dbObject = dbCursor.next();

            String taskName = String.valueOf(dbObject.get("taskName"));
            String taskDescription = String.valueOf(dbObject.get("taskDescription"));
            Date dateAdded = (Date)dbObject.get("dateAdded");
            boolean isTaskDone = (Boolean)dbObject.get("isTaskDone");

            Todo task = new Todo(taskName, taskDescription, dateAdded, isTaskDone);

            tasks.add(task);
        }

        return tasks;
    }
}
