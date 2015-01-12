package com.xebia.java8_6.datetime;

import static java.time.DayOfWeek.MONDAY;
import static java.time.Month.FEBRUARY;
import static java.time.Month.JANUARY;
import static java.time.Month.NOVEMBER;
import static java.time.Month.OCTOBER;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.MonthDay;
import java.time.Year;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class DateTimeLabs {

    /**
     * Assignment: is to given a birthday calculate the the age with the new
     * Java 8 API for Date/Time recall how this was done before Java 8.
     */
    public static String calculateAge(LocalDate birthday) {
        return "0 years";
    }

    /**
     * Assignment: calculates the nth occurrence of a day for a given month and
     * year.
     *
     * @param year
     * @param month
     * @param numberOfOccurrence
     *            the occurrence of the day in the month to calculate, i.e 2nd
     *            Monday in March
     */
    public static MonthDay calculateDayOfMonth(Year year, Month month, DayOfWeek day, int numberOfOccurrence) {
        return MonthDay.now();
    }

    /**
     * Assignment: Given the American Federal holidays see below fill in the
     * comments in the method.
     *
     * <pre>
     * source: Wikipedia
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
     * </pre>
     */
    public static List<MonthDay> createFederalHolidays(Year year) {
        return Arrays.asList(MonthDay.of(Month.JANUARY, 1), //
                calculateDayOfMonth(year, JANUARY, MONDAY, 3), //
                calculateDayOfMonth(year, FEBRUARY, MONDAY, 3), //

                // Create solution for last monday in May

                MonthDay.of(Month.JULY, 4), //

                // Create solution for first monday in September

                calculateDayOfMonth(year, OCTOBER, MONDAY, 2), //
                MonthDay.of(NOVEMBER, 11), //
                calculateDayOfMonth(year, NOVEMBER, DayOfWeek.THURSDAY, 4), //
                MonthDay.of(Month.DECEMBER, 25));
    }

    public static long countWorkingDays(Year year) {
        return year.length();
    }

    private static Predicate<LocalDate> isDayInWeekend() {
        return d -> {
            return d.getDayOfWeek() == DayOfWeek.SATURDAY || d.getDayOfWeek() == DayOfWeek.SUNDAY;
        };
    }

}
