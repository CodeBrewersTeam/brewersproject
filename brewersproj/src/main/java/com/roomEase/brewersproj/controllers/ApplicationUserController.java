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



    //http://localhost:8080/login :this is the login/signup page
    @GetMapping("/login")
    public String getLoginPage() {
        return "login.html";
    }

    //http://localhost:8080/signup: create an account on this page. Once you signup you're redirected to http://localhost:8080/login
    @GetMapping("/signup")
    public String getSignUpPage(){
        return "signup.html";
    }

    // this handles the signup form, once submitted user is redirected to http://localhost:8080/ (index.html). Not login
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
        authWithHttpServletRequest(username, password);

        //after completing form, user is redirected to login page.
        //  return new RedirectView("/");
        return new RedirectView("/login");
    }


    // This is to authenticate user by username and password
    // NOTE: we need to figure out how to authenticate by householdId ? current service only does password and username
    public void authWithHttpServletRequest(String username, String password){
        try {
            request.login(username, password);
        } catch(ServletException e){
            System.out.println("Error");
            e.printStackTrace();
        }
    }




    // my profile stuff
    @GetMapping("/myprofile")
    public String getProfileInfo(Model m, Principal p) {
        if(p != null){
            String username = p.getName();
            ApplicationUser currentUser = applicationUserRepository.findByUsername(username);
            m.addAttribute("currentUser", currentUser);
            m.addAttribute("username", username);
        }
        return "myprofile.html";
    }


}
