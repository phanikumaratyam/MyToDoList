package com.phanikumaratyam.mytodoapp;

import java.util.*;

public class Todo {

    private String taskName;
    private String description;
    private Date dateAdded;
    private boolean isTaskDone;
    private Date dateFinished;

    public Todo(String taskName, String description, Date dateAdded, boolean isTaskDone) {
        this.taskName = taskName;
        this.description = description;
        this.dateAdded = dateAdded;
        this.isTaskDone = isTaskDone;
    }

    public Todo(String taskName, String description) {
        this.taskName = taskName;
        this.description = description;
        this.dateAdded = new Date();
        this.isTaskDone = false;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskName() {
        return this.taskName;
    }

    public boolean isTaskDone() {
        return this.isTaskDone;
    }

    public void setTaskStatus(boolean taskStatus) {
        this.isTaskDone = taskStatus;
    }

    public Date getAddedDate() {
        return this.dateAdded;
    }

    public Date getFinishedDate() {
        return this.dateFinished;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDateFinished(Date finishedDate) {
        this.dateFinished = finishedDate;
    }

    @Override
    public String toString() {
        return "Task added: " + this.getTaskName() + ' ' + this.getDescription();
    }
}
