package com.example.demo.model;

import com.example.demo.model.relationship.ShopUserRegistration;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

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

    @OneToMany(mappedBy = "shop")
    private List<Item> items;

    @OneToMany(mappedBy = "shop")
    private List<ShopUserRegistration> shopUserRegistrationList;

    @Override
    public String toString() {
        return "Shop" +
                "   id : " + id + '\n' +
                "   name : " + name + '\n' +
                "   about : " + about;
    }
}
