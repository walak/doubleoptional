package com.github.walak.doubleoptional;

import java.util.Objects;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class DoubleOptional<A, B> {
    private final static DoubleOptional<?, ?> EMPTY = DoubleOptional.ofOptionals(Optional.empty(), Optional.empty());

    private Optional<A> optionalA;
    private Optional<B> optionalB;

    DoubleOptional(Optional<A> optionalA, Optional<B> optionalB) {
        this.optionalA = optionalA;
        this.optionalB = optionalB;
    }

    public static <A, B> DoubleOptional<A, B> ofOptionals(Optional<A> optA, Optional<B> optB) {
        if (optA == null || optB == null) {
            throw new IllegalArgumentException("Cannot initialize with null optionals!");
        }
        return new DoubleOptional<A, B>(optA, optB);
    }


    public static <A, B> DoubleOptional<A, B> ofValues(A a, B b) {
        return new DoubleOptional<>(Optional.ofNullable(a), Optional.ofNullable(b));
    }

    public boolean arePresent() {
        return optionalA.isPresent() && optionalB.isPresent();
    }

    public void ifAPresent(Consumer<? super A> consumer) {
        optionalA.ifPresent(consumer);
    }

    public void ifBPresent(Consumer<? super B> consumer) {
        optionalB.ifPresent(consumer);
    }

    public boolean isAPresent() {
        return optionalA.isPresent();
    }

    public boolean isBPresent() {
        return optionalB.isPresent();
    }

    public boolean isEmpty() {
        return !(isAPresent() && isBPresent());
    }

    public void ifBothPresent(DoubleConsumer<? super A, ? super B> consumer) {
        if (arePresent()) {
            consumer.accept(optionalA.get(), optionalB.get());
        }
    }

    public <Z> Optional<Z> mapSingle(BiFunction<? super A, ? super B, ? extends Z> function) {
        if (arePresent()) {
            return Optional.ofNullable(function.apply(optionalA.get(), optionalB.get()));
        } else {
            return Optional.empty();
        }
    }

    public <C, D> DoubleOptional<C, D> map(DoubleOptionalMapFunction<? super A, ? super B, C, D> function) {
        if (arePresent()) {
            return function.accept(optionalA.get(), optionalB.get());
        } else {
            return empty();
        }
    }

    public A getA() {
        return optionalA.get();
    }

    public B getB() {
        return optionalB.get();
    }

    @SuppressWarnings("unchecked")
    public static <C, D> DoubleOptional<C, D> empty() {
        return (DoubleOptional<C, D>) EMPTY;
    }

    public A aOrElse(A a) {
        return optionalA.orElse(a);
    }

    public B bOrElse(B b) {
        return optionalB.orElse(b);
    }

    public A aOrElseGet(Supplier<? extends A> supplier) {
        return optionalA.orElseGet(supplier);
    }

    public B bOrElseGet(Supplier<? extends B> supplier) {
        return optionalB.orElseGet(supplier);
    }

    public <X extends Throwable> A aOrElseThrow(Supplier<? extends X> supplier) throws X {
        return optionalA.orElseThrow(supplier);
    }

    public <X extends Throwable> B bOrElseThrow(Supplier<? extends X> supplier) throws X {
        return optionalB.orElseThrow(supplier);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof DoubleOptional)) {
            return false;
        }

        DoubleOptional other = (DoubleOptional) obj;

        return this.optionalA.equals(other.optionalA) &&
                this.optionalB.equals(other.optionalB);
    }

    @Override
    public int hashCode() {
        return Objects.hash(optionalA.hashCode(), optionalB.hashCode());
    }
}
