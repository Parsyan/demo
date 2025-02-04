package com.example.demo.db.model.relationship.rating;

import com.example.demo.db.model.Item;
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
public class ItemRating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;

    private int likeCounts;
    private int dislikeCounts;

    @CreatedDate
    private LocalDate created_date;
}
