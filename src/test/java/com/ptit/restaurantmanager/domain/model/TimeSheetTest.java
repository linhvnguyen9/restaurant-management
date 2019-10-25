package com.ptit.restaurantmanager.domain.model;

import com.ptit.restaurantmanagement.domain.model.TimeSheet;
import org.junit.jupiter.api.Test;

import java.time.format.DateTimeParseException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TimeSheetTest {
    TimeSheet timeSheet = new TimeSheet();

    @Test
    void setAndGetWorkdays() {
        int workdays = 10;

        timeSheet.setWorkdays(10, 2019, workdays);
        assertEquals(workdays, timeSheet.getWorkdays(10, 2019));
    }

    @Test
    void updateWorkdays() {
        int oldWorkdays = 10;
        int newWorkdays = 30;

        timeSheet.setWorkdays(10, 2019, oldWorkdays);
        timeSheet.setWorkdays(10, 2019, newWorkdays);
        assertEquals(newWorkdays, timeSheet.getWorkdays(10, 2019));
    }

    @Test
    void illegalMonthInputShouldThrowsException() {
        int illegalMonth = 0;
        assertThrows(DateTimeParseException.class, () -> timeSheet.setWorkdays(illegalMonth, 2019, 10));
    }

    @Test
    void illegalYearInputShouldThrowsException() {
        int illegalYear = -99;
        assertThrows(DateTimeParseException.class, () -> timeSheet.setWorkdays(10, illegalYear, 10));
    }

    @Test
    void illegalWorkdaysInputShouldThrowsException() {
        int illegalWorkdays = 29;
        assertThrows(IllegalArgumentException.class, () -> timeSheet.setWorkdays(2, 2019, illegalWorkdays));
    }

    @Test
    void leapYear() {
        timeSheet.setWorkdays(2, 2016, 29);
        assertEquals(29, timeSheet.getWorkdays(2, 2016));
    }

    @Test
    void monthsBeforeOctober() {
        timeSheet.setWorkdays(3, 2016, 10);
        assertEquals(10, timeSheet.getWorkdays(3, 2016));
    }
}
