package com.example.demo.service;

import com.example.demo.model.Person;
import com.example.demo.repo.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;

import java.util.Optional;
import java.util.UUID;

@Service
public class RegistrationService {
    private final PeopleRepository peopleRepository;

    private final PasswordEncoder passwordEncoder;

    private final MailSender mailSender;

    @Autowired
    public RegistrationService(PeopleRepository peopleRepository, PasswordEncoder passwordEncoder, MailSender mailSender) {
        this.peopleRepository = peopleRepository;
        this.passwordEncoder = passwordEncoder;
        this.mailSender = mailSender;
    }

//    @Transactional
    public String register(Person person){
        Optional<Person> userFromDb = peopleRepository.findByEmail(person.getEmail());

        if (userFromDb.isPresent()) {
            return "User is exists";
        }

        person.setActive(true);
        person.setRole("ROLE_USER");
        person.setActivationCode(UUID.randomUUID().toString());
        if (person.getPassword().toString().length() < 8){
            return "Password must have a 8 symbols";
        } else if (!person.getPassword().equals(person.getConfirmPassword())){
            return "password and confirm password not equals";
        }

        person.setPassword(passwordEncoder.encode(person.getPassword()));



        peopleRepository.save(person);

        if (!StringUtils.isEmpty(person.getEmail())){
            String message = String.format(" Hello %s %s! \n" +
                    " Welcome to RealShop, Please, visit next link if you want activate your account Խիայարի ցավ : http://localhost:1212/demo/auth/" +
                            "activate/%s",
                    person.getFirst_name(),
                    person.getLast_name(),
                    person.getActivationCode());
            mailSender.send(person.getEmail(),"Activation Code", message);
        }

        return "Success";
    }

    public boolean activateUser(String code) {
        Optional<Person> user = peopleRepository.findByActivationCode(code);

        if (user.isEmpty()) {
            return false;
        }

        user.get().setActivationCode(null);

        peopleRepository.save(user.get());

        return true;
    }


}
