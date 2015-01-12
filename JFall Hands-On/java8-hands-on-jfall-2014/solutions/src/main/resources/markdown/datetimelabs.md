## Lab: The new and improved DateTime API

## Introduction

In this lab we are going to explore the new Date Time API a bit more. This API has been significantly improved and has resemblance
with Joda time.

In these exercises you will learn about the following API's:

* DayOfWeek
* LocalDate
* Month
* TemporalAdjusters
* DayOfWeek
* Period;
* Year

Sources: `com.xebia.java8_6.datetime.DateTimeLabs`  
Tests: `com.xebia.java8_6.datetime.DateTimeLabsTest`

## Exercises

### 1. Implement calculateAge

With the old API it was quite a challenge to calculate the age of someone. In this exercise we use the new API to given a birthday calculate
the the age with the new Java 8 API for Date/Time, implement the `calculateAge` method.

### 2. Implement calculateDayOfMonth

Write an implementation for the method `calculateDayOfMonth` which calculates the nth occurrence of a day for a given month and year.
For example the first Wednesday in November this year is 5 November.

### 3. Implement createFederalHolidays

Exercise 3 and 4 belong together first we start with determining the days of the month the federal holidays 
From Wikipedia we learn that:

* January 1 (Fixed) := New Year's Day  
* Third Monday in January := Birthday of Martin Luther King, Jr.
* Third Monday in February (Presidents' Day) := Washington's Birthday
* Last Monday in May := Memorial Day
* July 4 (Fixed) :=  Independence Day
* First Monday in September := Labor Day
* Second Monday in October := Columbus Day
* November 11 (Fixed) := Veterans Day
* Fourth Thursday in November := Thanksgiving Day
* December 25 (Fixed) := Christmas

Some days are already implemented in the method `createFederalHolidays`, fill in the missing dates with the aid of the DateTime API.

### 4. Implement countWorkingDays

Implement the method `countWorkingDays` which will count the working days within a year, you filter based on weekdays and federal holidays
which we implemented in the previous example.
