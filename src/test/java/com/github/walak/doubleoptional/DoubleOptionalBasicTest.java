package com.github.walak.doubleoptional;

import java.util.Optional;
import java.util.function.Consumer;

public abstract class DoubleOptionalBasicTest {
    protected Integer valueA = 20;
    protected String valueB = "TestString";

    protected Optional<Integer> optionalA = Optional.of(this.valueA);
    protected Optional<String> optionalB = Optional.of(this.valueB);

    @SuppressWarnings("unchecked")
    protected <A> Optional<A> empty() {
        return (Optional<A>) EMPTY;
    }

    private final Optional<?> EMPTY = Optional.empty();

    protected static class TestConsumer<A, B> implements Consumer<A>, DoubleConsumer<A, B> {

        private boolean run = false;

        @Override
        public void accept(A a) {
            run = true;
        }

        @Override
        public void accept(A a, B b) {
            accept(a);
        }

        public boolean wasRun() {
            return run;
        }
    }
}
