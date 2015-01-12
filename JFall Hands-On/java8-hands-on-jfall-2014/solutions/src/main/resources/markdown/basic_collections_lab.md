# Lab: Basic collections

## Introduction

In this lab you will learn how to work with the new Java API combined with lambda expressions.

Sources: `com.xebia.java8_3.collections.BasicCollectionsLabs`  
Tests: `com.xebia.java8_3.collections.BasicCollectionsLabsTest`

## Exercises

Implement the methods and pass all the test cases.

### 1. Implement filterEvenNumbers

This method must filter out even numbers. The returned stream should only contain even numbers.

### 2. Implement filterAdults

Implement the method `filterAdults` which filters all the adults from a given list of persons.

Hint: use the map and filter methods from the stream.

### 3. Implement filterMinorsAndExtractName

Implement the method filterMinorsAndExtractName which filters and extracts the names.

### 4. Implement flatMapExample

In this exercise we will introduce the flatMap operation, implement the method timesAlphabet which returns the
following sequence: `a,b,b,c,c,c,.....z,z,z,z` (26 times)
So each index of the letter in the alphabet should be printed 'x' times.

Hint: first create a sequence of `[1], [2,2] [3,3,3]` etc then use flatMap.

### 5. Implement extractAllHobbiesToUppercase

This method should return all the hobbies in uppercase.

Hint: take a look at flatMap, there are two ways (even more) to make sure the hobbies are distinct. You can convert to a set or
you can use distinct.

### 6. Implement calculateTheSumOfARangeUsingReduce

Implement this method using the reduce method.

### 7. Implement sumWithReducerFunction
 
Implement the method `sumWithReducerFunction` which given a list of persons uses a reducer to sum the age of all the persons.

### 8. Implement sumAgeWithMapFunction

Implement the method `sumAgeWithMapFunction` which calculates the sum of all ages using sum() and a map function.

### 9. Implement sumWithCollectors

Implement the method `sumWithCollectors` which is the same as exercise 8 but now try to use a collect and a Collector.

### 10. Implement findTheOldestPerson
Implement the method `findTheOldestPerson` which returns the oldest person in the list.

Hint: try using `Collectors.maxBy` 

### 11. Implement allPersonsAboveAge

This method must return `true` if all the persons in the list are above the given minimum age. 

Hint: take a look at the method `Stream.allMatch`

### 12. Implement containsFemale

Check whether the list of persons contains a female using `Stream.anyMatch`.
         
### 13. Implement calculateSafeMax

Return the maximum value of a range or zero in case the range is empty using `Stream` and `Optional`

Hint: Do not check for empty lists.
