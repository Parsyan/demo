package com.example.demo.db.model;

import com.example.demo.db.model.relationship.Cart;
import com.example.demo.db.model.relationship.Order;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDate;
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

//    TODO reform for category normal work.

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    private String status;

    @Min(1)
    private int counts;

    private String aboutItem;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;


    @CreatedDate
    private LocalDate createdDate;

    @OneToMany(mappedBy = "item")
    private List<Order> orderList;

    @OneToMany(mappedBy = "item")
    private List<Cart> cartList;

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
                "    person : " + person.getEmail() + '\n';
    }
}
