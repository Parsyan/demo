package com.example.demo.db.model.relationship;

import com.example.demo.db.model.Item;
import com.example.demo.db.model.Person;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "basket")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
//    @MapsId("personId")
    @JoinColumn(name = "person_id")
    Person person;

    @ManyToOne
//    @MapsId("itemId")
    @JoinColumn(name = "item_id")
    Item item;

    @Min(1)
    int counts;
}
