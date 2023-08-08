package com.roomEase.brewersproj.models;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Chore {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private LocalDate dueDate;
    private boolean isCompleted;
    private String task;
    private String description;
    private String dayOfWeek;

    public Chore() {
    }

    public Chore(String name, LocalDate dueDate, boolean isCompleted, String task, String description) {
        this.name = name;
        this.dueDate = dueDate;
        this.isCompleted = isCompleted;
        this.task = task;
        this.description = description;
    }




    //The Chore class to include the many-to-many relationship with ApplicationUser.
    @ManyToMany(mappedBy = "chores")
    private List<ApplicationUser> users;

    @ManyToMany
    private Set<ApplicationUser> assignedUsers = new HashSet<>();


//    @OneToMany(mappedBy = "user")
//    private List<PostUser> posts;


    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(String dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }
}
