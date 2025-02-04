package com.example.demo.db.repo;

import com.example.demo.db.model.Shop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopsRepository extends JpaRepository<Shop, Long> {
}
