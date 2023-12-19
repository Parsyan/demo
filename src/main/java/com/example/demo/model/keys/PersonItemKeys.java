package com.example.demo.model.keys;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class PersonItemKeys implements Serializable {
    @Column(name = "person_id")
    Long personId;

    @Column(name = "item_id")
    Long itemId;
}
