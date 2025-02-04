package com.example.demo.service;

import com.example.demo.exception.UnsupportedUserInDBException;
import com.example.demo.db.model.Person;
import com.example.demo.db.repo.PeopleRepository;
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

        if (user.get().getId() != 0){
            person.setId(user.get().getId());
        }
        if(person.getGender() == null){
            person.setGender(user.get().getGender());
        }
        if(person.getPhone_number() == null){
            person.setPhone_number(user.get().getPhone_number());
        }

        if(person.getBirthDate() == null || person.getBirthDate().getTime() == 0){
            person.setBirthDate(user.get().getBirthDate());
        }
        if(person.getRole() == null){
            person.setRole(user.get().getRole());
        }
        if(person.getFirst_name() == null){
            person.setFirst_name(user.get().getFirst_name());
        }
        if(person.getLast_name() == null){
            person.setLast_name(user.get().getLast_name());
        }

        if(person.getPassword() == null){
            person.setPassword(user.get().getPassword());
        } else {
            person.setPassword(passwordEncoder.encode(person.getPassword()));
        }

        peopleRepository.save(person);

        System.out.println(person + "qwertyu");
    }

    @Transactional
    public void deleteByUsername(String username){
        peopleRepository.deleteByEmail(username);
    }

}
