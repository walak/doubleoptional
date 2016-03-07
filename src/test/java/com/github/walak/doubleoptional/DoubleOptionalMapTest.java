package com.github.walak.doubleoptional;


import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.*;

public class DoubleOptionalMapTest extends DoubleOptionalBasicTest {


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
        DoubleOptional<Integer, String> firstOptional = DoubleOptional.ofOptionals(empty(), optionalB);
        DoubleOptional<String, Integer> mappedOptional = firstOptional
                .map((a, b) -> DoubleOptional.ofValues(b, a));

        assertTrue(mappedOptional.isEmpty());
    }


    @Test
    public void shouldMapToSingleOptional() {
        DoubleOptional<Integer, String> firstOptional = DoubleOptional.ofValues(valueA, valueB);
        Integer integer = firstOptional
                .mapSingle((a, b) -> a)
                .get();

        assertEquals(valueA, integer);
    }

    @Test
    public void shouldNotMapToSingleIfAnyMissing() {
        DoubleOptional<Integer, String> firstOptional = DoubleOptional.ofOptionals(optionalA, empty());
        DoubleOptional<Integer, String> secondOptional = DoubleOptional.ofOptionals(empty(), optionalB);
        DoubleOptional<Integer, String> thirdOptional = DoubleOptional.empty();

        Optional<Integer> optInteger = firstOptional.mapSingle((a, b) -> a);
        Optional<String> optString = secondOptional.mapSingle((a, b) -> b);
        Optional<Object> optObject = thirdOptional.mapSingle((a, b) -> new Object());

        assertFalse(optInteger.isPresent());
        assertFalse(optString.isPresent());
        assertFalse(optObject.isPresent());
    }
}
