package com.task.taskmanagerappbe.notes;

import com.task.taskmanagerappbe.tasks.TasksEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity(name="notes")
public class NotesEntity {
        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE)
        private Long id;
        private String title;
        private String description;

        @ManyToOne(targetEntity = TasksEntity.class)
        private TasksEntity task;
}
