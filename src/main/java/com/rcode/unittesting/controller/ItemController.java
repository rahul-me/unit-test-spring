package com.rcode.unittesting.controller;

import com.rcode.unittesting.model.Item;
import com.rcode.unittesting.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ItemController {

    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping("/item")
    public Item item() {
        return Item.builder().id(1).name("ball").price(10).quantity(10).build();
    }

    @GetMapping("/v2/item")
    public Item item_v2() {
        return itemService.get();
    }

    @GetMapping("/items")
    public List<Item> items() {
        return itemService.findAll();
    }
}
