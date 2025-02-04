package com.example.demo.db.repo.relationships.rating;


import com.example.demo.db.model.relationship.Cart;
import com.example.demo.db.model.relationship.rating.PersonRating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeopleRatingRepository extends JpaRepository<PersonRating, Long> {
}
