package com.example.demo.model.keys;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class ShopUserKeys implements Serializable {
    @Column(name = "person_id")
    Long personId;

    @Column(name = "shop_id")
    Long shopId;

}
