package com.task.taskmanagerappbe.tasks;

import com.task.taskmanagerappbe.common.ErrorResponseDto;
import com.task.taskmanagerappbe.tasks.dtos.CreateTaskDto;
import com.task.taskmanagerappbe.tasks.dtos.TaskResponseDto;
import com.task.taskmanagerappbe.tasks.exceptions.TaskNotFoundException;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<TaskResponseDto> getTaskById(@PathVariable("id") Long id){
        TaskResponseDto task = tasksService.getTaskById(id);
        return ResponseEntity.ok(task);
    }

    @ExceptionHandler({
            IllegalArgumentException.class,
            TaskNotFoundException.class
    })
    public ResponseEntity<ErrorResponseDto> handleException(Exception e){
        if(e instanceof TaskNotFoundException){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body((new ErrorResponseDto(e.getMessage())));
        }
        return ResponseEntity.badRequest().body(new ErrorResponseDto(e.getMessage()));
    }
}
