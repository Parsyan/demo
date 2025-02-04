package com.example.demo.db.model.relationship.rating;

import com.example.demo.db.model.Person;
import com.example.demo.db.model.Shop;
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
public class ShopRating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;

    @ManyToOne
    @JoinColumn(name = "shop_id")
    private Shop shop;

    private int likeCounts;
    private int dislikeCounts;

    @CreatedDate
    private LocalDate created_date;
}
