package com.example.demo;

import com.example.demo.model.Person;
import com.example.demo.repo.PeopleRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class DemoApplication {
//	private final PeopleRepository peopleRepository;
//	private final PasswordEncoder passwordEncoder;

//	public DemoApplication(PeopleRepository peopleRepository, PasswordEncoder passwordEncoder) {
//		this.peopleRepository = peopleRepository;
//		this.passwordEncoder = passwordEncoder;
//		this.peopleRepository.save(
//				new Person(null,"OPI","opo","gorparsyan13@mail.ru","094566554","male" ,"Armenia", 1990, "ROLE_ADMIN", null,false, passwordEncoder.encode("123456789"),null)
//		);
//	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);



	}

}
