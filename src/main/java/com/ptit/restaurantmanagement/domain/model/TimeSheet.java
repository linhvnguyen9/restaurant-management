package com.ptit.restaurantmanagement.domain.model;

import java.time.YearMonth;
import java.util.HashMap;

public class TimeSheet {
    private int employeeId;
    private int month;
    private int year;
    private int workdays;

    public TimeSheet(int month, int year, int workdays) {
        this.month = month;
        this.year = year;
        this.workdays = workdays;
    }

    public TimeSheet(int employeeId, int month, int year, int workdays) {
        this.employeeId = employeeId;
        this.month = month;
        this.year = year;
        this.workdays = workdays;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getWorkdays() {
        return workdays;
    }

    public void setWorkdays(int workdays) {
        this.workdays = workdays;
    }

    @Override
    public String toString() {
        return "TimeSheet{" +
                "employeeId=" + employeeId +
                ", month=" + month +
                ", year=" + year +
                ", workdays=" + workdays +
                '}';
    }
    public Object[] toObject(){
        return new Object[]{getEmployeeId(),getMonth(),getYear(),getWorkdays()
        };
    }
}
