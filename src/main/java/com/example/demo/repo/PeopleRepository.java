package com.example.demo.repo;

import com.example.demo.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PeopleRepository extends JpaRepository<Person, Long> {
    Optional<Person> findByEmail(String email);

    boolean existsByEmail(String email);

    void deleteByEmail(String email);

    Optional<Person> findByActivationCode(String code);

    List<Person> findByEmailIsContaining(String email);
}
