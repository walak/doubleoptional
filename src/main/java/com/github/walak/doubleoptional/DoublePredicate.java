package com.github.walak.doubleoptional;

@FunctionalInterface
public interface DoublePredicate<A, B> {

    boolean test(A a, B b);

    default DoublePredicate<A, B> and(DoublePredicate<? super A, ? super B> predicate) {
        return (a, b) -> test(a, b) && predicate.test(a, b);
    }

    default DoublePredicate<A, B> negate() {
        return (a, b) -> !test(a, b);
    }

    default DoublePredicate<A, B> or(DoublePredicate<? super A, ? super B> predicate) {
        return (a, b) -> test(a, b) || predicate.test(a, b);
    }
}
