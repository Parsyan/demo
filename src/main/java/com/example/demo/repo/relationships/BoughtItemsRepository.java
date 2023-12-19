package com.example.demo.repo.relationships;

import com.example.demo.model.keys.PersonItemKeys;
import com.example.demo.model.relationship.BoughtItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoughtItemsRepository extends JpaRepository<BoughtItem, PersonItemKeys> {
}
