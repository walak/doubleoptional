package com.github.walak.doubleoptional;

import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.assertNotNull;

public class DoubleOptionalConstructionTest extends DoubleOptionalBasicTest {

    @Test
    public void shouldCreateDoubleOptionalOfTwoValues() {
        DoubleOptional<Integer, String> integerStringDoubleOptional = DoubleOptional.ofValues(valueA, valueB);

        assertNotNull(integerStringDoubleOptional);
    }

    @Test
    public void shouldCreateDoubleOptionalOfTwoOptionals() {
        DoubleOptional<Integer, String> integerStringDoubleOptional = DoubleOptional.ofOptionals(optionalA, optionalB);

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
        DoubleOptional.ofOptionals(empty(), null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldNotAllowToCreateFromNullAndOptional() {
        DoubleOptional.ofOptionals(empty(), null);
    }


}
