package com.github.walak.doubleoptional;


import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DoubleOptionalMapTest {

    private Integer valueA = 20;
    private String valueB = "TestString";


    @Test
    public void shouldMapValuesToNewDoubleOptional() {
        DoubleOptional<Integer, String> firstOptional = DoubleOptional.ofValues(valueA, valueB);
        DoubleOptional<String, Integer> mappedOptional = firstOptional
                .map((a, b) -> DoubleOptional.ofValues(b, a));

        assertEquals(firstOptional.getA(), mappedOptional.getB());
        assertEquals(firstOptional.getB(), mappedOptional.getA());
    }

    @Test
    public void shouldNotMapOptionalWhenEmptyValues() {
        DoubleOptional<Integer, String> firstOptional = DoubleOptional.ofValues(null, valueB);
        DoubleOptional<String, Integer> mappedOptional = firstOptional
                .map((a, b) -> DoubleOptional.ofValues(b, a));

        assertTrue(mappedOptional.isEmpty());
    }

}
