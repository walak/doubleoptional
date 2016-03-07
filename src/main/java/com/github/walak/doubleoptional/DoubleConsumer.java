package com.github.walak.doubleoptional;

@FunctionalInterface
public interface DoubleConsumer<A,B> {

    void accept(A a, B b);
}
