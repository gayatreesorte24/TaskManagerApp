package com.task.taskmanagerappbe.tasks;

import com.task.taskmanagerappbe.tasks.dtos.CreateTaskDto;
import com.task.taskmanagerappbe.tasks.dtos.TaskResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
@Controller
@RequestMapping("/tasks")
public class TasksController {
    private final TasksService tasksService;

    public TasksController(TasksService tasksService){
        this.tasksService=tasksService;
    }

    public String getTasks() {
        return " "; //tasksService.getTasks();
    }

    @PostMapping("")
    public ResponseEntity<TaskResponseDto> createTask(@RequestBody CreateTaskDto createTask){
        TaskResponseDto savedTask = tasksService.createTask(createTask);
        //TODO: remove URI hardcoding and read from application properties
        return ResponseEntity.created(URI.create("/tasks/"+savedTask.getId())).body(savedTask);
    }

    @GetMapping("/{id}")
    public String getTask(@PathVariable("id") Long id){
        return ""; //tasksService.getTask(id);
    }
}
