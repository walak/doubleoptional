package com.github.walak.doubleoptional;

import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class DoubleOptionalPresenceTest {

    private Integer valueA = 20;
    private String valueB = "TestString";

    @Test
    public void shouldReturnCorrectPresenceOfBoth() {
        assertTrue(DoubleOptional.ofValues(valueA, valueB).arePresent());
        assertFalse(DoubleOptional.ofValues(valueA, null).arePresent());
        assertFalse(DoubleOptional.ofValues(null, valueB).arePresent());
        assertFalse(DoubleOptional.ofValues(null, null).arePresent());

        Optional<Integer> optionalA = Optional.of(this.valueA);
        Optional<String> optionalB = Optional.of(this.valueB);
        Optional<?> empty = Optional.empty();

        assertTrue(DoubleOptional.ofOptionals(optionalA, optionalB).arePresent());
        assertFalse(DoubleOptional.ofOptionals(optionalA, empty).arePresent());
        assertFalse(DoubleOptional.ofOptionals(empty, optionalB).arePresent());
        assertFalse(DoubleOptional.ofOptionals(empty, empty).arePresent());
    }

    @Test
    public void shouldReturnCorrectPresenceOfA() {
        assertTrue(DoubleOptional.ofValues(valueA, valueB).isAPresent());
        assertTrue(DoubleOptional.ofValues(valueA, null).isAPresent());
        assertFalse(DoubleOptional.ofValues(null, valueB).isAPresent());
        assertFalse(DoubleOptional.ofValues(null, null).isAPresent());
    }

    @Test
    public void shouldReturnCorrectPresenceOfB() {
        assertTrue(DoubleOptional.ofValues(valueA, valueB).isBPresent());
        assertFalse(DoubleOptional.ofValues(valueA, null).isBPresent());
        assertTrue(DoubleOptional.ofValues(null, valueB).isBPresent());
        assertFalse(DoubleOptional.ofValues(null, null).isBPresent());
    }


}
