package com.rcode.unittesting.service;

import com.rcode.unittesting.model.Item;
import com.rcode.unittesting.repository.ItemRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class ItemServiceTest {

    @InjectMocks
    private ItemService itemService;

    @Mock
    private ItemRepository itemRepository;

    @Test
    public void testFindAll() {
        List<Item> items = Arrays.asList(Item.builder().id(1).name("duck").price(10).quantity(2).build(), Item.builder().name("bycycle").price(15).quantity(2).build());

        Mockito.when(itemRepository.findAll()).thenReturn(items);

        List<Item> resultItems = itemService.findAll();
        Assertions.assertEquals(items.size(), resultItems.size());

        Assertions.assertEquals(items.get(0).getValue(), resultItems.get(0).getValue());
    }
}
