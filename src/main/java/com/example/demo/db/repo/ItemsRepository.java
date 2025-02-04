package com.example.demo.db.repo;

import com.example.demo.db.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ItemsRepository extends JpaRepository<Item, Long> {
    Optional<Item> existsItemByName(String name);
}
