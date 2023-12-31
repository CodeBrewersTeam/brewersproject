package com.roomEase.brewersproj.models;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
public class ApplicationUser implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String firstName;
    String lastName;
    String username;
    String password;
    String email;
    Boolean roles;
    Long telephone;

    @ManyToOne
    @JoinColumn(name = "household_id")
    private Household household;


    //Each user can have multiple chores to do, and each chore can be assigned to multiple users.
    @ManyToMany
    @JoinTable(name = "user_chore",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "chore_id"))
    private List<Chore> chores;


    public ApplicationUser(Long id, String firstName, String lastName, String username, String password, String email, String householdId, Boolean admin, Long telephone) {

//     public ApplicationUser(Long id, String firstName, String lastName, String username, String password, String email, Boolean roles, Long telephone) {

        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.email = email;
        this.roles = roles;
        this.telephone = telephone;
    }



    public ApplicationUser() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getAdmin() {
        return roles;
    }

    public void setAdmin(Boolean roles) {
        this.roles = roles;
    }

    public Long getTelephone() {
        return telephone;
    }

    public void setTelephone(Long telephone) {
        this.telephone = telephone;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Household getHousehold() {
        return household;
    }

    public void setHousehold(Household household) {
        this.household = household;
    }

    public Long getHouseholdId() {
        return household != null ? household.getId() : null;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }


    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return password;
    }
}
