package com.roomEase.brewersproj.models;

import java.util.List;
import java.util.Map;

public class ChoreForm {
    private String day;
    private List<String> roommates;
    private List<Chore> chores;
    private Map<Long, String> taskDescriptions;
    private Map<String, Map<Long, Boolean>> taskAssignments;
    private Map<Long, String> usersAssignments;

    public ChoreForm() {
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public List<String> getRoommates() {
        return roommates;
    }

    public void setRoommates(List<String> roommates) {
        this.roommates = roommates;
    }

    public List<Chore> getChores() {
        return chores;
    }

    public void setChores(List<Chore> chores) {
        this.chores = chores;
    }

    public Map<Long, String> getTaskDescriptions() {
        return taskDescriptions;
    }

    public void setTaskDescriptions(Map<Long, String> taskDescriptions) {
        this.taskDescriptions = taskDescriptions;
    }

    public Map<String, Map<Long, Boolean>> getTaskAssignments() {
        return taskAssignments;
    }

    public void setTaskAssignments(Map<String, Map<Long, Boolean>> taskAssignments) {
        this.taskAssignments = taskAssignments;
    }

    public Map<Long, String> getUsersAssignments() {
        return usersAssignments;
    }

    public void setUsersAssignments(Map<Long, String> usersAssignments) {
        this.usersAssignments = usersAssignments;
    }
}

