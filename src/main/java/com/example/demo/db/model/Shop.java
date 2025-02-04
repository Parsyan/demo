package com.example.demo.db.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDate;

@Entity
@Table(name = "shops")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Shop {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "shop_name")
    private String name;

    @Column(name = "shop_about")
    private String about;

    //    TODO REFORM FOR PERSON_ID
    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;

    @CreatedDate
    private LocalDate createdDate;
//
//  TODO Think realize it or not ???
//    @OneToMany(mappedBy = "shop")
//    private List<Item> items;


    @Override
    public String toString() {
        return "Shop" +
                "   id : " + id + '\n' +
                "   name : " + name + '\n' +
                "   about : " + about;
    }
}
