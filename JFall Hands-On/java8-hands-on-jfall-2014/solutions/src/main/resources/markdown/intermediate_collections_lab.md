# Lab: Intermediate collections

## Introduction

In this lab you will learn more advanced features on streams.
In this exercise we will use the following simple domain:

`
Company ---- employees ---- Person  
`

So a company has a list of employees and a employee has a name, age, gender and a role (for example programmer)

Sources: `com.xebia.java8_3.collections.IntermediateCollectionsLab`  
Tests: `com.xebia.java8_3.collections.IntermediateCollectionsLabTest`

## Exercises

### 1. Implement personToString

Implement the method `personToString` which requires you to write a new collector which prints out the name(uppercase) and the gender 
and age as a comma separated string.

Example:

` Person p = new Person("Frank", 32, true) should create: (FRANK -> M),`
   
Hint: Look at the method signature of `Collector#of(java.util.function.Supplier, java.util.function.BiConsumer, java.util.function.BinaryOperator, java.util.stream.Collector.Characteristics...)}`


### 2. Implement removeYoungestAndOldestChildrenFromList

Implement the method `removeYoungestAndOldestChildrenFromList` which removes the youngest and the oldest persons from the list.

Hint: take a look at `IntSummaryStatistics` and use a collector to collect these statistics.

## Grouping

The next three exercises use the groupingBy method. The last one is more complicated.

### 3. Implement groupByNamesOfEmployee

Implement the method `groupByNamesOfEmployee` which will return a map with the key the name of the person and the value a list of
persons with that name.

### 4. Implement groupByAdultsAndMinors

Group the list of persons in adults and minors the result has to be a Map with key: 'adults' or 'minors' and value the list of
persons belonging to the classifier.

### 5. Implement findWhichRoleIsMostPopularAcrossCompanies

Implement the method `findWhichRoleIsMostPopularAcrossCompanies` which will return the role which is most available across companies.


### 6. Implement findCompanyWithOldestEmployee

Implement the method `findCompanyWithOldestEmployee` which finds the oldest employee over all the companies.
Hint: Don't forget you need to keep track of the company grouping on age will loose the companies. 

## New methods which will operate on streams

In the next exercises we will create new methods which will operate on streams.

### 7. Implement takeWhile

Implement the method `takeWhile` which continues consuming elements of the stream until the predicate returns `false`.

Hint:  take a look at the `Spliterators` class.

### 8. Implement zip

Implement the method `zip` which creates a combined Stream whose elements are the result of combining the elements of two streams. The
function will be applied until one of the streams is exhausted.

Hint: take a look at the test cases first to get a feeling on how the `zip` method should work


### 9. Implement zipWithSum

Implement this method which will take two streams of integers and returns a new stream by applying a stream which sums the elements 
of the `zip` method. 

