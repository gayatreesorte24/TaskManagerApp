package com.task.taskmanagerappbe.tasks.exceptions;

public class TaskNotFoundException extends IllegalArgumentException{
    public TaskNotFoundException(Long id){
        super("Task with id = " + id + "not found");
    }

}
