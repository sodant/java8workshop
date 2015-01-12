# Lab: Phone coder lab

## Introduction
 
In this lab we will construct part of the Phone code benchmark [link](http://page.mi.fu-berlin.de/prechelt/phonecode/).
The original task is more difficult but in this lab you will learn a lot more about
String, maps and collectors together in a real example.

In this lab we take the following phone mnemonics:

ABC|DEF|GHI|JKL|MNO|PQRS|TUV|WXYZ
:---:|:---:|:---:|:---:|:---:|:----:|:---:|:----:      
2 | 3 | 4 | 5 | 6 | 7  | 8 | 9 


We will build a PhoneCoder which will translate a phone number to all phrases of words
in a dictionary that can serve as mnemonics for the phone number.
For example `5282` should translate to `Java` if this was supplied in the dictionary.

## Exercises

You can follow the steps below to build the PhoneCoderor create your own PhoneCoder
from scratch.  

Sources: `com.xebia.java8_3.collections.PhoneCoder`  
Tests: `com.xebia.java8_3.collections.PhoneCoderTest`

### 1. Implement charToDigit

This method is a helper function which should return a `Map<Character, Character>`, for 
example if we take `mnemonics = new HashMap<Character, String>('2', "ABC")` then the returned map should contain:

`'A' --> '2'`     
`'B' --> '2'`     
`'C' --> '2'`     

Tip use the String method `chars()`.

### 2. Implement getNumberFrom

This method should translate a given word into a number, for example `'Java'` should return
`5282`.

### 3. Implement distributeWords

This method takes a list of words as input and as a result creates a map from number to the word. So for example if you take `Java, Lava` as your 
words the method should return a map which contains:

`` 
5282 --> [ Java, Lava ]
``

### 4. Putting it all together

Implement the method `translate` which will return the words based on the given number.
