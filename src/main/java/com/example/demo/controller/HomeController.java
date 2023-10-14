package com.example.demo.controller;

import com.example.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {

    @Autowired
    public HomeController(PersonService personService) {
        this.personService = personService;
    }

    private final PersonService personService;

    @GetMapping
    public String homePage(){
        return "home";
    }

    @GetMapping("/home")
    public String homePage(Model model){
        return "home";
    }





}
