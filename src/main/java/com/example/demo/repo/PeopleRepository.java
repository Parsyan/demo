package com.example.demo.repo;

import com.example.demo.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PeopleRepository extends JpaRepository<Person,Long> {
    Optional<Person> findByEmail(String email);

    boolean existsByEmail(String username);

    void deleteByEmail(String username);

}
