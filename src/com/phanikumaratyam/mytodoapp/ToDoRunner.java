package com.phanikumaratyam.mytodoapp;

import java.util.*;
import java.net.UnknownHostException;

public class ToDoRunner {
    public static void main(String[] args) throws UnknownHostException{
        Todo task1 = new Todo("sample task 1", "sample task description 1");
        TaskExplorer.saveTask(task1);

        Todo task2 = new Todo("sample task 2", "sample task description 2");
        TaskExplorer.saveTask(task2);

        List tasksList = TaskExplorer.getTasksList();

        for (Object task: tasksList) {
            System.out.println(task);
        }
    }
}
