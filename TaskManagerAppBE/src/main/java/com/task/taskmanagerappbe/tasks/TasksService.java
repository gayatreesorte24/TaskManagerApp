package com.task.taskmanagerappbe.tasks;

import com.task.taskmanagerappbe.tasks.dtos.CreateTaskDto;
import com.task.taskmanagerappbe.tasks.dtos.TaskResponseDto;
import com.task.taskmanagerappbe.tasks.exceptions.TaskNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TasksService {
    private final TasksRepository tasksRepository;
    private final ModelMapper modelMapper;

    public TasksService(TasksRepository tasksRepository, ModelMapper modelMapper) {
        this.tasksRepository = tasksRepository;
        this.modelMapper=modelMapper;
    }

    public TaskResponseDto createTask(CreateTaskDto newTask){
        //Data Validation
       if(newTask.getDueDate().before(new Date())){
           throw new IllegalArgumentException("Due date cannot be in past");
       }
        TasksEntity task=modelMapper.map(newTask, TasksEntity.class);
        task.setCompleted(false);
        TasksEntity savedTask=tasksRepository.save(task);
        return modelMapper.map(savedTask,TaskResponseDto.class);
    }

    public TaskResponseDto getTaskById(Long id){
        TasksEntity task=tasksRepository.findById(id).orElseThrow(()-> new TaskNotFoundException(id));
        return modelMapper.map(task, TaskResponseDto.class);
    }
}
