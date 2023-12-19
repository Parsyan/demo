package com.example.demo.controller.adminPanelControllers.other;

import com.example.demo.model.Item;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserEmailAndItem {
    private String email;
    private Item item;
}
