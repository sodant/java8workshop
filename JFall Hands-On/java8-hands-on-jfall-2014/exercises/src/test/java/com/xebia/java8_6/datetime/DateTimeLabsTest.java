package com.xebia.java8_6.datetime;

import static com.xebia.java8_6.datetime.DateTimeLabs.calculateAge;
import static com.xebia.java8_6.datetime.DateTimeLabs.calculateDayOfMonth;
import static com.xebia.java8_6.datetime.DateTimeLabs.countWorkingDays;
import static com.xebia.java8_6.datetime.DateTimeLabs.createFederalHolidays;
import static java.time.DayOfWeek.MONDAY;
import static java.time.Month.JANUARY;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;

import java.time.LocalDate;
import java.time.Month;
import java.time.MonthDay;
import java.time.Year;

import org.hamcrest.Matchers;
import org.junit.Test;

public class DateTimeLabsTest {

    @Test
    public void ageCalculator() {
        assertThat(calculateAge(LocalDate.of(1980, Month.FEBRUARY, 1)), Matchers.startsWith("34 years"));
    }

    @Test
    public void calculateMartinLutherKingDayIn2014() {
        assertThat(calculateDayOfMonth(Year.of(2014), JANUARY, MONDAY, 3), equalTo(MonthDay.of(JANUARY, 20)));
    }

    @Test
    public void calculateMartinLutherKingDayIn2015() {
        assertThat(calculateDayOfMonth(Year.of(2015), JANUARY, MONDAY, 3), equalTo(MonthDay.of(JANUARY, 19)));
    }

    @Test
    public void calculateMartinLutherKingDayIn2013() {
        assertThat(calculateDayOfMonth(Year.of(2013), JANUARY, MONDAY, 3), equalTo(MonthDay.of(JANUARY, 21)));
    }

    @Test
    public void allFederalHolidays() {
        assertThat(createFederalHolidays(Year.of(2014)), hasSize(10));
    }

    @Test
    public void testCountWorkingDays() {
        assertThat(countWorkingDays(Year.of(2014)), equalTo(251L));
    }

}
