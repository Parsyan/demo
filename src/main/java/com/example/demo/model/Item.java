package com.example.demo.model;

import com.example.demo.model.other.Countries;
import com.example.demo.model.other.Role;
import com.example.demo.model.relationship.Basket;
import com.example.demo.model.relationship.BoughtItem;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "item")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name", insertable = false)
    private String name;
    @Column(name = "price", insertable = false)
    private int price;
    @Column(name = "category", insertable = false)
    private String category;

    private String status;

    @Min(1)
    private int counts;

    private String aboutItem;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;

    @ManyToOne
    @JoinColumn(name = "shop_id")
    private Shop shop;

    @OneToMany(mappedBy = "item")
    private List<BoughtItem> boughtItemList;

    @OneToMany(mappedBy = "item")
    private List<Basket> basketList;

    @Override
    public String toString() {
        return "Item" +
                "   id : " + id + '\n' +
                "    name : " + name + '\n' +
                "    price : " + price +
                "    category : " + category + '\n' +
                "    status : " + status + '\n' +
                "    counts : " + counts +
                "    aboutItem : " + aboutItem + '\n' +
                "    person : " + person.getEmail() + '\n' +
                "    shop ։ " + shop.getName();
    }
}
