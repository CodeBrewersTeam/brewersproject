package com.roomEase.brewersproj.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Household {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String householdName;
    private String inviteCode;
    // Other properties

    @OneToMany(mappedBy = "household")
    private List<ApplicationUser> applicationUsers;

    @OneToMany(mappedBy = "household")
    private List<Chore> chores;

    // Getters, setters, constructors


    public Household() {
    }

    public Household(String householdName, List<ApplicationUser> applicationUsers, List<Chore> chores) {
        this.householdName = householdName;
        this.applicationUsers = applicationUsers;
        this.chores = chores;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHouseholdName() {
        return householdName;
    }

    public void setHouseholdName(String householdName) {
        this.householdName = householdName;
    }

    public String getInviteCode() {
        return inviteCode;
    }

    public void setInviteCode(String inviteCode) {
        this.inviteCode = inviteCode;
    }

    public List<ApplicationUser> getApplicationUsers() {
        return applicationUsers;
    }

    public void setApplicationUsers(List<ApplicationUser> applicationUsers) {
        this.applicationUsers = applicationUsers;
    }

    public List<Chore> getChores() {
        return chores;
    }

    public void setChores(List<Chore> chores) {
        this.chores = chores;
    }


}

