package com.github.walak.doubleoptional;

import org.junit.Test;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.function.Supplier;

import static org.junit.Assert.assertEquals;


public class DoubleOptionalValueTest {

    private Integer valueA = 20;
    private String valueB = "TestString";

    @Test
    public void shouldReturnValuesPassed() {
        DoubleOptional<Integer, String> integerStringDoubleOptional = DoubleOptional.ofValues(valueA, valueB);

        assertEquals(valueA, integerStringDoubleOptional.getA());
        assertEquals(valueB, integerStringDoubleOptional.getB());
    }

    @Test
    public void shouldReturnValuesPassedAsOptionals() {
        DoubleOptional<Integer, String> integerStringDoubleOptional = DoubleOptional
                .ofOptionals(Optional.of(valueA), Optional.of(valueB));

        assertEquals(valueA, integerStringDoubleOptional.getA());
        assertEquals(valueB, integerStringDoubleOptional.getB());
    }

    @Test(expected = NoSuchElementException.class)
    public void shouldThrowExceptionWhenNoA() {
        DoubleOptional<Integer, String> integerStringDoubleOptional = DoubleOptional.ofValues(null, valueB);

        integerStringDoubleOptional.getA();
    }

    @Test(expected = NoSuchElementException.class)
    public void shouldThrowExceptionWhenNoB() {
        DoubleOptional<Integer, String> integerStringDoubleOptional = DoubleOptional.ofValues(valueA, null);

        integerStringDoubleOptional.getB();
    }

    @Test
    public void shouldReturnDefaultValue() {
        DoubleOptional<Integer, String> doubleOptional = DoubleOptional.ofValues(null, null);

        assertEquals(Integer.valueOf(22), doubleOptional.aOrElse(22));
        assertEquals("Alternative", doubleOptional.bOrElse("Alternative"));
    }

    @Test
    public void shouldReturnValueFromSupplier() {
        DoubleOptional<Integer, String> doubleOptional = DoubleOptional.ofValues(null, null);
        Supplier<Integer> supplierA = () -> 22;
        Supplier<String> supplierB = () -> "Alternative";

        assertEquals(Integer.valueOf(22), doubleOptional.aOrElseGet(supplierA));
        assertEquals("Alternative", doubleOptional.bOrElseGet(supplierB));
    }

    @Test(expected = RuntimeException.class)
    public void shouldThrowSuppliedExceptionWhenNoA() {
        DoubleOptional<Integer, String> doubleOptional = DoubleOptional.ofValues(null, null);

        doubleOptional.aOrElseThrow(RuntimeException::new);
    }

    @Test(expected = RuntimeException.class)
    public void shouldThrowSuppliedExceptionWhenNoB() {
        DoubleOptional<Integer, String> doubleOptional = DoubleOptional.ofValues(null, null);

        doubleOptional.bOrElseThrow(RuntimeException::new);
    }
}

