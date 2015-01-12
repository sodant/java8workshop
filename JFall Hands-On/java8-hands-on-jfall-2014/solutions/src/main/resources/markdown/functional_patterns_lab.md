# Lab: Functional patterns

## Introduction

In this lab you will learn how to create your own 'higher order function'. A higher order function is a method that accepts a
functional interface as input parameter. So far you have only used *existing* higher order functions like e.g. map, filter, groupBy etc.
in the Stream API. In the lab below you will convert a solution that makes use of the template design-pattern into one that uses a
higher order function. 
 
As you will see, the higher order function approach is much more flexible, readable and requires less lines of code.

`Sources: com.xebia.java8_4.functionalpatterns.FunctionalPatternLabs`  
`Tests: com.xebia.java8_4.functionalpatterns.FunctionalPatternLabs`  

`Sources: com.xebia.java8_4.functionalpatterns.ImperativeToFunctionalLabs`  
`Tests: com.xebia.java8_4.functionalpatterns.ImperativeToFunctionalLabsTest`  

## Exercises

This lab consists of two different labs both labs have the same goal to create your own higher order functions.

## Lab 1: FunctionalPatternLabs

### 1. Implement filterPersonsFunctionalImpl

Implement `FunctionalPersonFilter.filterPersonsFunctionalImpl` in a functional style using the same processing logic as in the
`PersonFilterTemplate.filterPersonsImperativeImpl`

Hint: use `BufferedReader.lines()` as a starting point to the Stream API. As you can see not only Collections return Streams but 
`BufferedReader` too.


### 2. Implement filterPersons

Implement the higher order function `FunctionalPersonFilter.filterPerson`. In this functional implementation the filtering logic can 
directly be defined as a `Predicate` without the need to implement an abstract method like in the `PersonFilterTemplate` example. 

Hint: Most of the processing logic written in exercise 1 (see above) can be re-used.


## Lab 2: ImperativeToFunctionalLabs

### 1. Implement filterAndGroupPersons

Look at the imperative implementation `Lab1.Imperative.filterAndGroupPersons`.
Provide a functional solution in `Lab1.Functional.filterAndGropupPersons ` that yields the same result as the imperative example 
using the Stream API. The goal is to provide a functional approach for filtering persons with role Programmer, sorting them by 
name and group them by age. The method should return a map where the with key=age group (10, 20, 30 etc.) and value is a list of 
persons belonging to this group.
          

### 2. Implement calculateLengthOfLongestWord

Given the imperative implementation of the method calculateLengthOfLongestWord provide a functional approach for calculating the 
longest word in a list of lines. The words in a line can be separated by a space.

### 3. Implement calculateLengthOfLongestWordInParallel

Enhance the implementation of `Lab2.Functional.calculateLengthOfLongestWord` so that the calculation of the longest word per line 
is executed in parallel. 