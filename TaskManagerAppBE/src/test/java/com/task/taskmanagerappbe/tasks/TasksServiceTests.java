package com.task.taskmanagerappbe.tasks;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Date;
@DataJpaTest
public class TasksServiceTests {
    @Autowired TasksRepository tasksRepository;
    @Test
    public void testCreateTask(){
        TasksService tasksService=new TasksService(tasksRepository);
        TasksEntity task= tasksService.createTask("Test Task","Test Description",new Date());
        System.out.println(task);
    }
}
