package com.example.demo.db.repo;

import com.example.demo.db.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PeopleRepository extends JpaRepository<Person, Long> {
    Optional<Person> findByEmail(String email);

    boolean existsByEmail(String username);

    void deleteByEmail(String username);

    Optional<Person> findByActivationCode(String code);

}
