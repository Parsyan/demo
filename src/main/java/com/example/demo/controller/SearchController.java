package com.example.demo.controller;

import com.example.demo.model.Person;
import com.example.demo.repo.PeopleRepository;
import jakarta.annotation.security.PermitAll;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/search")
@AllArgsConstructor
 public class SearchController {

    private final PeopleRepository peopleRepository;




    @GetMapping
    public String search(Model model) {

        return "search";
    }

    @PostMapping
    public String search(@RequestParam String email, Model model) {
        List<Person> people = peopleRepository.findByEmailIsContaining(email);
        model.addAttribute("users", people);
        return "search";
    }
}
