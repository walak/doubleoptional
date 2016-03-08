# doubleoptional
Optional-like structure which allows to work on two values at once

## Abstract

The simple set of classes allows you to work with two optional values at once. 
I am not really sure how bad is such design but I wanted to have it for some for-fun coding sessions.


## Disclaimer

I do not guarantee any correctness of the solution. You are using it at your own risk.

## Installing
 
The artifact has not been released to any Maven repository (and it won't be). If you really want to use it:

1. Clone the repository
2. Run `mvn install`
3. In your project add a dependency:

```
<dependency>
     <groupId>com.github.walak</groupId>
     <artifactId>doubleoptional</artifactId>
     <version>1.0-SNAPSHOT</version>
</dependency>
```
# Usage

## Creating instances

You can create an instance of `DoubleOptional` in two ways:

1. Initialize with raw values

```java
String string = "Example";
Integer value = null;

DoubleOptional<String, Integer> optional = DoubleOptional.ofValues(string, value);
```

Such form of initialization allows you to pass nulls. Underlying constructor uses `Optional.ofNullable()` to store values.

2. Initialize with Optionals

```java
Optional<String> maybeString = Optional.of("Example");
Optional<Integer> maybeInteger = Optional.of(12);

DoubleOptional<String, Integer> optional = DoubleOptional.ofOptionals(maybeString, maybeInteger);
```

This case won't let you pass a null as any argument but still you can pass empty Optional:
```java
Optional<String> maybeString = Optional.of("Example");

DoubleOptional<String, Integer> optional = DoubleOptional.ofOptionals(maybeString, Optional.empty()); //works fine

DoubleOptional<String, Integer> optional = DoubleOptional.ofOptionals(maybeString, null); //will throw exception
```

## Available methods

### Methods derived from Optional<T>

The most of methods correspond to methods included in standard Optional<> but doubled to handle single values (called A and B).
Methods directly derived from Optional<>:
- `isAPresent()`, `isBPresent()`
- `ifAPresent()`, `ifBPresent()`
- `getA()`, `getB()`
- `aOrElse()`, `bOrElse()`
- `aOrElseGet()`, `bOrElseGet()`
- `aOrElseThrow()`, `bOrElseThrow()`
- `empty()`

### Methods specific or behaving specifically to DoubleOptional<A, B>

#### boolean arePresent()
Returns true only when both values are present (so no null or empty `Optional` has been passed)

#### boolean isEmpty()
Opposite to `arePresent()` - returns true if any of value is not present

#### void ifBothPresent(DoubleConsumer<? super A, ? super B> consumer)
Executes passed consumer function only if both values are present

#### <Z> Optional<Z> mapSingle(BiFunction<? super A, ? super B, ? extends Z> function)
Transforms `DoubleOptional<A, B>` into `Optional<Z>`

#### <C, D> DoubleOptional<C, D> map(DoubleOptionalMapFunction<? super A, ? super B, C, D> function)
Transforms `DoubleOptional<A, B>` nto `DoubleOptional<C, D>`. AS Java doesn't allow to return multiple values
your actual implementation must return DoubleOptional<C, D> explicitly.




