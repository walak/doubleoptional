package com.github.walak.doubleoptional;

import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.assertNotNull;

public class DoubleOptionalConstructionTest {

    private Integer valueA = 20;
    private String valueB = "TestString";

    @Test
    public void shouldCreateDoubleOptionalOfTwoValues() {
        DoubleOptional<Integer, String> integerStringDoubleOptional = DoubleOptional.ofValues(valueA, valueB);

        assertNotNull(integerStringDoubleOptional);
    }

    @Test
    public void shouldCreateDoubleOptionalOfTwoOptionals() {
        Optional<Integer> integerOptional = Optional.of(valueA);
        Optional<String> stringOptional = Optional.of(valueB);
        DoubleOptional<Integer, String> integerStringDoubleOptional = DoubleOptional.ofOptionals(integerOptional, stringOptional);

        assertNotNull(integerStringDoubleOptional);
    }

    @Test
    public void shouldCreateOptionalOfNulls() {
        DoubleOptional<?, ?> opt1 = DoubleOptional.ofValues(null, null);
        DoubleOptional<?, ?> opt2 = DoubleOptional.ofValues("NotNull", null);
        DoubleOptional<?, ?> opt3 = DoubleOptional.ofValues(null, "Not null");

        assertNotNull(opt1);
        assertNotNull(opt2);
        assertNotNull(opt3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldNotAllowToCreateFromOptionalAndNull() {
        DoubleOptional.ofOptionals(Optional.empty(), null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldNotAllowToCreateFromNullAndOptional() {
        DoubleOptional.ofOptionals(Optional.empty(), null);
    }


}
