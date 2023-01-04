package com.task.taskmanagerappbe.tasks;

import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TasksService {
    private final TasksRepository tasksRepository;

    public TasksService(TasksRepository tasksRepository) {
        this.tasksRepository = tasksRepository;
    }

    public TasksEntity createTask(String title, String description, Date dueDate){
        TasksEntity task=new TasksEntity();
        task.setTitle(title);
        task.setDescription(description);
        task.setCompleted(false);
        task.setDueDate(dueDate);
        return tasksRepository.save(task);
    }
}
