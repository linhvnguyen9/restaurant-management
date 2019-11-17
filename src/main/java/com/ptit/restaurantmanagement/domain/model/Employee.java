package com.ptit.restaurantmanagement.domain.model;

import java.util.Calendar;

public class Employee extends Person {
    private EmployeeType employeeType;
    private Integer managerId; //nullable
    private double baseSalary;

    public Employee(int id, String name, Calendar dob, String address, String phoneNumber, EmployeeType employeeType, Integer managerId, Double baseSalary) {
        super(id, name, dob, address, phoneNumber);
        this.employeeType = employeeType;
        this.managerId = managerId;
        this.baseSalary = baseSalary;
    }

    public Employee(String name, Calendar dob, String address, String phoneNumber, EmployeeType employeeType, Integer managerId, Double baseSalary) {
        super(name, dob, address, phoneNumber);
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

 
    
    public Object[] toObject() {
        return new Object[]{
                getId(), getName(), getFormattedDob(), getAddress(), getEmployeeType(), getPhoneNumber(),
                managerId, baseSalary
        };
    }

    @Override
    public String toString() {
        return super.toString() + "Employee{" +
                "employeeType=" + employeeType +
                ", managerId=" + managerId +
                ", baseSalary=" + baseSalary+
                '}';
    }
}
