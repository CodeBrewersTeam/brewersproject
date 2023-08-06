package com.roomEase.brewersproj.repositories;

import com.roomEase.brewersproj.models.ApplicationUser;
import org.springframework.data.jpa.repository.JpaRepository;

interface ApplicationUserRepo extends JpaRepository<ApplicationUser, Long> {
    ApplicationUser findByUsername(String username);
}