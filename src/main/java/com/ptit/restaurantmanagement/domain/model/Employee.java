package com.ptit.restaurantmanagement.domain.model;

import java.util.Calendar;

public class Employee extends Person {
    private int employeeType; //TODO: Define employee types
    private Integer managerId; //nullable
    private double baseSalary;
    private TimeSheet timeSheet = new TimeSheet();

    public Employee(int id, String name, Calendar dob, String address, Integer employeeType, Integer managerId, Double baseSalary) {
        super(id, name, dob, address);
        this.employeeType = employeeType;
        this.managerId = managerId;
        this.baseSalary = baseSalary;
    }

    public Employee(String name, Calendar dob, String address, Integer employeeType, Integer managerId, Double baseSalary) {
        super(name, dob, address);
        this.employeeType = employeeType;
        this.managerId = managerId;
        this.baseSalary = baseSalary;
    }

    public int getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(int employeeType) {
        this.employeeType = employeeType;
    }

    public int getManagerId() {
        return managerId;
    }

    public void setManagerId(int managerId) {
        this.managerId = managerId;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public double getSalaryByMonth(int month, int year) {
        int workingDays = timeSheet.getWorkingDays(month, year);

        return workingDays * baseSalary;
    }

    public TimeSheet getTimeSheet() {
        return timeSheet;
    }

    public void setWorkingDays(int month, int year, int workDays) {
        timeSheet.setWorkingDays(month, year, workDays);
    }
}
