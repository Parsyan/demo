package com.example.demo.repo.relationships;

import com.example.demo.model.keys.ShopUserKeys;
import com.example.demo.model.relationship.ShopUserRegistration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopUserRegistrationsRepository extends JpaRepository<ShopUserRegistration, ShopUserKeys> {
}
