package com.github.walak.doubleoptional;

import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class DoubleOptionalPresenceTest extends DoubleOptionalBasicTest {


    @Test
    public void shouldReturnCorrectPresenceOfBoth() {
        assertTrue(DoubleOptional.ofValues(valueA, valueB).arePresent());
        assertFalse(DoubleOptional.ofValues(valueA, null).arePresent());
        assertFalse(DoubleOptional.ofValues(null, valueB).arePresent());
        assertFalse(DoubleOptional.ofValues(null, null).arePresent());

        assertTrue(DoubleOptional.ofOptionals(optionalA, optionalB).arePresent());
        assertFalse(DoubleOptional.ofOptionals(optionalA, empty()).arePresent());
        assertFalse(DoubleOptional.ofOptionals(empty(), optionalB).arePresent());
        assertFalse(DoubleOptional.ofOptionals(empty(), empty()).arePresent());
    }

    @Test
    public void shouldReturnCorrectPresenceOfA() {
        assertTrue(DoubleOptional.ofOptionals(optionalA, optionalB).isAPresent());
        assertTrue(DoubleOptional.ofOptionals(optionalA, empty()).isAPresent());
        assertFalse(DoubleOptional.ofOptionals(empty(), optionalA).isAPresent());
        assertFalse(DoubleOptional.ofOptionals(empty(), empty()).isAPresent());
    }

    @Test
    public void shouldReturnCorrectPresenceOfB() {
        assertTrue(DoubleOptional.ofOptionals(optionalA, optionalB).isBPresent());
        assertFalse(DoubleOptional.ofOptionals(optionalA, empty()).isBPresent());
        assertTrue(DoubleOptional.ofOptionals(empty(), optionalB).isBPresent());
        assertFalse(DoubleOptional.ofOptionals(empty(), empty()).isBPresent());
    }


    @Test
    public void shouldRunFunctionWhenAIsPresent() {
        TestConsumer<Integer, String> functionToRun = new TestConsumer<>();

        DoubleOptional.ofOptionals(optionalA, empty()).ifAPresent(functionToRun);

        assertTrue(functionToRun.wasRun());
    }

    @Test
    public void shouldRunFunctionWhenBIsPresent() {
        TestConsumer<Object, Integer> functionToRun = new TestConsumer<>();

        DoubleOptional.ofOptionals(empty(), optionalB).ifBPresent(functionToRun);

        assertTrue(functionToRun.wasRun());
    }

    @Test
    public void shouldNotCallFunctionIfAnyMissing() {
        TestConsumer<Integer, String> functionToRun = new TestConsumer<>();

        DoubleOptional.ofOptionals(optionalA, Optional.<String>empty()).ifBothPresent(functionToRun);
        DoubleOptional.ofOptionals(Optional.<Integer>empty(), optionalB).ifBothPresent(functionToRun);
        DoubleOptional.ofOptionals(Optional.<Integer>empty(), Optional.<String>empty()).ifBothPresent(functionToRun);

        assertFalse(functionToRun.wasRun());
    }

    @Test
    public void shouldCallFunctionWhenBothPresent() {
        TestConsumer<Integer, String> functionToRun = new TestConsumer<>();

        DoubleOptional.ofValues(valueA, valueB).ifBothPresent(functionToRun);

        assertTrue(functionToRun.wasRun());
    }


}
