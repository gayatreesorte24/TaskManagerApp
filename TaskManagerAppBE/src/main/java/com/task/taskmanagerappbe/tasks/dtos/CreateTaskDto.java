package com.task.taskmanagerappbe.tasks.dtos;

import jakarta.annotation.Nullable;
import lombok.Data;
import lombok.NonNull;

import java.util.Date;

@Data
public class CreateTaskDto {
    @NonNull
    String title;
    @NonNull
    String description;
    @NonNull
    Date dueDate;
}
