package com.codeup.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class MathController {
    @GetMapping ("/add/{number1}/and/{number2}")
    @ResponseBody
    public int add(@PathVariable int number1, @PathVariable int number2){
        return number1 + number2;
    }

    @GetMapping(path = "/subtract/{number}/from/{number2}")
    @ResponseBody
    public int subtract(@PathVariable int number1, @PathVariable int number2){

        return number1 - number2;
    }

    @GetMapping(path = "/multiply/{number1}/ansd/{number2}")
    @ResponseBody
    public int multiply(@PathVariable int number1, @PathVariable int number2){

        return number1 * + number2;
    }

    @GetMapping(path = "/divide/{number1}/by/{number2}")
    @ResponseBody
    public double divide (@PathVariable int number1, @PathVariable int number2){
        return (double) number1 / number2;
    }
}
