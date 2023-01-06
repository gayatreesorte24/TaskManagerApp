package com.task.taskmanagerappbe.tasks.dtos;

import lombok.Data;

@Data
public class CreateTaskDto {
    String title;
    String description;
    String dueDate;
}
