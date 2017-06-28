package com.codeup.controllers;

import com.codeup.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthenticationController {
    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }


    @GetMapping("/register")
    public String showRegistration(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }
}