package com.rcode.unittesting.spike;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class HamcrestMatchersTest {

    @Test
    public void test() {
        List<Integer> numbers = Arrays.asList(11,12,14);

        MatcherAssert.assertThat(numbers, Matchers.hasSize(3));
        MatcherAssert.assertThat(numbers, Matchers.hasItems(11,12));
        MatcherAssert.assertThat(numbers, Matchers.everyItem(Matchers.greaterThan(10)));
        MatcherAssert.assertThat(numbers, Matchers.everyItem(Matchers.lessThan(20)));

        MatcherAssert.assertThat("", Matchers.is(Matchers.emptyString()));
        MatcherAssert.assertThat("ABCDE", Matchers.containsString("BCD"));
        MatcherAssert.assertThat("ABCDE", Matchers.startsWith("ABC"));
        MatcherAssert.assertThat("ABCDE", Matchers.endsWith("CDE"));
    }
}
