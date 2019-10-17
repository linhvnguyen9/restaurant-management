package com.ptit.restaurantmanagement.domain.model;

import java.util.Calendar;

public class Customer extends Person {
    private int customerType; //TODO: Define customer types
    //View to select customer type should be a drop down list / checkbox

    public Customer(int id, String name, Calendar dob, String address, int customerType) {
        super(id, name, dob, address);
        this.customerType = customerType;
    }

    public Customer(String name, Calendar dob, String address, int customerType) {
        super(name, dob, address);
        this.customerType = customerType;
    }

    public int getCustomerType() {
        return customerType;
    }

    public void setCustomerType(int customerType) {
        this.customerType = customerType;
    }

    public String getCustomerTypeString() {
        //TODO
        return "";
    }
}
