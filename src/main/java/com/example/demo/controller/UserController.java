package com.example.demo.controller;

import com.example.demo.exception.UnsupportedUserInDBException;
import com.example.demo.model.Person;
import com.example.demo.service.PersonService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/users")
public class UserController {

    private final PersonService personService;

    public UserController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping
    public String users(Model model, HttpServletRequest http) {

        model.addAttribute("users", personService.getUsers());
        model.addAttribute("username", http.getRemoteUser());
        model.addAttribute("deleteUser", new Person());

        return "users/users";
    }


    @GetMapping("/editUser/{email}")
    public String editUser(@PathVariable("email") String email, Model model) throws UnsupportedUserInDBException {
        System.out.println(email + "  Email  \n");
        Optional<Person> user = personService.getUser(email);
        if (user.isEmpty()) {
            model.addAttribute("err", " User Is Not Found ");
        }
        else {
            System.out.println(personService.getUser(email).get() + " remote user \n ");
            model.addAttribute("user", personService.getUser(email).get());
        }
        return "/users/editUser";
    }
    @PostMapping("/editUser")
    public String editUser(@ModelAttribute("user") Person person) throws UnsupportedUserInDBException {
          System.out.println(person);
        personService.editUser(person);

        return "/users/editUser";
    }

    @GetMapping("/deleteUser/{email}")
    public String deleteUserByUsername(@ModelAttribute("deleteUser") Person user, HttpServletRequest request) throws ServletException {
        personService.deleteByUsername(user.getEmail());
        if(user.getEmail().equals(request.getRemoteUser()))
            request.logout();
          
        return "redirect:/users";
    }

}
