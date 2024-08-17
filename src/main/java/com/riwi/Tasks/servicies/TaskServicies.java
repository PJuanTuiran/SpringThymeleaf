package com.riwi.Tasks.servicies;

import com.riwi.Tasks.entities.TasksEntity;
import com.riwi.Tasks.respositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskServicies  {
    @Autowired
    private TaskRepository taskRepository;

    public TasksEntity create(TasksEntity tasksEntity) {
        return taskRepository.save(tasksEntity);
    }
    // Get a task by ID
    public TasksEntity getById(Long id) {
        return taskRepository.findById(id).orElse(null);
    }

    // Update a task
    public TasksEntity update(Long id, TasksEntity tasksEntity) {
        if (taskRepository.existsById(id)) {
            tasksEntity.setId(id);
            return taskRepository.save(tasksEntity);
        }
        return null;
    }

    // Partially update a task
    public TasksEntity partialUpdate(Long id, TasksEntity tasksEntity) {
        if (taskRepository.existsById(id)) {
            TasksEntity existingTask = taskRepository.findById(id).orElse(null);
            if (existingTask != null) {
                if (tasksEntity.getTitle() != null) {
                    existingTask.setTitle(tasksEntity.getTitle());
                }
                if (tasksEntity.getDescription() != null) {
                    existingTask.setDescription(tasksEntity.getDescription());
                }
                if (tasksEntity.getDate_creation() != null) {
                    existingTask.setDate_creation(tasksEntity.getDate_creation());
                }
                if (tasksEntity.getTime_creation() != null) {
                    existingTask.setTime_creation(tasksEntity.getTime_creation());
                }
                if (tasksEntity.getStatus() != null) {
                    existingTask.setStatus(tasksEntity.getStatus());
                }
                return taskRepository.save(existingTask);
            }
        }
        return null;
    }

    // Delete a task by ID
    public boolean delete(Long id) {
        if (taskRepository.existsById(id)) {
            taskRepository.deleteById(id);
            return true;
        }
        return false;
    }



}
