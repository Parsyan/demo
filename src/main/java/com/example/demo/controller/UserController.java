package com.example.demo.controller;

import com.example.demo.exception.UnsupportedUserInDBException;
import com.example.demo.db.model.Person;
import com.example.demo.service.PersonService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
// create logic is realized in AuthController class
    private final PersonService personService;

    public UserController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping
    public ResponseEntity<List<Person>> users() {
        return new ResponseEntity<>(personService.getUsers(), HttpStatus.FOUND);
    }


    @GetMapping({"{email}"})
    public ResponseEntity<Person> getUserByEmail(@PathVariable String email){
        var person = personService.getUser(email);
        return (person.isEmpty())
                ? new ResponseEntity<>(HttpStatus.NOT_FOUND)
                : new ResponseEntity<>(person.get(),HttpStatus.FOUND);
    }

    @PatchMapping({"/editUser","/editUser/"})
    public ResponseEntity<Person> editUser(@RequestBody Person person) {
          System.out.println(person);
          try {
              personService.editUser(person);
          } catch (UnsupportedUserInDBException ignored){
              return new ResponseEntity<>(HttpStatus.NOT_FOUND);
          }
        return new ResponseEntity<>(person, HttpStatus.OK);
    }

    @DeleteMapping("/deleteUser/")
    public ResponseEntity<Person> deleteUserByUsername(@RequestBody Person user, HttpServletRequest request) throws ServletException {
        personService.deleteByUsername(user.getEmail());
        if(user.getEmail().equals(request.getRemoteUser())) {
            request.logout();
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
