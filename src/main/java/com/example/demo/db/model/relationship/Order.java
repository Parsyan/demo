package com.example.demo.db.model.relationship;

import com.example.demo.db.model.Item;
import com.example.demo.db.model.Person;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDate;

@Entity
@Table(name = "orders")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
//    @MapsId("personId")
    @JoinColumn(name = "seller_person_id")
    Person seller;

    @ManyToOne
//    @MapsId("personId")
    @JoinColumn(name = "customer_person_id")
    Person customer;

    @ManyToOne
//    @MapsId("itemId")
    @JoinColumn(name = "item_id")
    Item item;

    @Min(1)
    int counts;

    @CreatedDate
    private LocalDate createdDate;

}