package com.codeup.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/resume")
    public String showresume(){

        return "resume";
    }

    @GetMapping("/portfolio")
    public String showPortfolio(){
        return "portfolio";
    }

    @GetMapping ("/hello")
    public String hello(){
        return "hello";
    }

}
