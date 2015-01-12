## Lab: Infinite streams

## Introduction

In this exercise we are building our own lazy stream called JStream and learn how to work with suppliers and how the new language features will help you create more elegant structures.
We are using the definition of an algebraic type for this, see
[link](http://en.wikipedia.org/wiki/Algebraic_data_type). In short the definition of a stream is as follows:

`
Stream s = Nil | Cons s (Stream s)
`
  
We can define this stream in terms of two classes called ``Cons`` and ``Nil``. The ``Cons`` classes uses a supplier which will postpone
the evaluation of the next element by which we are able to generate an infinite stream.

Sources: `com.xebia.java8_7.infinite_list.JStream`  
Tests: `com.xebia.java8_7.infinite_list.JStreamTest`

## Exercises

The cons and the nil classes are already supplied, in this exercise we will implement some behavior for this new stream.

### 1. Implement of

First to get familiar with the building blocks of the JStream class in this exercise we will create a stream consisting of the
supplied elements. 

Hint: consider writing a helper function which will create the stream based on the index in the elements array.
In order to test the solution run the test case with the name `streamCreation`.

### 2. Implement forEach

In order to be able to process the elements of a stream we need to write a function called `forEach` which accepts an element of 
the stream and returns nothing. Test the solution run the test case with the name `forEach`. 

### 3. Implement start

Until now the streams were still limited to a couple of elements, in this exercise we will create an infinite stream. As in Java streams
an infinite stream takes on a starting point and a function to create the next element of the stream if needed.
Test your implementation with the test case `infiniteStream`.

### 4. Implement takeWhile

Creating infinite streams is great but know we want work with the streams, for example taking n-number of elements of the stream.
Implement the method `takeWhile` which will based on a predicate select the elements from the stream until the predicate false. 
For example:

`
JStream.iterate(0, i -> i + 1).takeWhile(i -> i <= 4)  
`

should return 0,1,2,3,4.

### 5. Implement fibonacci

Until now we have been developing methods for creating and consuming streams, in this exercise with the previous implemented methods you 
need to write the fibonacci sequence in terms of an infinite stream. You can test your implementation with the test case `fibonacci`.
 

### 6. Implement drop

Write a method which will drop n-numbers of a stream. 


### 7. Implement zip

In the BasicCollections API we wrote a zip function which creates a combined stream whose elements are the result of combining the 
elements of two streams. The function will be applied until one of the streams is exhausted.
