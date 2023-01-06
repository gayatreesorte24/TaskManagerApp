package com.task.taskmanagerappbe.tasks;

import com.task.taskmanagerappbe.notes.NotesEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity(name="tasks")
public class TasksEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private Boolean completed;
    @Column(nullable = false)
    private Date dueDate;
    @OneToMany(targetEntity = NotesEntity.class, cascade = CascadeType.ALL, mappedBy = "task")
    private List<NotesEntity> notes;


}
