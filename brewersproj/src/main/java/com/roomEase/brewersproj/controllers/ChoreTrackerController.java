package com.roomEase.brewersproj.controllers;

import com.roomEase.brewersproj.models.ApplicationUser;
import com.roomEase.brewersproj.models.Chore;
import com.roomEase.brewersproj.models.ChoreForm;
import com.roomEase.brewersproj.repositories.ApplicationUserRepository;
import com.roomEase.brewersproj.repositories.ChoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


@Controller
public class ChoreTrackerController {

    @Autowired
    private ChoreRepository choreRepository;

    @Autowired
    private ApplicationUserRepository userRepository;

//    @Autowired
//    private ChoreRepository choreRepository;


    @GetMapping("/choresTracker")
    public String getChoresTrackerPage(Model model) {
        List<ApplicationUser> users = userRepository.findAll();

        List<String> roommates = users.stream()
                .map(ApplicationUser::getUsername)
                .collect(Collectors.toList());

        List<Chore> chores = choreRepository.findAll();
        LocalDate currentDate = LocalDate.now();
        List<Chore> futureTasks = choreRepository.findAllByDueDateAfter(currentDate);

        Date currentDateAsDate = Date.from(currentDate.atStartOfDay(ZoneId.systemDefault()).toInstant());

        ChoreForm choreForm = new ChoreForm();
        choreForm.setRoommates(roommates);
        choreForm.setChores(chores);

        model.addAttribute("choreForm", choreForm);
        model.addAttribute("futureTasks", futureTasks);

        return "choresTracker.html";
    }


//    Directed back to the chore tracker page after saving form
        @PostMapping("/addChore")
        public String addChore(@ModelAttribute Chore chore) {
            choreRepository.save(chore);
            return "redirect:/choresTracker";
        }

        @PostMapping("/updateChore")
        public String updateChore(@ModelAttribute Chore chore) {
            if(chore.getId() != null) {
                choreRepository.save(chore);
            }
            return "redirect:/choresTracker";
        }

        @GetMapping("/deleteChore/{choreId}")
        public String deleteChore(@PathVariable Long choreId) {
            choreRepository.deleteById(choreId);
            return "redirect:/choresTracker";
        }




        /////above is for "Things that need to get done the following week:" and "future task" and mapping

//    @GetMapping("/choresTracker")
//    public String getAllChores(Model model) {
//        model.addAttribute("chores", choreRepository.findAll());
//        return "choresTracker";
//    }

//    @PostMapping("/addSundayChore")
//    public String saveSundayChores(@ModelAttribute ChoreForm choreForm) {
//        // Set the day
//        Chore chore = new Chore();
//        chore.setName(choreForm.getName());
//        chore.setDescription(choreForm.getDescription());
//        chore.setDueDate(choreForm.getDueDate());
//        chore.setDayOfWeek("Sunday");
//
//        // Find and set the assigned users
//        Set<ApplicationUser> users = userRepository.findAllByIdIn(choreForm.getUsersAssignments().keySet());
//        chore.setAssignedUsers(users);
//
//        choreRepository.save(chore);
//
//        return "redirect:/choresTracker";
//    }


//    @PostMapping("/addMondayChore")
//    public String saveMondayChores(ChoreForm choreForm) {
//        choreForm.setDay("Monday");
//        return "redirect:/choresTracker";
//    }


    }





