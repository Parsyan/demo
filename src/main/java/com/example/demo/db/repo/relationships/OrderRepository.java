package com.example.demo.db.repo.relationships;

import com.example.demo.db.model.relationship.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
