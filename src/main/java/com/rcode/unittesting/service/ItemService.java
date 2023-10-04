package com.rcode.unittesting.service;

import com.rcode.unittesting.model.Item;
import com.rcode.unittesting.repository.ItemRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ItemService {

    private final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public Item get() {
        return Item.builder().id(1).name("ball").price(10).quantity(10).build();
    }

    public List<Item> findAll() {
        List<Item> items = itemRepository.findAll();
        items.forEach(i -> i.setValue(i.getPrice() * i.getQuantity()));
        return items;
    }
}
