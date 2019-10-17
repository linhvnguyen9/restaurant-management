package com.ptit.restaurantmanagement.domain.model;

import java.time.YearMonth;
import java.util.HashMap;

class TimeSheet {
    private HashMap<YearMonth, Integer> workingDays;

    int getWorkingDays(int month, int year) {
        //TODO: Handle case getting invalid month
        //TODO: Test function
        YearMonth query = YearMonth.parse(year + "-" + month);
        return workingDays.get(query);
    }

    void setWorkingDays(int month, int year, int workdays) {
        //TODO: properly implement this method - enter month that already exists -> modify
        //enter new month - insert into HashMap
        //enter invalid month -> throw IllegalArgumentException

        this.workingDays = workingDays;
    }
}
