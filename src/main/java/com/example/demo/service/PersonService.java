package com.example.demo.service;

import com.example.demo.exception.UnsupportedUserInDBException;
import com.example.demo.model.Person;
import com.example.demo.repo.PeopleRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {
    private final PeopleRepository peopleRepository;
    private final PasswordEncoder passwordEncoder;

    public PersonService(PeopleRepository peopleRepository, PasswordEncoder passwordEncoder) {
        this.peopleRepository = peopleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public List<Person> getUsers () {
       return peopleRepository.findAll();
    }

    @Transactional
    public Optional<Person> getUser(String email) {
        return peopleRepository.findByEmail(email);
    }

    @Transactional
    public void editUser(Person person) throws UnsupportedUserInDBException {

        Optional<Person> user = peopleRepository.findByEmail(person.getEmail());

        if(user.isEmpty()) {
            throw new UnsupportedUserInDBException(" Undefined user in repository ");
        }
        if(person.getGender() == null){
            person.setGender(user.get().getGender());
        }

        if(person.getYearOfBirth() == null || person.getYearOfBirth().getYear() == 0){
            person.setYearOfBirth(user.get().getYearOfBirth());
        }
        if(person.getRole() == null){
            person.setRole(user.get().getRole());
        }
        if(person.getFirst_name() == null){
            person.setFirst_name(user.get().getFirst_name());
        }
        if(person.getPassword() == null){
            person.setPassword(user.get().getPassword());
        } else {
            person.setPassword(passwordEncoder.encode(person.getPassword()));
        }

        peopleRepository.save(person);

    }

    @Transactional
    public void deleteByUsername(String username){
        peopleRepository.deleteByEmail(username);
    }

}
