package com.ptit.restaurantmanagement.domain.model;

import java.time.YearMonth;
import java.util.HashMap;

public class TimeSheet {
    private HashMap<YearMonth, Integer> workingDays = new HashMap<>();

    public int getWorkdays(int month, int year) {
        YearMonth query = YearMonth.parse(year + "-" + String.format("%02d", month));
        return workingDays.get(query);
    }

    public void setWorkdays(int month, int year, int workdays) throws IllegalArgumentException {
        YearMonth query = YearMonth.parse(year + "-" + String.format("%02d", month));
        int daysOfMonth = query.lengthOfMonth();

        if (workdays < 0 || workdays > daysOfMonth)
            throw new IllegalArgumentException("Invalid workdays count");

        workingDays.put(query, workdays);
    }
}
