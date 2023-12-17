package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({"/","/home", "/home/"})
public class MainController {

    @GetMapping
    public String home(Model model){
        model.addAttribute("err", "error");
        return "home";
    }
    @GetMapping("info")
    public String info(Model model){
        model.addAttribute("err", "error");
        return "Info";
    }
}
