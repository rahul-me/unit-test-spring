package com.rcode.unittesting.controller;

import com.rcode.unittesting.model.Item;
import com.rcode.unittesting.service.ItemService;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = ItemController.class)
public class ItemControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ItemService itemService;

    @Test
    public void test() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/item").accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andExpect(status().isOk()).andExpect(content().json("{\"id\": 1,\"name\":\"ball\",\"price\":10,\"quantity\":10}")).andReturn();

    }

    @Test
    public void testUsingMockService() throws Exception {
        Mockito.when(itemService.get()).thenReturn(Item.builder().id(10).name("silver").build());

//        BDDMockito.given(itemService.get()).willReturn(Item.builder().id(10).name("silver").build());

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/v2/item").accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andExpect(status().isOk()).andExpect(content().json("{\"id\": 10,\"name\":\"silver\"}")).andReturn();

    }
}
