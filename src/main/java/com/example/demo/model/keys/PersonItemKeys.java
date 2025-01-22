package com.example.demo.model.keys;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class PersonItemKeys implements Serializable {
    @Column(name = "person_id")
    Long personId;

    @Column(name = "item_id")
    Long itemId;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        PersonItemKeys that = (PersonItemKeys) o;
        return Objects.equals(personId, that.personId) && Objects.equals(itemId, that.itemId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(personId, itemId);
    }
}
