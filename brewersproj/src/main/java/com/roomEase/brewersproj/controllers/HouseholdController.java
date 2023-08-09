package com.roomEase.brewersproj.controllers;

import com.roomEase.brewersproj.models.Household;
import com.roomEase.brewersproj.repositories.ApplicationUserRepository;
import com.roomEase.brewersproj.repositories.ChoreRepository;
import com.roomEase.brewersproj.repositories.HouseholdRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/households")
public class HouseholdController {
    @Autowired
    private ApplicationUserRepository userRepository;

    @Autowired
    private ChoreRepository choreRepository;

    @Autowired
    private HouseholdRepository householdRepository;

    @PostMapping("/create")
    public ResponseEntity<Household> createHousehold(@RequestBody Household household) {
        Household savedHousehold = householdRepository.save(household);
        return new ResponseEntity<>(savedHousehold, HttpStatus.CREATED);
    }
}
