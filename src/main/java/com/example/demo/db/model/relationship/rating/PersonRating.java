package com.example.demo.db.model.relationship.rating;

import com.example.demo.db.model.Person;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDate;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class PersonRating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "rater_person_id")
    private Person rater;

    @ManyToOne
    @JoinColumn(name = "rated_person_id")
    private Person rated;

    private int likeCounts;
    private int dislikeCounts;

    @CreatedDate
    private LocalDate created_date;
}
