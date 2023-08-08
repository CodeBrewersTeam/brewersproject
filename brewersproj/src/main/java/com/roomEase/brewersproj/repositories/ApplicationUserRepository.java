package com.roomEase.brewersproj.repositories;

import com.roomEase.brewersproj.models.ApplicationUser;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ApplicationUserRepository extends JpaRepository<ApplicationUser, Long> {

    ApplicationUser findByUsername(String username);

//alex: need for filtering out users by ID
    List<ApplicationUser> findByHouseholdId(String householdId);

}