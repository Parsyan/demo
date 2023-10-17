package com.example.demo.controller;

import com.example.demo.model.Person;
import com.example.demo.service.RegistrationService;
import com.example.demo.util.PersonValidator;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/auth")
public class AuthController {

    private final RegistrationService registrationService;

    private final PersonValidator personValidator;

    public AuthController(RegistrationService registrationService, PersonValidator personValidator) {
        this.registrationService = registrationService;
        this.personValidator = personValidator;
    }

    @GetMapping("/login")
    public String loginPage(){
        return "auth/login";
    }


    @GetMapping("/registration")
    public String registrationPage(@ModelAttribute("person") Person person){
        return "auth/Register";
    }
    @PostMapping("/registration")
    public String performRegistration(@ModelAttribute("person") @Valid Person person,
                                      Model model,
                                      BindingResult bindingResult){

        System.out.println(" Confirm :" + person.getConfirmPassword() + "\n"
        + " Binding Result " + bindingResult);

        personValidator.validate(person,bindingResult);

        if (bindingResult.hasErrors()){
            return "auth/Register";
        }
        if(!registrationService.register(person)){
            model.addAttribute("err","User is exists");
            return "auth/Register";
        }
//        System.out.println(personService.getUser(person.getEmail()) + " user : " + person.getEmail());
        return "redirect:/users";
    }

    @GetMapping("/activate/{code}")
    public String activate(Model model, @PathVariable String code){

        System.out.println(" Verification Code  " + code);

        boolean isActivated = registrationService.activateUser(code);

        if (isActivated) {
            model.addAttribute("messageType", "success");
            model.addAttribute("message", "User successfully activated");
        } else {
            model.addAttribute("messageType", "danger");
            model.addAttribute("message", "Activation code is not found!");
        }

        System.out.println(isActivated);

        return "forward:/auth/login";
    }

    @GetMapping("/logout")
    public String logout(){
        return "redirect:/auth/login";
    }


}
