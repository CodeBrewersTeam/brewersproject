package com.roomEase.brewersproj.controllers;
import com.roomEase.brewersproj.models.ApplicationUser;
import com.roomEase.brewersproj.repositories.ApplicationUserRepository;


import org.springframework.ui.Model;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;
import java.security.Principal;

@Controller
public class ApplicationUserController {


    @Autowired
    ApplicationUserRepository applicationUserRepository;


    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    HttpServletRequest request;



    // Mapping for login page
    @GetMapping("/login")
    public String getLoginPage() {
        return "login.html";
    }

    // Mapping for signup page
    @GetMapping("/signup")
    public String getSignUpPage(){
        return "signup.html";
    }

    // Mapping for signup form submission
    @PostMapping("/signup")
    public RedirectView postSignup(String firstName, String lastName, String username, String password, String email, String householdId, String role, Integer telephone) {
        ApplicationUser user = new ApplicationUser();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(password));
        user.setEmail(email);
        user.setHouseholdId(householdId);
        user.setRole(role);
        user.setTelephone(telephone);

        applicationUserRepository.save(user);

        // Authenticate the user
        authWithHttpServletRequest(username, password);

        // Redirect to login page
        //  return new RedirectView("/");
        return new RedirectView("/login");
    }


    // Method to authenticate user by username and password
    // NOTE: we need to figure out how to authenticate by householdId ? current service only does password and username
    public void authWithHttpServletRequest(String username, String password) {
        try {
            System.out.println("Authenticating user: " + username);

            request.login(username, password);
        } catch (ServletException e) {
            System.out.println("Error during authentication");
            e.printStackTrace();
        }
    }


    @GetMapping("/")
    public String getIndexPage(Model model, Principal principal) {

        if(principal != null){
            String username = principal.getName();
            ApplicationUser user = applicationUserRepository.findByUsername(username);
            model.addAttribute("username", username);
        }
        return "index.html";
    }






    // EVERYTHING above is working. You should be able to login and go to myprofiles page and create account

    // Mapping for user's profile page
    @GetMapping("/myprofile")
    public String getUserProfile(Model model, Principal principal) {
        if(principal != null){
            String username = principal.getName();
            ApplicationUser currentUser = applicationUserRepository.findByUsername(username);
            model.addAttribute("currentUser", currentUser);
            model.addAttribute("username", username);
        }
        return "myprofile";
    }




}
