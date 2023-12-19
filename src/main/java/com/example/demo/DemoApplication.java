package com.example.demo;

import com.example.demo.model.Person;
import com.example.demo.model.other.Countries;
import com.example.demo.model.other.Role;
import com.example.demo.repo.PeopleRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.sql.Date;

@SpringBootApplication
public class DemoApplication {
	private final PeopleRepository peopleRepository;
	private final PasswordEncoder passwordEncoder;
//
	public DemoApplication(PeopleRepository peopleRepository, PasswordEncoder passwordEncoder) {
		this.peopleRepository = peopleRepository;
		this.passwordEncoder = passwordEncoder;
		System.out.println(this.peopleRepository.findAll());
//		this.peopleRepository.save(
//				new Person(
//						null,
//						"OPI",
//						"opo",
//						"gorparsyan13@mail.ru",
//						"094566554",
//						"male",
//						Countries.Armenia,
//						new Date(2006,9,11),
//						Role.ROLE_ADMIN,
//						null,
//						true,
//						passwordEncoder.encode("123456789"),
//						"123456789",
//						null,
//						null,
//						null,
//						null
//				)
//		);

	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);


	}

}
