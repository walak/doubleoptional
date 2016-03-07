package com.github.walak.doubleoptional;

@FunctionalInterface
public interface DoubleOptionalMapFunction<A, B, C, D> {
    DoubleOptional<C, D> accept(A a, B b);
}
