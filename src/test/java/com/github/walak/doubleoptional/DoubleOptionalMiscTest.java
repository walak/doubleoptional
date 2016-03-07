package com.github.walak.doubleoptional;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class DoubleOptionalMiscTest extends DoubleOptionalBasicTest {

    private final DoubleOptional<Integer, String> firstOptional = DoubleOptional.ofOptionals(optionalA, optionalB);
    private final DoubleOptional<Integer, String> secondOptional = DoubleOptional.ofValues(valueA, valueB);

    @Test
    public void shouldBeEqualForTheSameValuesWithin() {
        assertEquals(firstOptional, firstOptional);
        assertNotEquals(firstOptional, new Object());
        assertEquals(firstOptional, secondOptional);
    }

    @Test
    public void shouldReturnTheSameHashcodeForTheSameValuesWithin() {
        assertEquals(firstOptional.hashCode(), secondOptional.hashCode());
    }
}
