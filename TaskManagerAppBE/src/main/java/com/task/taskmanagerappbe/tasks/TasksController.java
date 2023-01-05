package com.task.taskmanagerappbe.tasks;

public class TasksController {
    private final TasksService tasksService;

    public TasksController(TasksService tasksService){
        this.tasksService=tasksService;
    }
}
