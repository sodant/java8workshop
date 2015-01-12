# Lab: Lambda lab.

## Introduction
 

In this lab you will get acquainted the Lambda and Method Reference syntax.


## Exercises

Complete all tests in `LambdaLabsTest`

Sources: `com.xebia.java8_1.lambdas.LambdaLabs`  
Tests: `com.xebia.java8_1.lambdas.LambdaLabsTest`  

### 1. Implement filterUsingAnonymousInnerClass

Filter adults using a an anonymous inner class as input of the `Persons.filter` method.

### 2. Implement filterWithLambda

Filter adults using a Lambda Expression as input of the `Persons.filter` method.

### 3. Implement filterWithMethodReference

Filter adults using a Method Reference as input of the `Persons.filter` method.

### 4. Implement filterMaleAdultsWithStaticMethodReference

Filter male adults using a **static** method reference as input of the `Persons.filter` method.

### 5. Implement sortPersonsWithLambda
     
Sort the persons by name using a Lambda Expression with two parameters as input of the `Persons.sort` method.

### 6. Implement sortPersonsWithLambda     

Sort the persons by name by creating a Comparator with the `Comparator.comparing` method.
Use a Method Reference to define the sorting key (`getName`) as argument of the comparing method.
