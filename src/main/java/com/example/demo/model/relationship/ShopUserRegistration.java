package com.example.demo.model.relationship;

import com.example.demo.model.Person;
import com.example.demo.model.Shop;
import com.example.demo.model.keys.ShopUserKeys;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "shop_users_registration")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShopUserRegistration {
    @EmbeddedId
    ShopUserKeys id;

    @ManyToOne
    @MapsId("personId")
    @JoinColumn(name = "person_id")
    Person person;

    @ManyToOne
    @MapsId("shopId")
    @JoinColumn(name = "shop_id")
    Shop shop;
}
