package com.example.demo.service;

import com.example.demo.model.Item;
import com.example.demo.model.Person;
import com.example.demo.repo.ItemsRepository;
import com.example.demo.repo.PeopleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ItemService {

    private final ItemsRepository itemsRepository;
    private final PeopleRepository peopleRepository;

    public void registerItem(Item item, Person person){

    }
}
