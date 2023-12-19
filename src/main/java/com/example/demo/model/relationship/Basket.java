package com.example.demo.model.relationship;

import com.example.demo.model.Item;
import com.example.demo.model.Person;
import com.example.demo.model.keys.PersonItemKeys;
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
public class Basket {

    @EmbeddedId
    PersonItemKeys id;

    @ManyToOne
    @MapsId("personId")
    @JoinColumn(name = "person_id")
    Person person;

    @ManyToOne
    @MapsId("itemId")
    @JoinColumn(name = "item_id")
    Item item;

    @Min(1)
    int counts;
}
