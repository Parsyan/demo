package com.example.demo.repo.relationships;

import com.example.demo.model.keys.PersonItemKeys;
import com.example.demo.model.relationship.Basket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BasketsRepository extends JpaRepository<Basket, PersonItemKeys> {
}
