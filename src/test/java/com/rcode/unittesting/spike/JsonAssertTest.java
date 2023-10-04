package com.rcode.unittesting.spike;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

public class JsonAssertTest {

    String actualResponse = "{\"id\": 1,\"name\":\"ball\",\"price\":10,\"quantity\":10}";

    /**
     * Here strict argument is true which means any extra space is valid but structure should be same.
     * It means you should have all the attributes
     *
     * @throws JSONException
     */
    @Test
    public void jsonAssert() throws JSONException {
        String expectedResponse = "{\"id\":  1,\"name\":\"ball\",\"price\":10,\"quantity\":10}";
//        String expectedResponse = "{\"id\":  1,\"name\":\"ball\"}";

        JSONAssert.assertEquals(expectedResponse, actualResponse, true);
    }

    /**
     * Here strict argument is true which means any extra space is valid but structure should be same.
     * It means you should have all the attributes
     *
     * @throws JSONException
     */
    @Test
    public void jsonAssertWithoutEscapeCharacters() throws JSONException {
        String expectedResponse = "{id:1, name:\"ball have\"}";

        JSONAssert.assertEquals(expectedResponse, actualResponse, false);
    }
}
