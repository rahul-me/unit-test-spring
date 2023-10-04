package com.rcode.unittesting.spike;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class JsonPathTest {

    @Test
    public void test() {
        String responseFromService = "[" +
                "{\"id\":10000, \"name\":\"Pencil\", \"quantity\":5}," +
                "{\"id\":10001, \"name\":\"Pen\", \"quantity\":15}," +
                "{\"id\":10002, \"name\":\"Eraser\", \"quantity\":10}" +
                "]";

        DocumentContext context =  JsonPath.parse(responseFromService);

        int l = context.read("$.length()");
        Assertions.assertThat(l).isEqualTo(3);

        List<Integer> list = context.read("$..id");
        Assertions.assertThat(list).containsExactly(10000, 10001, 10002);

        System.out.println(context.read("$.[1]").toString());
        System.out.println(context.read("$.[1]['name']").toString());
        System.out.println(context.read("$.[0:1]").toString());
    }
}
