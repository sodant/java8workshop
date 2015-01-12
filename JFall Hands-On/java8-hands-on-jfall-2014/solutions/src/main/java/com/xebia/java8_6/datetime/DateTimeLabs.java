package com.xebia.java8_6.datetime;

import static com.xebia.java8_3.collections.IntermediateCollectionsLab.takeWhile;
import static java.time.DayOfWeek.MONDAY;
import static java.time.LocalDate.of;
import static java.time.Month.FEBRUARY;
import static java.time.Month.JANUARY;
import static java.time.Month.MAY;
import static java.time.Month.NOVEMBER;
import static java.time.Month.OCTOBER;
import static java.time.Month.SEPTEMBER;
import static java.time.MonthDay.from;
import static java.time.temporal.TemporalAdjusters.dayOfWeekInMonth;
import static java.time.temporal.TemporalAdjusters.firstInMonth;
import static java.time.temporal.TemporalAdjusters.lastInMonth;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.MonthDay;
import java.time.Period;
import java.time.Year;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class DateTimeLabs {

    /**
     * Assignment: is to given a birthday calculate the the age with the new
     * Java 8 API for Date/Time recall how this was done before Java 8.
     */
    public static String calculateAge(LocalDate birthday) {
        //#if (TARGET=="SOLUTION")
        Period p = Period.between(birthday, LocalDate.now());
        return String.format("%d years, %d months and %d days", p.getYears(), p.getMonths(), p.getDays());
        //#else
        //$return "0 years";
        //#endif
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
        //#if (TARGET=="SOLUTION")
        return MonthDay.from(of(year.getValue(), month, 1).with(dayOfWeekInMonth(numberOfOccurrence, day)));
        //#else
        //$return MonthDay.now();
        //#endif
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

                //#if (TARGET=="SOLUTION")
                from(of(year.getValue(), MAY, 1).with(lastInMonth(MONDAY))), //
                //#else
                // Create solution for last monday in May
                //#endif

                MonthDay.of(Month.JULY, 4), //

                //#if (TARGET=="SOLUTION")
                from(of(year.getValue(), SEPTEMBER, 1).with(firstInMonth(MONDAY))), //
                //#else
                // Create solution for first monday in September
                //#endif

                calculateDayOfMonth(year, OCTOBER, MONDAY, 2), //
                MonthDay.of(NOVEMBER, 11), //
                calculateDayOfMonth(year, NOVEMBER, DayOfWeek.THURSDAY, 4), //
                MonthDay.of(Month.DECEMBER, 25));
    }

    public static long countWorkingDays(Year year) {
        //#if (TARGET=="SOLUTION")
        LocalDate startOfYear = MonthDay.of(Month.JANUARY, 1).atYear(year.getValue());
        LocalDate endOfYear = MonthDay.of(Month.DECEMBER, 31).atYear(year.getValue()).plusDays(1);
        Stream<LocalDate> daysFromStartOfYear = Stream.iterate(startOfYear, d -> d.plusDays(1));
        return takeWhile(daysFromStartOfYear, day -> day.isBefore(endOfYear)).filter(
                isDayInWeekend().negate().and(
                        day -> day.query(q -> !createFederalHolidays(year).contains(MonthDay.from(q))))).count();
        //#else
        //$return year.length();
        //#endif
    }

    private static Predicate<LocalDate> isDayInWeekend() {
        return d -> {
            return d.getDayOfWeek() == DayOfWeek.SATURDAY || d.getDayOfWeek() == DayOfWeek.SUNDAY;
        };
    }

}
