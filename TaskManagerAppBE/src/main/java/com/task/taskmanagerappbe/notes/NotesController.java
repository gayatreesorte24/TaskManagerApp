package com.task.taskmanagerappbe.notes;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tasks/{taskId}/notes")
public class NotesController {
    @GetMapping("")
    public String getAllNotesByTaskId(@PathVariable("taskId") Long taskId){
        return  "Here are all notes for task" + taskId;
    }
}
