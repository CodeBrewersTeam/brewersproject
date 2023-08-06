package com.roomEase.brewersproj.controllers;

public class ChoreTrackerController {

//import com.roomEase.brewersproj.models.ApplicationUser;
//import com.roomEase.brewersproj.models.Chore;
//import com.roomEase.brewersproj.repositories.ApplicationUserRepository;
//import com.roomEase.brewersproj.repositories.ChoreRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//
//import java.security.Principal;
//import java.time.LocalDate;
//import java.util.List;
//
//@Controller
//public class ChoreTrackerController {
//
//    private final ChoreRepository choreRepository;
//    private final ApplicationUserRepository applicationUserRepository;
//
//    @Autowired
//    public ChoreTrackerController(ChoreRepository choreRepository, ApplicationUserRepository applicationUserRepository) {
//        this.choreRepository = choreRepository;
//        this.applicationUserRepository = applicationUserRepository;
//    }
//
//    @GetMapping("/choretracker")
//    public String showChoreTracker(Model model, Principal principal) {
//        ApplicationUser currentUser = applicationUserRepository.findByUsername(principal.getName());
//
//        List<Chore> chores = choreRepository.findByAssignedTo(currentUser);
//        model.addAttribute("chores", chores);
//
//        return "choretracker"; // This corresponds to a Thymeleaf template named "choretracker.html"
//    }
//
//    @GetMapping("/mark-complete/{choreId}")
//    public String markChoreAsCompleted(@PathVariable Long choreId) {
//        Chore chore = choreRepository.findById(choreId).orElse(null);
//        if (chore != null) {
//            chore.setCompleted(true);
//            choreRepository.save(chore);
//        }
//        return "redirect:/choretracker";
//    }
//}
}
