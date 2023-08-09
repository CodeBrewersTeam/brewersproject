package com.roomEase.brewersproj.repositories;

import com.roomEase.brewersproj.models.Household;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface HouseholdRepository extends JpaRepository<Household, Long> {
    Optional<Household> findByHouseholdName(String householdName);
    Household findByInviteCode(String inviteCode);
}
