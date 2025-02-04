package com.example.demo.service;

import com.example.demo.exception.UnsupportedUserInDBException;
import com.example.demo.db.model.Item;
import com.example.demo.db.model.Person;
import com.example.demo.db.repo.ItemsRepository;
import com.example.demo.db.repo.PeopleRepository;
import jakarta.persistence.EntityExistsException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ItemService {

    private final ItemsRepository itemsRepository;
    private final PeopleRepository peopleRepository;

    @Transactional
    public void registerItem(Item item, Person person){
        Optional<Item> exists = itemsRepository.existsItemByName(item.getName());
        if (exists.isPresent()) {
            throw new EntityExistsException("Item is Exists");
        }

        item.setPerson(person);
        itemsRepository.save(item);
    }
    @Transactional
    public void registerItem(Item item) throws UnsupportedUserInDBException {
        if(item.getPerson() == null)
            throw new UnsupportedUserInDBException("User Not Found");

        itemsRepository.save(item);
    }
}
