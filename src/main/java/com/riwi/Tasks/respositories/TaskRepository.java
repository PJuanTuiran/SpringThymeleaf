package com.riwi.Tasks.respositories;

import com.riwi.Tasks.entities.TasksEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<TasksEntity, Long> {

}
