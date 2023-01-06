package com.task.taskmanagerappbe.tasks;

import com.task.taskmanagerappbe.tasks.dtos.CreateTaskDto;
import com.task.taskmanagerappbe.tasks.dtos.TaskResponseDto;
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
        TasksEntity task=modelMapper.map(newTask, TasksEntity.class);
        task.setCompleted(false);
        TasksEntity savedTask=tasksRepository.save(task);
        return modelMapper.map(savedTask,TaskResponseDto.class);
    }
}
