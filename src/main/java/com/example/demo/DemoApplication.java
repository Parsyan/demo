package com.example.demo;

import com.example.demo.db.model.Person;
import com.example.demo.db.model.other.Countries;
import com.example.demo.db.model.other.Role;
import com.example.demo.db.repo.PeopleRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.sql.Date;

@SpringBootApplication
public class DemoApplication {
	private final PeopleRepository peopleRepository;
	private final PasswordEncoder passwordEncoder;

	public DemoApplication(PeopleRepository peopleRepository, PasswordEncoder passwordEncoder) {
		this.peopleRepository = peopleRepository;
		this.passwordEncoder = passwordEncoder;
		System.out.println(this.peopleRepository.findAll());
		this.peopleRepository.save(
				Person.builder()
						.email("gorparsyan13@mail.ru")
						.password(passwordEncoder.encode("123456789"))
						.confirmPassword("123456789")
						.active(true)
						.first_name("OPI")
						.last_name("opo")
						.birthDate(Date.valueOf("2006-9-11"))
						.phone_number("094566554")
						.gender("male")
						.country(Countries.Armenia)
						.role(Role.ROLE_ADMIN)

							.build()
		);

	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);


	}

}
