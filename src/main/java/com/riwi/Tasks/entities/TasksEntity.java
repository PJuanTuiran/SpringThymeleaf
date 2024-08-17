package com.riwi.Tasks.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity(name = "Task")
public class TasksEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = true)
    private String title;

    @Column(length = 256, nullable = true)
    private String description;

    @Column(nullable = true)
    private LocalDate date_creation;

    @Column(nullable = true)
    private LocalTime time_creation;

    @Column(length = 50)
    private String status;

    public TasksEntity(Long id, String title, String description, LocalTime time_creation, LocalDate date_creation, String status) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.time_creation = time_creation;
        this.date_creation = date_creation;
        this.status = status;
    }

    public TasksEntity() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDate_creation() {
        return date_creation;
    }

    public void setDate_creation(LocalDate date_creation) {
        this.date_creation = date_creation;
    }

    public LocalTime getTime_creation() {
        return time_creation;
    }

    public void setTime_creation(LocalTime time_creation) {
        this.time_creation = time_creation;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
