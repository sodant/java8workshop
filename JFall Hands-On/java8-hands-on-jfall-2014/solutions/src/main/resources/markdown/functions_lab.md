# Lab: Functions lab

## Introduction
 
 This lesson will cover the basics of the newly added functional interfaces in package `java.util.function` defined in Java 8. This exercise uses
some extra classes which can be found in the shared project.

## Exercises

Sources: `com.xebia.java8_2.function.FunctionsLabs`  
Tests: `com.xebia.java8_2.functions.FunctionsLabTest`

### 1. Implement selectAdultPersonWithLambda

Create a predicate which uses a lambda expression to test whether a given person is an adult or not.

### 2. Implement selectAdultPersonWithMethodReference

Same as exercise 1 only now uses a method reference.

### 3. Implement selectFemaleOrMinorsWithCombinedPredicates

Use the logical operator methods in Predicate to combine predicates.

### 4. Implement selectMinorPersonWithCombinedPredicates

Use the logical operator methods in Predicate to combine new predicates.
     
### 5. Implement convertNameToUppercase

Write a function which outputs the name of the person in uppercase.

### 6. Implement comboString

Write a function which takes two strings and returns a String as follows: short+long+short.

### 7. Implement sum

Assign a Lambda to a `BiFunction` that calculates the sum of the two parameters passed to it 

### 8. Implement max function

Assign a Static Method Reference to a `BiFunction` that calculates the max of two values. As method reference the max method of `Math`.

### 9. Implement square 

write a function which outputs the square.

### 10. Implement sumToString

Write a composition of two functions, one function which calculates the sum and one which will convert the sum to a String

### 11. Implement logWithConsumer

Assign a Lambda to a {@link Consumer} that logs a {@link Person}'s toString.

### 12. Implement logWithMethodReference

Instruction Assign a Method Reference of the info method of `SimpleLogger` to a `Consumer` that logs a `Person`'s toString.

### 13. Implement sortByName

Write an implementation of the comparator function using a lambda expression.

### 14. Implement nameOfPersonWithLambdaSupplier

Assign a Lambda to a `Supplier` that returns a `Person` name. 
     
### 15. Implement nameOfPersonWithMethodReferenceSupplier

Assign a Lambda to a `Supplier` that returns a `Person` name