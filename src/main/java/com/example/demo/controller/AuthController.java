package com.example.demo.controller;

import com.example.demo.model.Person;
import com.example.demo.service.PersonService;
import com.example.demo.service.RegistrationService;
import com.example.demo.util.PersonValidator;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/auth")
public class AuthController {

    private final RegistrationService registrationService;

    private final PersonValidator personValidator;

    private final PersonService personService;

    public AuthController(RegistrationService registrationService, PersonValidator personValidator,PersonService personService) {
        this.registrationService = registrationService;
        this.personValidator = personValidator;
        this.personService = personService;
    }

    @GetMapping("/login")
    public String loginPage(){
        return "auth/login";
    }

//    @PostMapping("/login")
//    public String loginError(Model model) {
//
//        return "login";
//    }

    @GetMapping("/registration")
    public String registrationPage(@ModelAttribute("person") Person person,@ModelAttribute("confirmPassword") String pass){
        return "auth/Register";
    }
    @PostMapping("/registration")
    public String performRegistration(@ModelAttribute("person") @Valid Person person,
                                      BindingResult bindingResult){
        System.out.println(person);
        if (person.getRole() == null) {
            person.setRole("ROLE_USER");
        }
        personValidator.validate(person,bindingResult);

        if(bindingResult.hasErrors()) {
            System.out.println(bindingResult);
            return "auth/Register";
        }

        registrationService.register(person);
        System.out.println(personService.getUser(person.getEmail()) + " user : " + person.getEmail());
        return "redirect:/users";
    }

    @GetMapping("/logout")
    public String logout(){
        return "redirect:/auth/login";
    }


}
