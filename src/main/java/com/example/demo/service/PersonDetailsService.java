package com.example.demo.service;

import com.example.demo.model.Person;
import com.example.demo.model.other.Role;
import com.example.demo.repo.PeopleRepository;
import com.example.demo.security.PersonDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Optional;
import java.util.UUID;

@Service
public class PersonDetailsService implements UserDetailsService {
    private final PeopleRepository peopleRepository;

    public PersonDetailsService(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    @Override
    public PersonDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<Person> person = peopleRepository.findByEmail(email);

        if (person.isEmpty()) {
            throw new UsernameNotFoundException("Пользователь не был найден");
        }
        return new PersonDetails(person.get());
    }

    @Service
    public static class RegistrationService {
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
        public String register(Person person) throws UnknownHostException {
            Optional<Person> userFromDb = peopleRepository.findByEmail(person.getEmail());

            if (userFromDb.isPresent()) {
                return "User is exists";
            }

            person.setActive(true);
            person.setRole(Role.ROLE_USER);
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
                        " Welcome to RealShop, Please, visit next link if you want activate your account  : http://%s/demo/auth/" +
                                "activate/%s",
                        person.getFirst_name(),
                        person.getLast_name(),
                        InetAddress.getLocalHost().getHostAddress(),
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
}
