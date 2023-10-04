package com.rcode.unittesting.spike;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@TestPropertySource(locations = {"classpath:test.properties"})
public class DifferentPropertiesFileTest {

    @Test
    public void test(){

    }
}
