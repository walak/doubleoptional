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

1. Initialize with raw values:

```java
String string = "Example";
Integer value = null;

DoubleOptional<String, Integer> = DoubleOptional.ofValues(string, value);
```
