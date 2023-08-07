package com.roomEase.brewersproj.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;

@Controller
public class ConflictResolution {
    @GetMapping("/resolveConflict")
    public String getConflictResolutionPage(Principal principal, Model model) {
        if (principal != null) {
            String username = principal.getName();
            model.addAttribute("username", username);
        }
        return "resolveConflict";
    }

    private String callOpenAIApi(String conflictDescription) {
        return "Sample resolution for: " + conflictDescription;
    }

    @PostMapping("/resolveConflict")
    public String postConflictResolution(String conflictDescription, Model model, Principal principal) {
        String resolution = callOpenAIApi(conflictDescription);

        model.addAttribute("resolution", resolution);
        if (principal != null) {
            String username = principal.getName();
            model.addAttribute("username", username);
        }
        return "resolveConflict";
    }
}


