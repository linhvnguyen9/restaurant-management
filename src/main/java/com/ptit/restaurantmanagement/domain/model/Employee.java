package com.ptit.restaurantmanagement.domain.model;

import java.util.Calendar;

public class Employee extends Person {
    private EmployeeType employeeType;
    private Integer managerId; //nullable
    private double baseSalary;
    private TimeSheet timeSheet = new TimeSheet();

    public Employee(int id, String name, Calendar dob, String address, EmployeeType employeeType, Integer managerId, Double baseSalary) {
        super(id, name, dob, address);
        this.employeeType = employeeType;
        this.managerId = managerId;
        this.baseSalary = baseSalary;
    }

    public Employee(String name, Calendar dob, String address, EmployeeType employeeType, Integer managerId, Double baseSalary) {
        super(name, dob, address);
        this.employeeType = employeeType;
        this.managerId = managerId;
        this.baseSalary = baseSalary;
    }

    public EmployeeType getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(EmployeeType employeeType) {
        this.employeeType = employeeType;
    }

    public int getManagerId() {
        if (managerId == null)
            return -1;
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
        int workingDays = timeSheet.getWorkdays(month, year);

        return workingDays * baseSalary;
    }

    public TimeSheet getTimeSheet() {
        return timeSheet;
    }

    public void setWorkingDays(int month, int year, int workDays) {
        timeSheet.setWorkdays(month, year, workDays);
    }
    
    
    public Object[] toObject() {
        return new Object[]{
                getId(), getName(), getFormattedDob(), getAddress(), getEmployeeType(), getPhoneNumbersString(),
                managerId, baseSalary
        };
    }

    @Override
    public String toString() {
        return super.toString() + "Employee{" +
                "employeeType=" + employeeType +
                ", managerId=" + managerId +
                ", baseSalary=" + baseSalary +
                ", timeSheet=" + timeSheet +
                '}';
    }
}
