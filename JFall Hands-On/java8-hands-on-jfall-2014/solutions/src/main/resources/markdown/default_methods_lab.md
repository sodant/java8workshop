# Lab: Default methods

## Introduction

In this exercise you learn to isolate common behavior in an interface with default methods.
The class `ServiceWithTraditionalLogger` uses the `SimpleLogger` in an intrusive manner,
directly referencing the logger implementation.

To complete this exercise you have to implement a reusable `Logggable` interface. The `Logggable`
interface has to contain a <b>default method</b> info(String s), which can be called by the class
that implements this interface.

The `Logggable` interface has to delegate the call to info(String s) to a corresponding `SimpleLogger` belonging to
the class where this interface is implemented.

Consequently, the `ServiceWithDefaultMethodLogger` class can directly call logging methods (here only info)
without the need to create its own logger.

Sources: `com.xebia.java8_5.defaultmethods.DefaultMethodsLabs`  
Tests: `com.xebia.java8_5.defaultmethods.DefaultMethodsLabsTest`

## Exercises

Implement the method `info` in the class `Loggable` and pass all the test cases.
