package com.example.demo.db.repo.relationships.rating;


import com.example.demo.db.model.relationship.rating.ItemRating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopRatingRepository extends JpaRepository<ItemRating, Long> {
}
