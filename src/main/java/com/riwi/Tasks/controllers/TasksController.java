package com.riwi.Tasks.controllers;

import com.riwi.Tasks.entities.TasksEntity;
import com.riwi.Tasks.servicies.TaskServicies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/task")
public class TasksController {
    @Autowired
    private TaskServicies taskServicies;


    @PostMapping
    public ResponseEntity<TasksEntity> create(@RequestBody TasksEntity tasksEntity) {
        TasksEntity createdTask = taskServicies.create(tasksEntity);
        return new ResponseEntity<>(createdTask, HttpStatus.CREATED);
    }

    // Read a task by ID
    @GetMapping("/{id}")
    public ResponseEntity<TasksEntity> getData(@PathVariable Long id) {
        TasksEntity task = taskServicies.getById(id);
        if (task != null) {
            return new ResponseEntity<>(task, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Update an existing task
    @PutMapping("/{id}")
    public ResponseEntity<TasksEntity> update(@PathVariable Long id, @RequestBody TasksEntity tasksEntity) {
        TasksEntity updatedTask = taskServicies.update(id, tasksEntity);
        if (updatedTask != null) {
            return new ResponseEntity<>(updatedTask, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Partially update an existing task
    @PatchMapping("/{id}")
    public ResponseEntity<TasksEntity> partialUpdate(@PathVariable Long id, @RequestBody TasksEntity tasksEntity) {
        TasksEntity partiallyUpdatedTask = taskServicies.partialUpdate(id, tasksEntity);
        if (partiallyUpdatedTask != null) {
            return new ResponseEntity<>(partiallyUpdatedTask, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Delete a task by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        boolean isDeleted = taskServicies.delete(id);
        if (isDeleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
