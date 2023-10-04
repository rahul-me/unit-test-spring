package com.rcode.unittesting.service;

import com.rcode.unittesting.model.Item;
import org.springframework.stereotype.Component;

@Component
public class ItemService {

    public Item get() {
        return Item.builder().id(1).name("ball").price(10).quantity(10).build();
    }
}
